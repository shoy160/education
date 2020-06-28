package org.shay.education.test;

import org.junit.runners.model.InitializationError;
import org.shay.education.launcher.LauncherService;
import org.shay.education.utils.ServiceUtils;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import static org.springframework.core.annotation.AnnotationUtils.*;

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
        EducationTest educationTest = getAnnotation(clazz, EducationTest.class);
        if (educationTest == null) {
            throw new ExceptionInInitializerError("%s must be @EducationTest");
        }
        String appName = educationTest.appName();
        String profile = educationTest.profile();
        ServiceUtils.setUpProperties(appName, profile);
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
