package com.linxb.wms;

import com.linxb.wms.basis.domain.model.Storehouse;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseAddRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseModifyRequest;
import com.linxb.wms.basis.domain.vo.request.storehouse.StorehouseQueryRequest;
import com.linxb.wms.basis.service.IStorehouseService;
import com.linxb.wms.common.vo.request.IdRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StorehouseTest {

    @Autowired
    IStorehouseService storehouseService;

    @Test
    public void addTest() {
        StorehouseAddRequest storehouseAddReq = new StorehouseAddRequest();
        storehouseAddReq.setName("出纳控股1");
        storehouseAddReq.setNumber("1000001");
        storehouseAddReq.setNote("");
        storehouseAddReq.setVolume(new BigDecimal("124.14"));

        storehouseService.add(storehouseAddReq);
    }

    @Test
    public void modifyTest() {
        StorehouseModifyRequest req = new StorehouseModifyRequest();
        req.setId(1L);
        req.setName("出纳控股2");
        req.setNumber("1000002");
        req.setNote("");
        req.setVolume(new BigDecimal("124.14"));

        storehouseService.modify(req);
    }

    @Test
    public void detailTest() {
        Storehouse detail = storehouseService.detail(1L);
        System.out.println(detail.toString());
    }

    @Test
    public void pageListTest() {
        StorehouseQueryRequest storehouseQueryRequest = new StorehouseQueryRequest();
        storehouseQueryRequest.setPageNo(1);
        storehouseQueryRequest.setPageSize(10);
        storehouseService.getList(storehouseQueryRequest);
    }

    @Test
    public void deleteTest() {
        IdRequest idRequest = new IdRequest();
        idRequest.setId(1);
        storehouseService.delete(idRequest);
    }
}
