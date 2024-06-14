package com.linxb.wms.basis.service;

import com.linxb.wms.basis.domain.model.StorehouseArea;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseAreaQueryRequest;
import com.linxb.wms.common.vo.response.PageBaseResp;

/**
 * <p>
 * 库区 服务类
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
public interface IStorehouseAreaService {

    void add(StorehouseAreaAddRequest req);

    void modify(StorehouseAreaModifyRequest req);

    StorehouseArea detail(Long id);

    void delete(Long id);

    PageBaseResp<StorehouseArea> getList(StorehouseAreaQueryRequest request);
}
