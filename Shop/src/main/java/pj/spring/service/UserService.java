package pj.spring.service;

import java.util.List;

import pj.spring.vo.AddressBookVO;
import pj.spring.vo.UserVO;

public interface UserService {
	
	// ȸ������
	public int insert(UserVO userVO);

	// �α���
	public UserVO selectLogin(String username);

	// ���̵� �ߺ� üũ
	public int selectCntByUid(String user_id);
	
	// �ּҷ� ���
	public List<AddressBookVO> list(String user_id);
	
	// �ּҷ� ���
	public int addrinsert(AddressBookVO addressbookVO);
}
