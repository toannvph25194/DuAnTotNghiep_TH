package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.respon.PaymentRespon;
import jakarta.servlet.http.HttpServletRequest;

public interface VNPayService {

    // Thanh Toán VNPay Online
    PaymentRespon callPaymentApiOnline(HttpServletRequest req, Long amountParam);
}
