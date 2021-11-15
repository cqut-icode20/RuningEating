package com.icode20.runningeating.api.response;

import com.icode20.runningeating.global.config.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GoodResponse extends BaseResponse {
    @Builder
    public GoodResponse(Object body, String message, Object status, String operation, String namespace) {
        super(body, message, status, operation, namespace);
    }


    @Override
    public String getNamespace() {
        return "商品";
    }
}
