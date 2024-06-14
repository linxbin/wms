package com.linxb.wms.basis.domain.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 供应商
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@Data
@TableName("supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 编码
     */
    @TableField("number")
    private String number;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    @TableField("contact_name")
    private String contactName;

    @TableField("contact_number")
    private Integer contactNumber;

    @TableField("note")
    private String note;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
