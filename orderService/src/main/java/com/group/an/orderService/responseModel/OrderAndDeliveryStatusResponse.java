package com.group.an.orderService.responseModel;

import com.group.an.dataLibrary.models.DeliveryStatus;
import com.group.an.dataLibrary.models.OrderStatus;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderAndDeliveryStatusResponse {
    private OrderStatus orderStatus;
    private DeliveryStatus deliveryStatus;
}
