package org.shay.education.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.shay.education.dto.PagedDTO;
import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDTO;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.service.SubjectService;
import org.shay.education.web.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 科目接口
 *
 * @author shay
 * @date 2020/6/25
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/subject")
@Api(value = "Subject", tags = "科目接口")
public class SubjectController extends BaseController {
    private SubjectService service;

    /**
     * 获取科目信息
     *
     * @return 科目实体
     */
    @GetMapping("{id}")
    @ApiOperation("获取科目信息")
    public ResultDTO<SubjectDTO> get(@PathVariable int id) {
        SubjectTable model = service.getById(id);
        if (model == null) {
            return fail(ResultCode.NOT_FOUND);
        }
        return success(model.toDTO());
    }

    /**
     * 科目列表
     *
     * @return 列表
     */
    @GetMapping
    @ApiOperation("科目列表")
    public ResultDTO<PagedDTO<SubjectDTO>> paged(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PagedDTO<SubjectDTO> pagedDTO = service.paged(page, size);
        return success(pagedDTO);
    }
}
