package com.group.an.dataLibrary.models;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetail {
    private String cardType;
    private String cardNumber;
    private LocalDateTime cardExpiry;
    private long upiNumber;
    private String upiId;
}
