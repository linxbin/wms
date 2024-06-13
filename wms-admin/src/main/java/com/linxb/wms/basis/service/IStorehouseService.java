package com.linxb.wms.basis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseAddRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseModifyRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseQueryRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linxb
 * @since 2024-06-05
 */
public interface IStorehouseService {

    void add(StorehouseAddRequest req);

    void modify(StorehouseModifyRequest req);

    Storehouse detail(Long id);

    IPage<Storehouse> getList(StorehouseQueryRequest request);
}
