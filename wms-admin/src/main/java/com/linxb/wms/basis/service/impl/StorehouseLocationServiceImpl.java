package com.linxb.wms.basis.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linxb.wms.basis.dao.StorehouseAreaDao;
import com.linxb.wms.basis.dao.StorehouseLocationDao;
import com.linxb.wms.basis.domain.model.StorehouseLocation;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationQueryRequest;
import com.linxb.wms.basis.service.IStorehouseLocationService;
import com.linxb.wms.common.utils.AssertUtil;
import com.linxb.wms.common.vo.response.PageBaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库位 服务实现类
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@Service
public class StorehouseLocationServiceImpl implements IStorehouseLocationService {

    @Autowired
    private StorehouseLocationDao storehouseLocationDao;

    @Autowired
    private StorehouseAreaDao storehouseAreaDao;

    @Override
    public void add(StorehouseLocationAddRequest req) {
        AssertUtil.isTrue(storehouseAreaDao.existById(req.getStorehouseAreaId(), req.getStorehouseId()), "仓库库区不存在");
        AssertUtil.isFalse(storehouseLocationDao.existByName(req.getName(), req.getStorehouseId(), req.getStorehouseAreaId()), "库位名称已存在");
        AssertUtil.isFalse(storehouseLocationDao.existByNumber(req.getNumber(), req.getStorehouseId(), req.getStorehouseAreaId()), "库位编号已存在");

        StorehouseLocation storehouseLocation = new StorehouseLocation();
        storehouseLocation.setStorehoueId(req.getStorehouseId());
        storehouseLocation.setStorehouseAreaId(req.getStorehouseAreaId());
        storehouseLocation.setName(req.getName());
        storehouseLocation.setNumber(req.getNumber());
        storehouseLocation.setNote(req.getNote());
        storehouseLocation.setStorehoueId(req.getStorehouseId());
    }

    @Override
    public void modify(StorehouseLocationModifyRequest req) {
        StorehouseLocation storehouseLocation = storehouseLocationDao.getById(req.getId());
        AssertUtil.isNotEmpty(storehouseLocation, "库位不存在");
        AssertUtil.isTrue(storehouseAreaDao.existById(req.getStorehouseAreaId(), req.getStorehouseId()), "仓库库区不存在");
        AssertUtil.isFalse(storehouseLocationDao.existByName(req.getName(), req.getStorehouseId(), req.getStorehouseAreaId(), req.getId()), "库位名称已存在");
        AssertUtil.isFalse(storehouseLocationDao.existByNumber(req.getNumber(), req.getStorehouseId(), req.getStorehouseAreaId(), req.getId()), "库位编号已存在");

        storehouseLocation.setStorehoueId(req.getStorehouseId());
        storehouseLocation.setStorehouseAreaId(req.getStorehouseAreaId());
        storehouseLocation.setNumber(req.getNumber());
        storehouseLocation.setNote(req.getNote());
        storehouseLocation.setVolume(req.getVolume());
        AssertUtil.isTrue(storehouseLocationDao.updateById(storehouseLocation), "更新库位失败");
    }

    @Override
    public StorehouseLocation detail(Long id) {
        return storehouseLocationDao.getById(id);
    }

    @Override
    public PageBaseResp<StorehouseLocation> getList(StorehouseLocationQueryRequest request) {
        IPage<StorehouseLocation> list = storehouseLocationDao.getList(request, request.plusPage());
        if (CollectionUtil.isEmpty(list.getRecords())) {
            return PageBaseResp.empty();
        }

        //返回消息
        return PageBaseResp.init(list, list.getRecords());
    }

    @Override
    public void deleteById(Long id) {
        AssertUtil.isTrue(storehouseLocationDao.removeById(id), "删除库位失败");
    }
}
