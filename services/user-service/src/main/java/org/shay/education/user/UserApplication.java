package org.shay.education.user;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.shay.education.Constants;
import org.shay.education.EducationApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author shay
 * @date 2020/6/8
 */
@SpringCloudApplication
@EnableFeignClients(Constants.BASE_PACKAGES)
@ComponentScan(Constants.BASE_PACKAGES)
public class UserApplication {
    public static void main(String[] args) {
        EducationApplication.run(Constants.APP_NAME_USER, UserApplication.class, args);
    }

    /**
     * MP分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
