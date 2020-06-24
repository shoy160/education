package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.NormalStatus;

import java.time.OffsetDateTime;

/**
 * 选课详情
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class ElectiveDetailDTO extends BaseDTO {
    private String id;
    /**
     * 选课批次
     */
    private String batch;
    /**
     * 班级ID
     */
    private String classId;
    /**
     * 学生ID
     */
    private Long studentId;
    /**
     * 选修课ID
     */
    private Integer courseId;
    /**
     * 选课时间
     */
    private OffsetDateTime addedAt;
    /**
     * 选课状态
     */
    private NormalStatus status;
}
