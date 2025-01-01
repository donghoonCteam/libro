package pj.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pj.spring.service.KakaoPayService;
import pj.spring.vo.KakaoPayRequest;
import pj.spring.vo.KakaoPayResponse;

@Controller
@RequestMapping("/kakaoPay")
public class KakaoPayController {

    private final KakaoPayService kakaoPayService;

    @Autowired
    public KakaoPayController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }

    @RequestMapping(value = "/ready", method = RequestMethod.POST)
    public ResponseEntity<?> kakaoPayReady(@RequestBody KakaoPayRequest request, Authentication authentication) {
    	
    	String userId = authentication.getName(); // ������ ������� ID
        System.out.println("User ID from Authentication: " + userId);

        request.setUser_id(userId); // userId�� ��û ��ü�� ����
        
        try {
            KakaoPayResponse response = kakaoPayService.kakaoPayReady(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            // �߸��� ��û �����Ϳ� ���� ����
            return ResponseEntity.badRequest().body("�߸��� ��û: " + e.getMessage());
        } catch (RuntimeException e) {
            // īī������ API ȣ�� ����
            return ResponseEntity.status(502).body("īī������ ���� ȣ�� ����: " + e.getMessage());
        } catch (Exception e) {
            // ��Ÿ ����ġ ���� ����
            return ResponseEntity.status(500).body("���� ���� ���� �߻�: " + e.getMessage());
        }
    }
}



