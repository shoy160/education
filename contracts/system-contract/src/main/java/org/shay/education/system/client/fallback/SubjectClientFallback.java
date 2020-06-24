package org.shay.education.system.client.fallback;

import org.shay.education.dto.PagedDTO;
import org.shay.education.system.client.SubjectClient;
import org.shay.education.system.dto.SubjectDTO;
import org.springframework.stereotype.Component;

/**
 * 科目服务 熔断
 *
 * @author shay
 */
@Component
public class SubjectClientFallback implements SubjectClient {
    @Override
    public SubjectDTO get(String id) {
        return null;
    }

    @Override
    public PagedDTO<SubjectDTO> paged(int page, int size) {
        return null;
    }
}
