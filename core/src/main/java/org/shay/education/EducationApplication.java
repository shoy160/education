package org.shay.education;

import org.shay.education.launcher.LauncherService;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.*;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shay
 * @date 2020/6/8
 */
public class EducationApplication {

    public static ConfigurableApplicationContext run(String appName, Class source, String... args) {
        SpringApplicationBuilder builder = createSpringApplicationBuilder(appName, source, args);
        return builder.run(args);
    }

    private static SpringApplicationBuilder createSpringApplicationBuilder(String appName, Class source, String... args) {
        Assert.hasText(appName, "[appName]不能为空");
        // 读取环境变量，使用spring boot的规则
        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new SimpleCommandLinePropertySource(args));
        propertySources.addLast(new MapPropertySource(StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME, environment.getSystemProperties()));
        propertySources.addLast(new SystemEnvironmentPropertySource(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, environment.getSystemEnvironment()));
        // 获取配置的环境变量
        String[] activeProfiles = environment.getActiveProfiles();
        // 判断环境:dev、test、prod
        List<String> profiles = Arrays.asList(activeProfiles);
        // 预设的环境
        List<String> presetProfiles = new ArrayList<>(Arrays.asList(Constants.MODE_DEV, Constants.MODE_TEST, Constants.MODE_PROD));
        // 交集
        profiles.retainAll(presetProfiles);
        // 当前使用
        List<String> activeProfileList = new ArrayList<>(profiles);
        Function<Object[], String> joinFun = StringUtils::arrayToCommaDelimitedString;
        SpringApplicationBuilder builder = new SpringApplicationBuilder(source);
        String profile;
        if (activeProfileList.isEmpty()) {
            // 默认dev开发
            profile = Constants.MODE_DEV;
            activeProfileList.add(profile);
            builder.profiles(profile);
        } else if (activeProfileList.size() == 1) {
            profile = activeProfileList.get(0);
        } else {
            // 同时存在dev、test、prod环境时
            throw new RuntimeException("同时存在环境变量:[" + StringUtils.arrayToCommaDelimitedString(activeProfiles) + "]");
        }
        String startJarPath = EducationApplication.class.getResource("/").getPath().split("!")[0];
        String activePros = joinFun.apply(activeProfileList.toArray());
        System.out.println(String.format("----启动中，读取到的环境变量:[%s]，jar地址:[%s]----", activePros, startJarPath));
        Properties props = System.getProperties();
        props.setProperty("spring.application.name", appName);
        props.setProperty("spring.profiles.active", profile);
        props.setProperty("info.version", Constants.APPLICATION_VERSION);
        props.setProperty("info.desc", appName);
        props.setProperty("spring.main.allow-bean-definition-overriding", "true");
        props.setProperty("spring.cloud.nacos.discovery.server-addr", Constants.nacosAddr(profile));
        props.setProperty("spring.cloud.nacos.discovery.namespace", Constants.NACOS_NAMESPACE);
        props.setProperty("spring.cloud.nacos.discovery.group", Constants.NACOS_GROUP);

        props.setProperty("spring.cloud.nacos.config.server-addr", Constants.nacosAddr(profile));
        props.setProperty("spring.cloud.nacos.config.namespace", Constants.NACOS_NAMESPACE);
        props.setProperty("spring.cloud.nacos.config.group", Constants.NACOS_GROUP);
        props.setProperty("spring.cloud.nacos.config.prefix", Constants.NACOS_CONFIG_PREFIX);
        props.setProperty("spring.cloud.nacos.config.prefix", appName);
        props.setProperty("spring.cloud.nacos.config.file-extension", Constants.NACOS_CONFIG_FORMAT);

        props.setProperty("spring.cloud.sentinel.transport.dashboard", Constants.sentinelAddr(profile));
        //开启Sentinel熔断器
        props.setProperty("feign.sentinel.enabled", "true");
        props.setProperty("spring.cloud.alibaba.seata.tx-service-group", appName.concat(Constants.NACOS_GROUP_SUFFIX));

        boolean isLocal = isLocalDev();
        if (isLocal) {
            //开启spring-boot-starter-actuator
            props.setProperty("management.endpoints.web.exposure.include", "*");
        }
        // 加载自定义组件
        List<LauncherService> launcherList = new ArrayList<>();
        ServiceLoader.load(LauncherService.class).forEach(launcherList::add);
        launcherList.stream().sorted(Comparator.comparing(LauncherService::getOrder)).collect(Collectors.toList())
                .forEach(launcherService -> launcherService.launcher(builder, appName, profile));
        return builder;
    }

    /**
     * 判断
     *
     * @return shay 等待
     */
    private static boolean isLocalDev() {
        String osName = System.getProperty("os.name");
        return StringUtils.hasText(osName) && !(Constants.OS_NAME_LINUX.equals(osName.toUpperCase()));
    }
}
