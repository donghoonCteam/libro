package pj.spring.service;

import pj.spring.vo.UserVO;

public interface UserService {
	
	// ȸ������
	public int insert(UserVO userVO);

	// ���̵� �ߺ� üũ
	public int selectCntByUid(String user_id);
	
	// �α���
	public UserVO selectLogin(String username);
}
