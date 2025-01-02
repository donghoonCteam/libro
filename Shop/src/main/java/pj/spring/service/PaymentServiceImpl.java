package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pj.spring.dao.PaymentDAO;
import pj.spring.vo.OrderedDetailVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.PaymentVO;
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

	@Override
    public void insertPayment(PaymentVO payment) {
        paymentDAO.insertPayment(payment); // DAO ȣ��
    }

    @Override
    public void insertOrder(OrderedVO order) {
        paymentDAO.insertOrder(order); // DAO ȣ��
    }

    @Override
    public void insertOrderDetail(OrderedDetailVO orderDetail) {
        paymentDAO.insertOrderDetail(orderDetail); // DAO ȣ��
    }

    @Transactional
    @Override
    public void processOrder(OrderedVO order, List<OrderedDetailVO> orderDetails, PaymentVO payment) {
        // ���� ������ ����
        insertPayment(payment);

        // �ֹ� ������ ����        
        insertOrder(order);

        // �ֹ� �� ������ ����
        for (OrderedDetailVO detail : orderDetails) {
        	detail.setOrdered_no(order.getOrdered_no()); // �ڵ� ������ ordered_no ���
            insertOrderDetail(detail);
        }
    }
}
