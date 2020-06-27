package org.shay.education.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.shay.education.dto.BaseDTO;
import org.shay.education.dto.BaseTimedDTO;

/**
 * 机构实体
 *
 * @author shay
 * @date 2020/6/27
 */
@Getter
@Setter
public class AgencyDTO extends BaseTimedDTO {
    private String id;
    /**
     * 机构名
     */
    private String name;
    /**
     * 机构编码
     */
    private String code;
    /**
     * 机构Logo
     */
    private String logo;
    /**
     * 机构主页
     */
    private String homePage;
    /**
     * 机构简介
     */
    private String brief;
    /**
     * 机构地址
     */
    private String address;
    /**
     * 机构区域
     */
    private Integer area;
    /**
     * 机构类型
     */
    private Short type;
    /**
     * 机构徽章
     */
    private String badgeFile;
    /**
     * 机构学段列表
     */
    private String stages;
    /**
     * 试卷封面
     */
    private String paperFront;
    /**
     * 试卷背面
     */
    private String paperBack;
}
