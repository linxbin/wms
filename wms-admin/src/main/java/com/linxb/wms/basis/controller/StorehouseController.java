package com.linxb.wms.basis.controller;

import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseAddRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseModifyRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseQueryRequest;
import com.linxb.wms.basis.service.IStorehouseService;
import com.linxb.wms.common.vo.request.IdRequest;
import com.linxb.wms.common.vo.response.ApiResult;
import com.linxb.wms.common.vo.response.PageBaseResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linxb
 * @since 2024-06-05
 */
@RestController
@RequestMapping("/storehouse")
public class StorehouseController {

    @Autowired
    private IStorehouseService storehouseService;

    @PostMapping("/add")
    @ApiOperation("新增仓库")
    public ApiResult<Void> add(@Valid @RequestBody StorehouseAddRequest req) {
        storehouseService.add(req);
        return ApiResult.success();
    }

    @PutMapping("/modify")
    @ApiOperation("修改仓库")
    public ApiResult<Void> modify(@Valid @RequestBody StorehouseModifyRequest req) {
        storehouseService.modify(req);
        return ApiResult.success();
    }

    @GetMapping("/detail")
    @ApiOperation("仓库详情")
    public ApiResult<Storehouse> detail(@Valid IdRequest req) {
        Storehouse detail = storehouseService.detail(req.getId());
        return ApiResult.success(detail);
    }

    @GetMapping("/list")
    @ApiOperation("仓库列表")
    public ApiResult<PageBaseResp<Storehouse>> getList(@Valid StorehouseQueryRequest request) {
        PageBaseResp<Storehouse> list = storehouseService.getList(request);
        return ApiResult.success(list);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除仓库")
    public ApiResult<Void> delete(@Valid IdRequest request) {
        storehouseService.delete(request);
        return ApiResult.success();
    }

}
