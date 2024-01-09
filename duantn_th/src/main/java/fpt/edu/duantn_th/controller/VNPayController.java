package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.dto.respon.PaymentRespon;
import fpt.edu.duantn_th.service.Impl.VNPayServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class VNPayController {

    @Autowired
    private VNPayServiceImpl vnPayService;

    @PostMapping("/vnpay")
    public ResponseEntity<PaymentRespon> creatPayment(
            HttpServletRequest req, @RequestParam("tongTienAmout") Long amountParam)
    {
        return ResponseEntity.ok(vnPayService.callPaymentApiOnline(req,amountParam));
    }

}
