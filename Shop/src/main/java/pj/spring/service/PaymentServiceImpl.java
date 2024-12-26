package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.PaymentDAO;
import pj.spring.vo.UserVO;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	public PaymentDAO paymentDAO;

	@Override
	public UserVO selectPaymentInfo(String user_id) {

		return paymentDAO.selectPaymentInfo(user_id);
	}

	@Override
	public List<UserVO> selectAddressBook(String user_id) {

		return paymentDAO.selectAddressBook(user_id);
	}
	
	
}
