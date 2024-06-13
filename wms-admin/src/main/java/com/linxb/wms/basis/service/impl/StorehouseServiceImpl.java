package com.linxb.wms.basis.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linxb.wms.basis.dao.StorehouseDao;
import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseAddRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseModifyRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseQueryRequest;
import com.linxb.wms.basis.service.IStorehouseService;
import com.linxb.wms.common.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linxb
 * @since 2024-06-05
 */
@Service
public class StorehouseServiceImpl implements IStorehouseService {

    @Autowired
    private StorehouseDao storehouseDao;

    @Override
    public void add(StorehouseAddRequest req) {
        AssertUtil.isFalse(storehouseDao.existsByName(req.getName()), "仓库名称已存在");
        AssertUtil.isFalse(storehouseDao.existsByNumber(req.getNumber()), "仓库编号已存在");
        Storehouse storehouse = new Storehouse();
        storehouse.setName(req.getName());
        storehouse.setNumber(req.getNumber());
        storehouse.setVolume(req.getVolume());
        storehouse.setNote(req.getNote());
        storehouseDao.save(storehouse);
    }

    @Override
    public void modify(StorehouseModifyRequest req) {
        Storehouse storehouse = storehouseDao.getById(req.getId());
        AssertUtil.isNotEmpty(storehouse, "仓库不存在");

        AssertUtil.isFalse(storehouseDao.existsByName(req.getName(), storehouse.getId()), "仓库名称已存在");
        AssertUtil.isFalse(storehouseDao.existsByNumber(req.getNumber(), storehouse.getId()), "仓库编号已存在");

        storehouse.setName(req.getName());
        storehouse.setNumber(req.getNumber());
        storehouse.setVolume(req.getVolume());
        storehouse.setNote(req.getNote());
        storehouseDao.updateById(storehouse);
    }

    @Override
    public Storehouse detail(Long id) {
        return storehouseDao.getById(id);
    }

    @Override
    public IPage<Storehouse> getList(StorehouseQueryRequest request) {
        IPage<Storehouse> list = storehouseDao.getList(request, request.plusPage());
        return list;
    }
}
