package org.shay.education.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.shay.education.Constants;
import org.shay.education.EducationApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shay
 * @date 2020/6/8
 */
@EnableAdminServer
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        EducationApplication.run(Constants.APP_NAME_ADMIN, AdminApplication.class, args);
    }
}
