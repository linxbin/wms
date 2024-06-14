package com.linxb.wms.basis.domain.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 客户
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@Data
@TableName("customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("number")
    private String number;

    /**
     * 结算单位ID
     */
    @TableField("settlement_company_id")
    private Long settlementCompanyId;

    @TableField("contact_name")
    private String contactName;

    @TableField("contact_number")
    private Integer contactNumber;

    @TableField("address")
    private String address;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
