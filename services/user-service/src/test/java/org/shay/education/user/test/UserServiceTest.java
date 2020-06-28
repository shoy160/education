package org.shay.education.user.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shay.education.Constants;
import org.shay.education.dto.PagedDTO;
import org.shay.education.test.EducationTest;
import org.shay.education.test.EducationTestRunner;
import org.shay.education.user.UserApplication;
import org.shay.education.user.dto.UserDTO;
import org.shay.education.user.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@RunWith(EducationTestRunner.class)
@SpringBootTest(classes = UserApplication.class)
@EducationTest(appName = Constants.APP_NAME_USER, enableLoader = true)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void getUserTest() {
        PagedDTO<UserDTO> pagedDto = userService.search(1, 10);
        Assert.assertEquals(10, pagedDto.getList().size());
    }
}
