package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.UserDAO;
import pj.spring.vo.AddressBookVO;
import pj.spring.vo.UserVO;

@Service // ���������� ����ϴ� ���� ��ü�� �������� �����Ͽ� ����
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDAO userDAO;
	
	// ȸ������
	@Override
	public int insert(UserVO userVO){
		
		return userDAO.insert(userVO);
	}

	// �α���
	@Override
	public UserVO selectLogin(String username){
		
		return userDAO.selectLogin(username);
	}

	// ���̵� �ߺ� üũ
	@Override
	public int selectCntByUid(String user_id) {

		return userDAO.selectCntByUid(user_id);
	}
	
	// �ּҷ� ���
	@Override
	public List<AddressBookVO> list(String user_id) {
		
		return userDAO.list(user_id);
	}

	// �ּҷ� ���
	@Override
	public int addrinsert(AddressBookVO addressbookVO) {

		return userDAO.addrinsert(addressbookVO);
	}

  }
