package com.coupon.restController;

import com.coupon.dtos.CouponGenerateRequest;
import com.coupon.model.Coupon;
import com.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coupon-service")
public class CouponRestController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/all-coupons")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        return new ResponseEntity<>(couponService.getAllCoupons(), HttpStatus.OK);
    }

    @PostMapping("/generate-coupon")
    public ResponseEntity<Coupon> createCoupon(@RequestBody CouponGenerateRequest couponGenerateRequest) {
        return new ResponseEntity<>(couponService.createCoupon(couponGenerateRequest),HttpStatus.OK);
    }

    @PostMapping("/redeem-coupon")
    public ResponseEntity<Coupon> redeemCoupon(@RequestParam String code) {
        return new ResponseEntity<>(couponService.redeemCoupon(code),HttpStatus.OK);
    }
}
