package com.linxb.wms.basis.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linxb.wms.basis.dao.StorehouseAreaDao;
import com.linxb.wms.basis.dao.StorehouseDao;
import com.linxb.wms.basis.domain.model.StorehouseArea;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaQueryRequest;
import com.linxb.wms.basis.service.IStorehouseAreaService;
import com.linxb.wms.common.utils.AssertUtil;
import com.linxb.wms.common.vo.response.PageBaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库区 服务实现类
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@Service
public class StorehouseAreaServiceImpl implements IStorehouseAreaService {

    @Autowired
    private StorehouseAreaDao storehouseAreaDao;

    @Autowired
    private StorehouseDao storehouseDao;

    @Override
    public void add(StorehouseAreaAddRequest req) {
        AssertUtil.isTrue(storehouseDao.existsById(req.getStorehouseId()), "仓库不存在");
        AssertUtil.isFalse(storehouseAreaDao.existsByName(req.getName(), req.getStorehouseId()), "库区名称已经被占用");
        AssertUtil.isFalse(storehouseAreaDao.existsByNumber(req.getName(), req.getStorehouseId()), "库区编号已经被占用");
        StorehouseArea storehouseArea = new StorehouseArea();
        storehouseArea.setStorehouseId(req.getStorehouseId());
        storehouseArea.setName(req.getName());
        storehouseArea.setNumber(req.getNumber());
        storehouseArea.setVolume(req.getVolume());
        storehouseArea.setNote(req.getNote());
        storehouseAreaDao.save(storehouseArea);
    }

    @Override
    public void modify(StorehouseAreaModifyRequest req) {
        StorehouseArea storehouseArea = storehouseAreaDao.getById(req.getId());
        AssertUtil.isTrue(storehouseDao.existsById(req.getStorehouseId()), "仓库不存在");
        AssertUtil.isNotEmpty(storehouseArea, "库区不存在");

        storehouseArea.setStorehouseId(req.getStorehouseId());
        storehouseArea.setNumber(req.getNumber());
        storehouseArea.setNote(req.getNote());
        storehouseArea.setVolume(req.getVolume());
        AssertUtil.isTrue(storehouseAreaDao.updateById(storehouseArea), "更新库区失败");
    }

    @Override
    public StorehouseArea detail(Long id) {
        return storehouseAreaDao.getById(id);
    }

    @Override
    public void delete(Long id) {
        AssertUtil.isTrue(storehouseAreaDao.removeById(id), "删除库区失败");
    }

    @Override
    public PageBaseResp<StorehouseArea> getList(StorehouseAreaQueryRequest request) {
        IPage<StorehouseArea> list = storehouseAreaDao.getList(request, request.plusPage());
        if (CollectionUtil.isEmpty(list.getRecords())) {
            return PageBaseResp.empty();
        }

        //返回消息
        return PageBaseResp.init(list, list.getRecords());
    }
}
