package com.linxb.wms.basis.domain.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 库位
 * </p>
 *
 * @author linxb
 * @since 2024-06-14
 */
@Data
@TableName("storehouse_location")
public class StorehouseLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 编号
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
    @TableField("storehoue_id")
    private Long storehoueId;

    /**
     * 库区ID
     */
    @TableField("storehouse_area_id")
    private Long storehouseAreaId;

    /**
     * 容量
     */
    @TableField("volume")
    private BigDecimal volume;

    /**
     * 已用容量
     */
    @TableField("used_volume")
    private BigDecimal usedVolume;

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
