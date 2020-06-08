package org.shay.education.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDto;
import org.shay.education.system.enums.TagType;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
@AllArgsConstructor
public class TagInputDto extends BaseDto {
    private TagType type;
    private String name;
}
