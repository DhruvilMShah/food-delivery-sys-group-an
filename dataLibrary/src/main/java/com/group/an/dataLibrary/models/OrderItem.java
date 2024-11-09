package com.group.an.dataLibrary.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    private int orderItemId;
    private int menuItemId;
    private int quantity;
    private double price;
}
