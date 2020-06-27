package org.shay.education.system.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.enums.NormalStatus;

import java.time.OffsetDateTime;

/**
 * 选修课程实体
 *
 * @author shay
 * @date 2020/6/24
 */
@Getter
@Setter
public class ElectiveCourseDTO extends BaseDTO {
    private Integer id;
    /**
     * 选修课名称
     */
    private String name;
    /**
     * 选修课批次
     */
    private String batch;
    /**
     * 班级列表
     */
    private String[] classList;
    /**
     * 所属机构
     */
    private String agencyId;
    /**
     * 所属学段
     */
    private Short stage;
    /**
     * 所属年级
     */
    private Integer grade;
    /**
     * 上课地址
     */
    private String address;
    /**
     * 上课老师
     */
    private String teacher;
    /**
     * 班级容量
     */
    private Integer classCapacity;
    /**
     * 总容量
     */
    private Integer capacity;
    /**
     * 创建时间
     */
    private OffsetDateTime addedAt;
    /**
     * 创建人
     */
    private Long addedBy;
    /**
     * 状态
     */
    private NormalStatus status;
    /**
     * 已选人数
     */
    private Integer selectedCount;
}
