package org.shay.education.utils;

import org.shay.education.Constants;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * @author shay
 * @date 2020/6/8
 */
public class CommonUtils {

    /**
     * 判断
     *
     * @return shay 等待
     */
    private static boolean isLocalDev() {
        String osName = System.getProperty("os.name");
        return StringUtils.hasText(osName) && !(Constants.OS_NAME_LINUX.equals(osName.toUpperCase()));
    }

    /**
     * 设置启动参数
     *
     * @param appName appName
     * @param profile profile
     */
    public static void setUpProperties(String appName, String profile) {
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
        props.setProperty("spring.cloud.nacos.config.prefix", appName);
        props.setProperty("spring.cloud.nacos.config.file-extension", Constants.NACOS_CONFIG_FORMAT);

        props.setProperty("spring.cloud.sentinel.transport.dashboard", Constants.sentinelAddr(profile));
        //开启Sentinel熔断器
        props.setProperty("feign.sentinel.enabled", "true");
        props.setProperty("spring.cloud.alibaba.seata.tx-service-group", appName.concat(Constants.NACOS_GROUP_SUFFIX));
        if (isLocalDev()) {
            //开启spring-boot-starter-actuator
            props.setProperty("management.endpoints.web.exposure.include", "*");
        }
    }
}
