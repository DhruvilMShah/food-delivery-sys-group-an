package com.group.an.orderService.requestModel;

import com.group.an.dataLibrary.models.OrderStatus;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusUpdateRequest {
    private int orderId;
    private OrderStatus orderStatus;
}

