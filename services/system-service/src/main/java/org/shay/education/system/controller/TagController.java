package org.shay.education.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.shay.education.BaseController;
import org.shay.education.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shay
 * @date 2020/6/8
 */
@RestController
@RequestMapping("api/tag")
@Api(value = "Tag", tags = "标签接口")
public class TagController extends BaseController {

    @GetMapping("hello")
    @ApiOperation("Hello服务")
    public ResultDto<String> hello(String name) {
        return success(String.format("hello %s !", name));
    }
}
