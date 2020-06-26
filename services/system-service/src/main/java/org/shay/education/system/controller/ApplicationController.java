package org.shay.education.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.shay.education.dto.PagedDTO;
import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDTO;
import org.shay.education.system.dto.ApplicationDTO;
import org.shay.education.system.dto.QuestionTypeDTO;
import org.shay.education.system.entity.ApplicationTable;
import org.shay.education.system.entity.QuestionTypeTable;
import org.shay.education.system.enums.ApplicationType;
import org.shay.education.system.service.ApplicationService;
import org.shay.education.web.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用接口
 *
 * @author shay
 * @date 2020/6/25
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/app")
@Api(value = "Application", tags = "应用接口")
public class ApplicationController extends BaseController {
    private ApplicationService service;

    /**
     * 获取应用信息
     *
     * @return 应用实体
     */
    @GetMapping("{id}")
    @ApiOperation("获取应用信息")
    public ResultDTO<ApplicationDTO> get(@PathVariable int id) {
        ApplicationTable model = service.getById(id);
        if (model == null) {
            return fail(ResultCode.NOT_FOUND);
        }
        return success(model.toDTO());
    }

    /**
     * 应用列表
     *
     * @return 应用列表
     */
    @GetMapping
    @ApiOperation("题型列表")
    public ResultDTO<PagedDTO<ApplicationDTO>> paged(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "type", required = false) ApplicationType type
    ) {
        PagedDTO<ApplicationDTO> pagedDTO = service.paged(page, size, type);
        return success(pagedDTO);
    }
}
