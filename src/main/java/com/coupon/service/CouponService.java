package com.coupon.service;

import com.coupon.dtos.CouponGenerateRequest;
import com.coupon.model.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {
    List<Coupon> getAllCoupons();
    Coupon createCoupon(CouponGenerateRequest couponGenerateRequest);
    Coupon redeemCoupon(String code);
}
