package pj.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pj.spring.service.KakaoPayService;
import pj.spring.vo.KakaoPayReadyRequest;
import pj.spring.vo.KakaoPayReadyResponse;

@RestController
@RequestMapping("/kakao-pay")
public class KakaoPayController {

	/*
	 * private final KakaoPayService kakaoPayService; // ������ ����
	 * 
	 * @PostMapping("/ready") public ResponseEntity<KakaoPayReadyResponse>
	 * readyToPay(@RequestBody KakaoPayReadyRequest request) { KakaoPayReadyResponse
	 * response = kakaoPayService.readyToPay(request); return
	 * ResponseEntity.ok(response); }
	 */
}
