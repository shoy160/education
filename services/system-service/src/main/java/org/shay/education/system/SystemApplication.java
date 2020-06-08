package org.shay.education.system;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.shay.education.EducationApplication;
import org.shay.education.Constants;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;

/**
 * System 服务
 *
 * @author shay
 * @date 2020/6/8
 */
@SpringCloudApplication
public class SystemApplication {
    public static void main(String[] args) {
        EducationApplication.run(Constants.APP_NAME_SYSTEM, SystemApplication.class, args);
    }

    /**
     * MP分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
