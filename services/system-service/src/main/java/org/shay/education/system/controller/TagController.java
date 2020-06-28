package org.shay.education.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.shay.education.dto.PagedDTO;
import org.shay.education.dto.ResultCode;
import org.shay.education.exception.BusinessException;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.entity.TagTable;
import org.shay.education.system.enums.TagType;
import org.shay.education.system.service.TagService;
import org.shay.education.web.BaseController;
import org.shay.education.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author shay
 * @date 2020/6/8
 */
@RestController
@RequestMapping("api/tag")
@AllArgsConstructor
@Api(value = "Tag", tags = "标签接口")
public class TagController extends BaseController {

    private TagService service;

    @GetMapping("hello")
    @ApiOperation("Hello服务")
    @ApiParam(name = "name", value = "名字")
    public ResultDTO<String> hello(String name) {
        String myName = "shay";
        if (myName.equals(name)) {
            throw new BusinessException(ResultCode.PARAM_VALID_ERROR);
        }
        return success(String.format("hello %s!", name));
    }

    @GetMapping("{id}")
    @ApiOperation("获取标签信息")
    public ResultDTO<TagDTO> get(@PathVariable int id) {
        TagTable model = service.getById(id);
        if (model == null) {
            return fail(ResultCode.NOT_FOUND);
        }
        return success(model.toDTO());
    }

    @GetMapping
    @ApiOperation("标签列表")
    public ResultDTO<PagedDTO<TagDTO>> paged(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "type", required = false) TagType type
    ) {
        PagedDTO<TagDTO> pagedDTO = service.search(page, size, type);
        return success(pagedDTO);
    }
}
