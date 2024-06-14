package com.linxb.wms.basis.domain.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorehouseAddRequest {

    @NotNull
    @Size(max = 40)
    @ApiModelProperty("编号")
    private String number;

    @NotNull
    @Size(max = 20)
    @ApiModelProperty("名称")
    private String name;

    @NotNull
    @ApiModelProperty("容量")
    private BigDecimal volume;

    @ApiModelProperty("备注")
    private String note;

}
