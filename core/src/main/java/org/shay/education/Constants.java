package org.shay.education;

import java.util.HashMap;

/**
 * @author shay
 * @date 2020/6/8
 */
public interface Constants {
    String APPLICATION_VERSION = "0.0.1";

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
            put(MODE_DEV, "192.168.122.128:8848");
            put(MODE_TEST, "127.0.0.1:8848");
            put(MODE_PROD, "127.0.0.1:8848");
        }
    };
    String NACOS_NAMESPACE = "education";
    String NACOS_GROUP = "EDUCATION";

    HashMap<String, String> SENTINEL_ADDR = new HashMap<String, String>() {
        {
            put(MODE_DEV, "192.168.122.128:8858");
            put(MODE_TEST, "127.0.0.1:8848");
            put(MODE_PROD, "127.0.0.1:8848");
        }
    };

    HashMap<String, String> ZIPKIN_ADDR = new HashMap<String, String>() {
        {
            put(MODE_DEV, "192.168.122.128:9411");
            put(MODE_TEST, "127.0.0.1:9411");
            put(MODE_PROD, "127.0.0.1:9411");
        }
    };

    String NACOS_CONFIG_GROUP = "DEFAULT_GROUP";

    String NACOS_CONFIG_PREFIX = "education";

    String NACOS_GROUP_SUFFIX = "-group";

    String NACOS_CONFIG_FORMAT = "yaml";

    /**
     * nacos addr
     *
     * @param mode 运模式
     * @return String
     */
    static String nacosAddr(String mode) {
        if (NACOS_ADDR.containsKey(mode)) {
            return NACOS_ADDR.get(mode);
        }
        return NACOS_ADDR.get(MODE_DEV);
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
