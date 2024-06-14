package com.linxb.wms.basis.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linxb.wms.basis.domain.model.StorehouseLocation;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationQueryRequest;
import com.linxb.wms.basis.mapper.StorehouseLocationMapper;
import org.springframework.stereotype.Service;

@Service
public class StorehouseLocationDao extends ServiceImpl<StorehouseLocationMapper, StorehouseLocation> {


    public boolean existByName(String name, Long storehouseId, Long storehouseAreaId) {
        return lambdaQuery().eq(StorehouseLocation::getStorehoueId, storehouseId)
                .eq(StorehouseLocation::getStorehouseAreaId, storehouseAreaId)
                .eq(StorehouseLocation::getName, name)
                .exists();
    }

    public boolean existByName(String name, Long storehouseId, Long storehouseAreaId, Long excludeId) {
        return lambdaQuery().eq(StorehouseLocation::getStorehoueId, storehouseId)
                .eq(StorehouseLocation::getStorehouseAreaId, storehouseAreaId)
                .eq(StorehouseLocation::getName, name)
                .ne(StorehouseLocation::getId, excludeId)
                .exists();
    }

    public boolean existByNumber(String number, Long storehouseId, Long storehouseAreaId) {
        return lambdaQuery().eq(StorehouseLocation::getStorehoueId, storehouseId)
                .eq(StorehouseLocation::getStorehouseAreaId, storehouseAreaId)
                .eq(StorehouseLocation::getNumber, number)
                .exists();
    }

    public boolean existByNumber(String number, Long storehouseId, Long storehouseAreaId, Long excludeId) {
        return lambdaQuery().eq(StorehouseLocation::getStorehoueId, storehouseId)
                .eq(StorehouseLocation::getStorehouseAreaId, storehouseAreaId)
                .eq(StorehouseLocation::getNumber, number)
                .ne(StorehouseLocation::getId, excludeId)
                .exists();
    }

    public IPage<StorehouseLocation> getList(StorehouseLocationQueryRequest req, Page page) {
        return lambdaQuery().eq(req.getName() != null, StorehouseLocation::getName, req.getName())
                .eq(req.getNumber() != null, StorehouseLocation::getNumber, req.getNumber())
                .eq(req.getStorehouseId() != null, StorehouseLocation::getStorehoueId, req.getStorehouseId())
                .eq(req.getStorehouseAreaId() != null, StorehouseLocation::getStorehouseAreaId, req.getStorehouseAreaId())
                .page(page);
    }
}
