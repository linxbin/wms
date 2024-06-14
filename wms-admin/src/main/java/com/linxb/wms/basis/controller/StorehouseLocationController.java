package com.linxb.wms.basis.controller;

import com.linxb.wms.basis.domain.model.StorehouseLocation;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationQueryRequest;
import com.linxb.wms.basis.service.IStorehouseLocationService;
import com.linxb.wms.common.vo.request.IdRequest;
import com.linxb.wms.common.vo.response.ApiResult;
import com.linxb.wms.common.vo.response.PageBaseResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 库位 前端控制器
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@RestController
@RequestMapping("/storehouseLocation")
public class StorehouseLocationController {

    @Autowired
    private IStorehouseLocationService storehouseLocationService;

    @PostMapping("/add")
    @ApiOperation("新增仓库库位")
    public ApiResult<Void> add(@Valid @RequestBody StorehouseLocationAddRequest req) {
        storehouseLocationService.add(req);
        return ApiResult.success();
    }

    @PutMapping("/modify")
    @ApiOperation("修改仓库库位")
    public ApiResult<Void> modify(@Valid @RequestBody StorehouseLocationModifyRequest req) {
        storehouseLocationService.modify(req);
        return ApiResult.success();
    }

    @GetMapping("/detail")
    @ApiOperation("仓库库位详情")
    public ApiResult<StorehouseLocation> detail(@Valid IdRequest req) {
        StorehouseLocation detail = storehouseLocationService.detail(req.getId());
        return ApiResult.success(detail);
    }

    @GetMapping("/list")
    @ApiOperation("仓库库位列表")
    public ApiResult<PageBaseResp<StorehouseLocation>> getList(@Valid StorehouseLocationQueryRequest request) {
        PageBaseResp<StorehouseLocation> list = storehouseLocationService.getList(request);
        return ApiResult.success(list);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除仓库库位")
    public ApiResult<Void> delete(@Valid IdRequest request) {
        storehouseLocationService.deleteById(request.getId());
        return ApiResult.success();
    }
}
