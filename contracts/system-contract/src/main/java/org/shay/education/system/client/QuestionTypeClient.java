package org.shay.education.system.client;

import org.shay.education.Constants;
import org.shay.education.dto.PagedDTO;
import org.shay.education.system.dto.QuestionTypeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 题型服务
 *
 * @author shay
 */
public interface QuestionTypeClient {
    String API_PREFIX = Constants.FEIGN_ROUTE_PREFIX + "question_type";

    /**
     * 获取题型信息
     *
     * @param type
     * @return
     */
    @GetMapping(API_PREFIX + "/{type}")
    QuestionTypeDTO get(@PathVariable int type);

    /**
     * 题型列表
     *
     * @param page page
     * @param size size
     * @return
     */
    @GetMapping(API_PREFIX)
    PagedDTO<QuestionTypeDTO> paged(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    );
}
