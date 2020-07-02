package org.shay.education.user.request;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.system.enums.TagType;

import javax.validation.constraints.NotBlank;

/**
 * @author shay
 * @date 2020/7/2
 */
@Getter
@Setter
public class TagCreateRequest {
    private TagType type;
    @NotBlank(message = "请输入标签")
    private String name;
}
