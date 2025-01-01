package pj.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import pj.spring.service.KakaoPayService;
import pj.spring.vo.DeliveryInfoVO;
import pj.spring.vo.KakaoPayResponse;
import pj.spring.vo.UserVO;

@Controller
@RequestMapping("/kakaoPay")
public class KakaoPayController {
	
	private static final Logger log = LoggerFactory.getLogger(KakaoPayController.class);

    private final KakaoPayService kakaoPayService;

    @Autowired
    public KakaoPayController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }

    @PostMapping("/ready")
    @ResponseBody
    public ResponseEntity<?> kakaoPayReady(@RequestBody Map<String, Object> paymentData, HttpSession session) {
        try {
            log.info("īī������ ��û ������: {}", paymentData);

            if (paymentData == null || !paymentData.containsKey("amount")) {
                return ResponseEntity.badRequest().body("Invalid payment data");
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            
            String userId = authentication.getName();
            if (userId == null) {
                log.error("����� ID�� ���ǿ� �������� �ʽ��ϴ�.");
                return ResponseEntity.badRequest().body("User ID is missing in the session.");
            }

            Map<String, Object> kakaoPayRequest = new HashMap<>();
            kakaoPayRequest.put("cid", "TC0ONETIME");
            kakaoPayRequest.put("partner_order_id", UUID.randomUUID().toString());
            kakaoPayRequest.put("partner_user_id", userId);
            kakaoPayRequest.put("item_name", paymentData.get("itemName"));
            kakaoPayRequest.put("quantity", paymentData.get("quantity"));
            kakaoPayRequest.put("total_amount", paymentData.get("amount"));
            kakaoPayRequest.put("vat_amount", 0);
            kakaoPayRequest.put("tax_free_amount", 0);
            kakaoPayRequest.put("approval_url", "http://localhost:8080/kakaoPay/success");
            kakaoPayRequest.put("cancel_url", "http://localhost:8080/kakaoPay/cancel");
            kakaoPayRequest.put("fail_url", "http://localhost:8080/kakaoPay/fail");

            KakaoPayResponse response = kakaoPayService.kakaoPayReady(kakaoPayRequest);
         // TID�� ���ǿ� ����
            session.setAttribute("tid", response.getTid());
            return ResponseEntity.ok(response);

        } catch (HttpClientErrorException e) {
            log.error("HTTP ���� �߻�: {}", e.getResponseBodyAsString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("īī������ ��û ������ ����: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            log.error("īī������ ��û ����", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("���� ��û �� ������ �߻��߽��ϴ�.");
        }
    }

    
    @GetMapping("/success")
    public String paymentSuccess(@RequestParam("pg_token") String pgToken, HttpSession session, Model model) {
        try {
            // �α� ������� ��û Ȯ��
        	log.info("īī������ ���� ��û ����: pg_token={}", pgToken);

            // TID ��ȸ
            String tid = (String) session.getAttribute("tid");
            if (tid == null) {
                throw new RuntimeException("TID�� ���ǿ� �����ϴ�.");
            }

            // ����� ���� ��ȸ
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userId = authentication.getName();
            if (userId == null) {
                throw new RuntimeException("User ID�� ���ǿ� �����ϴ�.");
            }

            // ���� ���� ��û
            Map<String, String> approvalRequest = new HashMap<>();
            approvalRequest.put("cid", "TC0ONETIME");
            approvalRequest.put("tid", tid);
            approvalRequest.put("partner_order_id", "test_order_id");
            approvalRequest.put("partner_user_id", userId);
            approvalRequest.put("pg_token", pgToken);

            // ���� ó��
            KakaoPayResponse approvalResponse = kakaoPayService.kakaoPayApprove(approvalRequest);
            model.addAttribute("approvalResponse", approvalResponse);

            // ���� �Ϸ� ������ �߰�
            String orderNumber = (String) session.getAttribute("orderNumber");
            int orderAmount = (Integer) session.getAttribute("orderAmount");
            model.addAttribute("orderNumber", orderNumber);
            model.addAttribute("orderAmount", orderAmount);

            return "user/payment/paymentSuccess"; // ���� �Ϸ� ������
        } catch (Exception e) {
            log.error("���� ���� �� ���� �߻�", e);
            model.addAttribute("errorMessage", "���� ���� �� ������ �߻��߽��ϴ�.");
            return "user/payment/paymentError"; // ���� ������
        }
    }
}



