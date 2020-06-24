package org.shay.education.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.shay.education.BaseController;
import org.shay.education.dto.PagedDTO;
import org.shay.education.dto.ResultDTO;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.dto.TagInputDTO;
import org.shay.education.system.enums.TagType;
import org.shay.education.user.dto.UserDto;
import org.shay.education.user.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author shay
 * @date 2020/6/8
 */
@RestController
@RequestMapping("api/user")
@Api(value = "User", tags = "User服务")
@AllArgsConstructor
public class UserController extends BaseController {
    private UserService userService;
    private TagClient tagClient;

    @GetMapping("")
    @ApiOperation(value = "用户查询", notes = "用户查询")
    public ResultDTO<PagedDTO<UserDto>> getUsers(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        PagedDTO<UserDto> pagedDto = userService.search(page, size);
        return success(pagedDto);
    }

    @PostMapping("tag")
    @ApiOperation(value = "添加标签")
    public ResultDTO<Integer> addTag(@RequestBody TagInputDTO dto) {
        int result = tagClient.addTag(dto);
        return success(result);
    }

    @GetMapping("tag")
    @ApiOperation(value = "标签分页")
    public ResultDTO<PagedDTO<TagDTO>> tagList(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(value = "type", required = false) TagType type
    ) {
        PagedDTO<TagDTO> paged = tagClient.getTags(page, size, type);
        return success(paged);
    }
}
