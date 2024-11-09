package com.group.an.dataLibrary.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    private int menuItemId;
    private String itemName;
    private String description;
    private double price;
    private boolean isAvailable;
}
