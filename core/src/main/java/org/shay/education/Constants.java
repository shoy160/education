package org.shay.education;

import java.util.HashMap;
import java.util.Properties;

/**
 * @author shay
 * @date 2020/6/8
 */
public interface Constants {
    String APPLICATION_VERSION = "0.0.1";

    String FEIGN_ROUTE_PREFIX = "/service-rpc/";

    /**
     * 基础包
     */
    String BASE_PACKAGES = "org.shay.education";

    /**
     * admin service
     */
    String APP_NAME_ADMIN = "admin";

    String APP_NAME_USER = "user-service";
    String APP_NAME_AUTH = "auth-service";
    String APP_NAME_SYSTEM = "system-service";

    String MODE_DEV = "dev";

    String MODE_TEST = "test";

    String MODE_PROD = "prod";

    /**
     * 代码部署于 linux 上，工作默认为 mac 和 Windows
     */
    String OS_NAME_LINUX = "LINUX";

    HashMap<String, String> NACOS_ADDR = new HashMap<String, String>() {
        {
            put(MODE_DEV, "182.151.21.90:8848");
            put(MODE_TEST, "182.151.21.90:8848");
            put(MODE_PROD, "127.0.0.1:8848");
        }
    };
    String NACOS_NAMESPACE = "education";
    String NACOS_GROUP = "DEFAULT_GROUP";
    String NACOS_GROUP_TEST = "EDU_TEST";

    HashMap<String, String> SENTINEL_ADDR = new HashMap<String, String>() {
        {
            put(MODE_DEV, "182.151.21.90:8858");
            put(MODE_TEST, "182.151.21.90:8858");
            put(MODE_PROD, "127.0.0.1:8848");
        }
    };

    HashMap<String, String> ZIPKIN_ADDR = new HashMap<String, String>() {
        {
            put(MODE_DEV, "182.151.21.90:9411");
            put(MODE_TEST, "182.151.21.90:9411");
            put(MODE_PROD, "127.0.0.1:9411");
        }
    };

    String NACOS_CONFIG_GROUP = "DEFAULT_GROUP";

    String NACOS_GROUP_SUFFIX = "-group";

    String NACOS_CONFIG_FORMAT = "yaml";

    /**
     * nacos addr
     *
     * @param props   系统变量
     * @param appName 应用名
     * @param mode    运模式
     */
    static void nacosConfig(Properties props, String appName, String mode) {
        String url, group;
        if (NACOS_ADDR.containsKey(mode)) {
            url = NACOS_ADDR.get(mode);
        } else {
            url = NACOS_ADDR.get(MODE_DEV);
        }
        if (MODE_TEST.equals(mode)) {
            group = NACOS_GROUP_TEST;
        } else {
            group = NACOS_GROUP;
        }

        props.setProperty("spring.cloud.nacos.discovery.server-addr", url);
        props.setProperty("spring.cloud.nacos.discovery.namespace", NACOS_NAMESPACE);
        props.setProperty("spring.cloud.nacos.discovery.group", group);

        props.setProperty("spring.cloud.nacos.config.server-addr", url);
        props.setProperty("spring.cloud.nacos.config.namespace", NACOS_NAMESPACE);
        props.setProperty("spring.cloud.nacos.config.group", NACOS_CONFIG_GROUP);
        props.setProperty("spring.cloud.nacos.config.prefix", appName);
        props.setProperty("spring.cloud.nacos.config.file-extension", NACOS_CONFIG_FORMAT);
    }

    /**
     * sentinel addr
     *
     * @param mode 模式
     * @return String
     */
    static String sentinelAddr(String mode) {
        if (SENTINEL_ADDR.containsKey(mode)) {
            return SENTINEL_ADDR.get(mode);
        }
        return SENTINEL_ADDR.get(MODE_DEV);
    }

    /**
     * zipkin addr
     *
     * @param mode 模式
     * @return String
     */
    static String zipkinAddr(String mode) {
        if (ZIPKIN_ADDR.containsKey(mode)) {
            return ZIPKIN_ADDR.get(mode);
        }
        return ZIPKIN_ADDR.get(MODE_DEV);
    }
}
