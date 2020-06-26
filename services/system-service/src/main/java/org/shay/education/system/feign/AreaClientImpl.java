package org.shay.education.system.feign;

import org.shay.education.web.BaseClient;
import org.shay.education.system.client.AreaClient;
import org.shay.education.system.dto.AreaDTO;
import org.shay.education.system.entity.AreaTable;
import org.shay.education.system.service.AreaService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shay
 * @date 2020/6/24
 */
@ApiIgnore
@RestController
@RequestMapping()
@Scope("prototype")
public class AreaClientImpl extends BaseClient implements AreaClient {
    @Resource
    private AreaService service;

    @Override
    @GetMapping(API_PREFIX + "/{code}")
    public AreaDTO get(@PathVariable int code) {
        AreaTable model = service.getById(code);
        if (model == null) {
            return null;
        }
        return model.toDTO();
    }

    @Override
    @GetMapping(API_PREFIX + "/children/{parentCode}")
    public List<AreaDTO> getChildren(@PathVariable int parentCode) {
        return null;
    }
}
