package com.coupon.dtos;

import lombok.Data;

@Data
public class CouponGenerateRequest {
    private String description;
    private int pointsRequired;
    private int validityInDays;
}
