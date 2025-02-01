package com.odin.Service;

import com.odin.Model.TwoFactorAuth;
import com.odin.Model.TwoFactorOTP;
import com.odin.Model.User;

public interface TwoFactorOTPService {
    TwoFactorOTP createTwoFactorOtp (User user, String otp, String jwt);


    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP, String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
