package com.linxb.wms;

import com.linxb.wms.basis.dao.StorehouseDao;
import com.linxb.wms.basis.domain.model.Storehouse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class StorehouseTest {

    @Autowired
    StorehouseDao storehouseDao;

    @Test
    public void addTest() {
        Storehouse storehouse = new Storehouse();
        storehouse.setName("测试2");
        storehouse.setNumber("123456");
        storehouse.setNote("123123123");
        storehouse.setVolume(new BigDecimal(100));
        storehouse.setUsedVolume(new BigDecimal(0));
        storehouse.setCreateTime(new Date());
        storehouse.setUpdateTime(new Date());
        storehouseDao.save(storehouse);
    }
}
