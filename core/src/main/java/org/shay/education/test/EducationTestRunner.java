package org.shay.education.test;

import org.junit.runners.model.InitializationError;
import org.shay.education.Constants;
import org.shay.education.EducationApplication;
import org.shay.education.launcher.LauncherService;
import org.shay.education.utils.CommonUtils;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shay
 * @date 2020/6/9
 */
public class EducationTestRunner extends SpringJUnit4ClassRunner {
    public EducationTestRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
        this.setUpTest(clazz);
    }

    private void setUpTest(Class<?> clazz) {
        EducationTest educationTest = AnnotationUtils.getAnnotation(clazz, EducationTest.class);
        if (educationTest == null) {
            throw new ExceptionInInitializerError("%s must be @EducationTest");
        }
        String appName = educationTest.appName();
        String profile = educationTest.profile();
        CommonUtils.setUpProperties(appName, profile);
        if (educationTest.enableLoader()) {
            List<LauncherService> launcherList = new ArrayList<>();
            SpringApplicationBuilder builder = new SpringApplicationBuilder(clazz);
            ServiceLoader.load(LauncherService.class).forEach(launcherList::add);
            launcherList.stream().sorted(Comparator.comparing(LauncherService::getOrder)).collect(Collectors.toList())
                    .forEach(launcherService -> launcherService.launcher(builder, appName, profile));
        }
        System.err.println(String.format("---[junit.test]:[%s]---启动中，读取到的环境变量:[%s]", appName, profile));
    }
}
