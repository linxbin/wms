package com.linxb.wms.basis.dao;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.mapper.StorehouseMapper;
import org.springframework.stereotype.Service;

@Service
public class StorehouseDao extends ServiceImpl<StorehouseMapper, Storehouse> {

    public Storehouse getByName(String name) {
        return lambdaQuery().eq(Storehouse::getName, name).one();
    }
}
