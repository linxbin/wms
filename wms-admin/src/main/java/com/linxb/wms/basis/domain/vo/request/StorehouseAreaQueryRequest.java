package com.linxb.wms.basis.domain.vo.request;

import com.linxb.wms.common.vo.request.PageBaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorehouseAreaQueryRequest extends PageBaseRequest {

    @ApiModelProperty("仓库ID")
    private Long storehouseId;

    @Size(max = 40)
    @Min(0)
    @ApiModelProperty("编号")
    private String number;

    @Size(max = 20)
    @Min(0)
    @ApiModelProperty("名称")
    private String name;
}
