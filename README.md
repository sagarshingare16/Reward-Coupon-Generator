# Reward-Coupon-Generator
The Reward Coupon Generator Backend is a Spring Boot application designed to manage the creation, redemption, and tracking of reward coupons. This backend service supports various functionalities including generating unique coupon codes, setting expiry dates, and redeeming coupons.

API Endpoints:
GET   '/api/v1/coupon-service/all-coupons'        --  details of all coupons
POST  '/api/v1/coupon-service/generate-coupon'    --  it will generate coupon
POST  '/api/v1/coupon-service/redeem-coupon'      --  redeem coupon
