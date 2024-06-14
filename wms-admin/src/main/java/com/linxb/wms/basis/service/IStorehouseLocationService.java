package com.linxb.wms.basis.service;

import com.linxb.wms.basis.domain.model.StorehouseLocation;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationAddRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationModifyRequest;
import com.linxb.wms.basis.domain.vo.request.StorehouseLocationQueryRequest;
import com.linxb.wms.common.vo.response.PageBaseResp;

/**
 * <p>
 * 库位 服务类
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
public interface IStorehouseLocationService {

    void add(StorehouseLocationAddRequest req);

    void modify(StorehouseLocationModifyRequest req);

    StorehouseLocation detail(Long id);

    PageBaseResp<StorehouseLocation> getList(StorehouseLocationQueryRequest request);

    void deleteById(Long id);
}
