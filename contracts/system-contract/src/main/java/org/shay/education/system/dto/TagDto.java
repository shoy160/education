package org.shay.education.system.dto;

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
public class TagDto extends BaseDto {
    private int id;
    private String name;
    private TagType type;
    private String fullPinyin;
    private String simplePinyin;
    private int count;
}
