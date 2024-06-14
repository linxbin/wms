package com.linxb.wms.basis.controller;

import com.linxb.wms.basis.domain.model.StorehouseArea;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaQueryRequest;
import com.linxb.wms.basis.service.IStorehouseAreaService;
import com.linxb.wms.common.vo.request.IdRequest;
import com.linxb.wms.common.vo.response.ApiResult;
import com.linxb.wms.common.vo.response.PageBaseResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 库区 前端控制器
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@RestController
@RequestMapping("/storehouseArea")
public class StorehouseAreaController {
    @Autowired
    private IStorehouseAreaService storehouseAreaService;

    @PostMapping("/add")
    @ApiOperation("新增仓库库位")
    public ApiResult<Void> add(@Valid @RequestBody StorehouseAreaAddRequest req) {
        storehouseAreaService.add(req);
        return ApiResult.success();
    }

    @PutMapping("/modify")
    @ApiOperation("修改仓库库位")
    public ApiResult<Void> modify(@Valid @RequestBody StorehouseAreaModifyRequest req) {
        storehouseAreaService.modify(req);
        return ApiResult.success();
    }

    @GetMapping("/detail")
    @ApiOperation("仓库详情库位")
    public ApiResult<StorehouseArea> detail(@Valid IdRequest req) {
        StorehouseArea detail = storehouseAreaService.detail(req.getId());
        return ApiResult.success(detail);
    }

    @GetMapping("/list")
    @ApiOperation("仓库库位列表")
    public ApiResult<PageBaseResp<StorehouseArea>> getList(@Valid StorehouseAreaQueryRequest request) {
        PageBaseResp<StorehouseArea> list = storehouseAreaService.getList(request);
        return ApiResult.success(list);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除仓库库位")
    public ApiResult<Void> delete(@Valid IdRequest request) {
        storehouseAreaService.delete(request.getId());
        return ApiResult.success();
    }
}
