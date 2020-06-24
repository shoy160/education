package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.NormalStatus;

import java.time.OffsetDateTime;

/**
 * 选修课批次
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class ElectiveBatchDTO extends BaseDTO {
    private String id;
    /**
     * 批次标题
     */
    private String title;
    /**
     * 所属机构
     */
    private String agencyId;
    /**
     * 状态
     */
    private NormalStatus status;
    /**
     * 创建时间
     */
    private OffsetDateTime addedAt;
    /**
     * 创建人
     */
    private Long addedBy;
}
