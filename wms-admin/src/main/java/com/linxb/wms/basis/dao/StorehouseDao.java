package com.linxb.wms.basis.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseQueryRequest;
import com.linxb.wms.basis.mapper.StorehouseMapper;
import org.springframework.stereotype.Service;

@Service
public class StorehouseDao extends ServiceImpl<StorehouseMapper, Storehouse> {

    public boolean existsByName(String name) {
        return lambdaQuery().eq(Storehouse::getName, name).count() > 0;
    }

    public boolean existsByNumber(String number) {
        return lambdaQuery().eq(Storehouse::getNumber, number).count() > 0;
    }

    public boolean existsByName(String name, Long excludeId) {
        return lambdaQuery().eq(Storehouse::getName, name)
                .ne(Storehouse::getId, excludeId)
                .count() > 0;
    }

    public boolean existsByNumber(String number, Long excludeId) {
        return lambdaQuery().eq(Storehouse::getNumber, number)
                .ne(Storehouse::getId, excludeId)
                .count() > 0;
    }

    public IPage<Storehouse> getList(StorehouseQueryRequest request, Page page) {
        return lambdaQuery().eq(! request.getName().trim().isEmpty(), Storehouse::getName, request.getName())
                .eq(! request.getNumber().trim().isEmpty(), Storehouse::getNumber, request.getNumber())
                .page(page);
    }
}
