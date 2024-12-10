package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.UserDAO;
import pj.spring.vo.UserVO;

@Service // ���������� ����ϴ� ���� ��ü�� �������� �����Ͽ� ����
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDAO userDAO;
	
	// ȸ������
	@Override
	public int insert(UserVO userVO){
		
		int result = 0;
		
		result = userDAO.insert(userVO);
		
		return result;
	}

	// �α���
	@Override
	public UserVO selectLogin(String username){
		
		return userDAO.selectLogin(username);
	}

	@Override
	public int selectCntByUid(String user_id) {

		return userDAO.selectCntByUid(user_id);
	}

  }
