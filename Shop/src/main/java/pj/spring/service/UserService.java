package pj.spring.service;

import pj.spring.vo.UserVO;

public interface UserService {
	
	// ȸ������
	public int insert(UserVO userVO);

//	// �α���
	public UserVO selectLogin(String username);

}
