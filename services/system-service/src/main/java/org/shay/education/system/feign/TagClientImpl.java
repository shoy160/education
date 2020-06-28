package org.shay.education.system.feign;

import org.shay.education.web.BaseClient;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDTO;
import org.shay.education.system.dto.TagInputDTO;
import org.shay.education.system.enums.TagType;
import org.shay.education.system.service.TagService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author shay
 * @date 2020/6/8
 */
@ApiIgnore
@RestController
@RequestMapping()
@Scope("prototype")
public class TagClientImpl extends BaseClient implements TagClient {

    @Resource
    private TagService service;

    @Override
    @PostMapping(API_PREFIX)
    public boolean addTag(@RequestBody TagInputDTO dto) {
        return service.add(dto);
    }

    @Override
    @GetMapping(API_PREFIX)
    public PagedDTO<TagDTO> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) TagType type
    ) {
        return service.search(page, size, type);
    }
}
