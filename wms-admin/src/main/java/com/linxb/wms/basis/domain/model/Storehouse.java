package com.linxb.wms.basis.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author linxb
 * @since 2024-06-05
 */
@Getter
@Setter
@TableName("storehouse")
public class Storehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("number")
    private String number;

    @TableField("name")
    private String name;

    @TableField("volume")
    private BigDecimal volume;

    @TableField("used_volume")
    private BigDecimal usedVolume;

    @TableField("note")
    private String note;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
