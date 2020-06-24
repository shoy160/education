package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.NormalStatus;
import org.shay.education.system.enums.TagType;

/**
 * @author shay
 * @date 2020/6/8
 */
@Getter
@Setter
public class TagDTO extends BaseDTO {
    private Integer id;
    private String name;
    private TagType type;
    private String fullPinyin;
    private String simplePinyin;
    private Integer count;
    private NormalStatus status;
}
