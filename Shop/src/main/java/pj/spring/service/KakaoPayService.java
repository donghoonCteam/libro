package pj.spring.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import pj.spring.controller.KakaoPayController;
import pj.spring.vo.KakaoPayResponse;

@Service
public class KakaoPayService {
	private static final Logger log = LoggerFactory.getLogger(KakaoPayController.class);
	
    private static final String KAKAO_PAY_URL = "https://kapi.kakao.com/v1/payment/ready";
    private static final String ADMIN_KEY = "KakaoAK 34f631e3b17f6fdd4b5e2ad359e5a088";

    public KakaoPayResponse kakaoPayReady(Map<String, Object> requestParams) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // ��û ��� ����
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", ADMIN_KEY);

            // ��û �ٵ� ����
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            // �ʿ��� �ʵ常 ��������� �߰�
            body.add("cid", "TC0ONETIME");
            body.add("partner_order_id", requestParams.get("partner_order_id").toString());
            body.add("partner_user_id", requestParams.get("partner_user_id").toString());
            body.add("item_name", requestParams.get("item_name").toString());
            body.add("quantity", requestParams.get("quantity").toString());
            body.add("total_amount", requestParams.get("total_amount").toString());
            body.add("vat_amount", "0"); // ������
            body.add("tax_free_amount", "0"); // ������
            body.add("approval_url", requestParams.get("approval_url").toString());
            body.add("cancel_url", requestParams.get("cancel_url").toString());
            body.add("fail_url", requestParams.get("fail_url").toString());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

            // īī������ API ȣ��
            String kakaoPayUrl = KAKAO_PAY_URL;
            ResponseEntity<KakaoPayResponse> response = restTemplate.postForEntity(kakaoPayUrl, request, KakaoPayResponse.class);

            if (response.getBody() == null) {
                log.error("īī������ ������ null�Դϴ�.");
                throw new RuntimeException("īī������ ������ null�Դϴ�.");
            }
            log.info("īī������ ����: {}", response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException e) {
            log.error("HTTP ���� �߻�: {}", e.getResponseBodyAsString());
            throw new RuntimeException("īī������ ��û ����: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            log.error("īī������ API ȣ�� �� ���� �߻�", e);
            throw new RuntimeException("īī������ API ȣ�� ����");
        }
    }
    
    public KakaoPayResponse kakaoPayApprove(Map<String, String> requestParams) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "KakaoAK YOUR_ADMIN_KEY");

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            requestParams.forEach((key, value) -> body.add(key, value));

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
            ResponseEntity<KakaoPayResponse> response = restTemplate.postForEntity("https://kapi.kakao.com/v1/payment/approve", request, KakaoPayResponse.class);

            return response.getBody();
        } catch (Exception e) {
            log.error("īī������ ���� API ȣ�� ����", e);
            throw new RuntimeException("īī������ ���� ��û ����");
        }
    }
}





