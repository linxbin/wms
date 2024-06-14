package com.linxb.wms.basis.service;

import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.domain.vo.request.StorehouseAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseQueryRequest;
import com.linxb.wms.common.vo.request.IdRequest;
import com.linxb.wms.common.vo.response.PageBaseResp;

/**
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

    PageBaseResp<Storehouse> getList(StorehouseQueryRequest request);

    void delete(IdRequest request);
}
