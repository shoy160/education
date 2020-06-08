package org.shay.education.system.client.fallback;

import com.sun.istack.internal.Nullable;
import org.shay.education.dto.PagedDto;
import org.shay.education.system.client.TagClient;
import org.shay.education.system.dto.TagDto;
import org.shay.education.system.dto.TagInputDto;
import org.shay.education.system.enums.TagType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * @author shay
 * @date 2020/6/8
 */
@Component
public class TagClientFallback implements TagClient {
    @Override
    public int addTag(@RequestBody TagInputDto dto) {
        return 0;
    }

    @Override
    public PagedDto<TagDto> getTags(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(name = "type", required = false) @Nullable TagType type
    ) {
        return new PagedDto<>(0, new ArrayList<>());
    }
}
