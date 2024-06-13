package com.linxb.wms.basis.domain.vo.request.storehouse;

import com.linxb.wms.common.vo.request.PageBaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorehouseQueryRequest extends PageBaseRequest {

    @Size(max = 40)
    @Min(0)
    @ApiModelProperty("编号")
    private String number;

    @Size(max = 20)
    @Min(0)
    @ApiModelProperty("名称")
    private String name;
}
