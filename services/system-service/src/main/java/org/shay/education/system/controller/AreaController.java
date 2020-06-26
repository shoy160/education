package org.shay.education.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.shay.education.dto.ResultDTO;
import org.shay.education.system.dto.AreaDTO;
import org.shay.education.system.entity.AreaTable;
import org.shay.education.system.service.AreaService;
import org.shay.education.web.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author shay
 * @date 2020/6/25
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/area")
@Api(value = "Area", tags = "区域接口")
public class AreaController extends BaseController {
    private AreaService service;

    /**
     * 获取区域信息
     *
     * @param code 区域编码
     * @return
     */
    @GetMapping("{code}")
    @ApiOperation(value = "获取区域信息")
    public ResultDTO<AreaDTO> get(@PathVariable int code) {
        AreaTable model = service.getById(code);
        if (model == null) {
            return null;
        }
        AreaDTO dto = model.toDTO();
        return success(dto);
    }


    /**
     * 获取子集区域
     *
     * @param parentCode 父级区域编码
     * @return
     */
    @GetMapping("children/{parentCode}")
    @ApiOperation(value = "获取子集区域")
    public ResultDTO<List<AreaDTO>> getChildren(@PathVariable int parentCode) {
        QueryWrapper<AreaTable> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AreaTable::getParentCode, parentCode);
        List<AreaTable> list = service.list(queryWrapper);
        List<AreaDTO> dtoList = new ArrayList<>();
        for (AreaTable model : list) {
            AreaDTO dto = model.toDTO();
            dtoList.add(dto);
        }
        return success(dtoList);
    }
}
