package pj.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.spring.service.UserService;
import pj.spring.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;
	
	// �α���
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login() {
		
		return "user/account/login";
	}
	
	//	ȸ������
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		
		return "user/account/join";
	}
	
	@RequestMapping(value = "/joinOk.do", method = RequestMethod.POST)
	public String joinOk(UserVO userVO) {

		System.out.println("user_id : " + userVO.getUser_id());
		System.out.println("user_password : " + userVO.getUser_password());
		System.out.println("user_name : " + userVO.getUser_name());
		System.out.println("user_email : " + userVO.getUser_email());
		System.out.println("user_phone : " + userVO.getUser_phone());
		
		BCryptPasswordEncoder epwe = new BCryptPasswordEncoder(); // ��ȣȭ�� �ȵǴ� 
		
		userVO.setUser_password(epwe.encode(userVO.getUser_password()));
		
		int result = userService.insert(userVO);
		
		if(result > 0) {
			System.out.println("��ϿϷ�");
		}else {
			System.out.println("��Ͻ���");
		}
		
		return "redirect:/";
	}
	
	
	// ���̵� �ߺ� üũ
	@ResponseBody
	@RequestMapping(value = "/ajax/checkID.do", method = RequestMethod.GET)
	public String checkID(String user_id) {
		
		String msg = "";
		
		int isId = userService.selectCntByUid(user_id);
		
		/*
			ajax ��û�� ��Ʈ�ѷ������� response ���ڼ��� ������ �� �����Ƿ� �ַ� ���䰪�� �������� �ۼ��Ͽ� 
			ȭ�鿡�� �����մϴ�.
		*/
		
		if(isId > 0){
			// ID �ߺ�
			
			msg = "fail";
		}else {
			// ID �ߺ� X
			
			msg = "success";
		}
		
		return msg;
	}
	
	// ȸ�� ����
	@RequestMapping(value="/memberinfo.do", method = RequestMethod.GET)
	public String memberinfo() {
		
		return "user/account/memberinfo";
	}
	
	// �ּҷ�
	@RequestMapping(value="/addr.do", method = RequestMethod.GET)
	public String addr() {
		
		return "user/account/addr";
	}
	
	// �ּҷ�
	@RequestMapping(value="/addrregister.do", method = RequestMethod.GET)
	public String addrregister() {
		
		return "user/account/addrregister";
	}
}
