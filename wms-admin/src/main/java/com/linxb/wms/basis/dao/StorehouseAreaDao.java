package com.linxb.wms.basis.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linxb.wms.basis.domain.model.StorehouseArea;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaQueryRequest;
import com.linxb.wms.basis.mapper.StorehouseAreaMapper;
import org.springframework.stereotype.Service;

@Service
public class StorehouseAreaDao extends ServiceImpl<StorehouseAreaMapper, StorehouseArea> {

    public boolean existsByName(String name, Long storehouseId) {
        return lambdaQuery().eq(StorehouseArea::getName, name)
                .eq(StorehouseArea::getStorehouseId, storehouseId)
                .exists();
    }

    public boolean existsByNumber(String number, Long storehouseId) {
        return lambdaQuery().eq(StorehouseArea::getNumber, number)
                .eq(StorehouseArea::getStorehouseId, storehouseId)
                .exists();
    }

    public boolean existById(Long id) {
        return lambdaQuery().eq(StorehouseArea::getId, id)
                .exists();
    }

    public boolean existById(Long id, Long storehouseId) {
        return lambdaQuery().eq(StorehouseArea::getId, id)
                .eq(StorehouseArea::getStorehouseId, storehouseId)
                .exists();
    }

    public IPage<StorehouseArea> getList(StorehouseAreaQueryRequest req, Page page) {
        return lambdaQuery().eq(req.getName() != null, StorehouseArea::getName, req.getName())
                .eq(req.getNumber() != null, StorehouseArea::getNumber, req.getNumber())
                .eq(req.getStorehouseId() != null, StorehouseArea::getStorehouseId, req.getStorehouseId())
                .page(page);
    }
}
