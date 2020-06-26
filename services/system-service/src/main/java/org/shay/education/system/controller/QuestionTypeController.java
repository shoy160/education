package org.shay.education.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.shay.education.dto.PagedDTO;
import org.shay.education.dto.ResultCode;
import org.shay.education.dto.ResultDTO;
import org.shay.education.system.dto.QuestionTypeDTO;
import org.shay.education.system.dto.SubjectDTO;
import org.shay.education.system.entity.QuestionTypeTable;
import org.shay.education.system.entity.SubjectTable;
import org.shay.education.system.service.QuestionTypeService;
import org.shay.education.web.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 题型接口
 *
 * @author shay
 * @date 2020/6/25
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/q-type")
@Api(value = "QuestionType", tags = "题型接口")
public class QuestionTypeController extends BaseController {
    private QuestionTypeService service;


    /**
     * 获取题型信息
     *
     * @return 题型实体
     */
    @GetMapping("{id}")
    @ApiOperation("获取题型信息")
    public ResultDTO<QuestionTypeDTO> get(@PathVariable int id) {
        QuestionTypeTable model = service.getById(id);
        if (model == null) {
            return fail(ResultCode.NOT_FOUND);
        }
        return success(model.toDTO());
    }

    /**
     * 题型列表
     *
     * @return 题型列表
     */
    @GetMapping
    @ApiOperation("题型列表")
    public ResultDTO<PagedDTO<QuestionTypeDTO>> paged(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PagedDTO<QuestionTypeDTO> pagedDTO = service.paged(page, size);
        return success(pagedDTO);
    }
}
