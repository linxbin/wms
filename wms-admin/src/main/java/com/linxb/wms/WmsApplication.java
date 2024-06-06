package com.linxb.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.linxb.wms"})
@MapperScan({"com.linxb.wms.basis.**.mapper"})
@ServletComponentScan
public class WmsApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}