package com.linxb.wms.basis.domain.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 库区
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@Data
@TableName("storehouse_area")
public class StorehouseArea implements Serializable {

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

    /**
     * 仓库ID
     */
    @TableField("storehouse_id")
    private Long storehouseId;

    /**
     * 总容量
     */
    @TableField("volume")
    private BigDecimal volume;

    /**
     * 已用容量
     */
    @TableField("use_volume")
    private BigDecimal useVolume;

    /**
     * 备注
     */
    @TableField("note")
    private String note;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
