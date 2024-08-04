package com.coupon.service;

import com.coupon.dtos.CouponGenerateRequest;
import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponRepository couponRepository;

    private final Random random = new Random();


    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon createCoupon(CouponGenerateRequest couponGenerateRequest) {
        Coupon coupon = new Coupon();
        coupon.setCode(generateUniqueCode());
        coupon.setDescription(couponGenerateRequest.getDescription());
        coupon.setPointsRequired(couponGenerateRequest.getPointsRequired());
        coupon.setExpiryDate(LocalDateTime.now().plusDays(couponGenerateRequest.getValidityInDays()));
        coupon.setRedeemed(false);

        return couponRepository.save(coupon);
    }

    private String generateUniqueCode() {
        String code;
        do {
            code = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (couponRepository.findByCode(code) != null);
        return code;
    }

    @Override
    public Coupon redeemCoupon(String code) {
        Coupon coupon = couponRepository.findByCode(code);
        if (coupon != null && !coupon.isRedeemed() && coupon.getExpiryDate().isAfter(LocalDateTime.now())) {
            coupon.setRedeemed(true);
            return couponRepository.save(coupon);
        }
        return null;
    }
}
