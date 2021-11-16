package com.icode20.runningeating.api.response;

import com.icode20.runningeating.global.config.BaseResponse;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OrderResponse extends BaseResponse {
    @Builder
    public OrderResponse(Object body, String message, Object status, String operation, String namespace) {
        super(body, message, status, operation, namespace);
    }

    @Override
    public String getNamespace() {
        return "订单";
    }
}
