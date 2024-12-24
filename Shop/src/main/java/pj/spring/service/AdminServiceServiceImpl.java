package pj.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.AdminDAO;
import pj.spring.vo.OrderedDetailVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.PaymentVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.UserVO;

@Service
public class AdminServiceServiceImpl implements AdminService {

	@Autowired
	public AdminDAO adminDAO;
	
	// ��ú��� �ֹ� ����  �� ��
	@Override
	public Map<String, Object> orderCount() {
		return adminDAO.orderCount();
	}

	// ��ú��� ��� ����  �� ��
	@Override
	public Map<String, Object> cancelCount() {
		return adminDAO.cancelCount();
	}

	// ��ú��� ����/���� ����  �� ��
	@Override
	public Map<String, Object> contentCount() {
		return adminDAO.contentCount();
	}

	// ȸ�� ���� list
	@Override
	public List<UserVO> userList(Map<String, Integer> pagingParam) {
		return adminDAO.userList(pagingParam);
	}
	
	// ȸ�� ��ü ��
	@Override
	public int selectTotal() {
		return adminDAO.selectTotal();
	}

	// ��ǰ ���
	@Override
	public int insertProduct(ProductVO productVO) {
		return adminDAO.insertProduct(productVO);
	}

	// ��ǰ ÷������
	@Override
	public int insertAttachment(ProductVO productVO) {
		return adminDAO.insertAttachment(productVO);
	}

	// ��ǰ ÷������ ��
	@Override
	public int insertAttachmentDetail(ProductVO productVO) {
		return adminDAO.insertAttachmentDetail(productVO);
	}

	// ��ǰ ���� list
	@Override
	public List<ProductVO> productList(Map<String, Integer> pagingParam) {
		return adminDAO.productList(pagingParam);
	}

	// ��ǰ ��ü ��
	@Override
	public int productTotal() {
		return adminDAO.productTotal();
	}

	// ��ǰ ���� ��
	@Override
	public ProductVO productModify(int product_no) {
		return adminDAO.productModify(product_no);
	}
	
	// ��ǰ ����
	@Override
	public int productModifyUpdate(ProductVO productVO) {
		return adminDAO.productModifyUpdate(productVO);
	}
	
	// ��ǰ ���� 
	@Override
	public int productDelete(ProductVO productVO) {
		return adminDAO.productDelete(productVO);
	}
	
	// �ֹ� ���� list
	@Override
	public List<Map<String, Object>> orderList(Map<String, Integer> pagingParam) {
		return adminDAO.orderList(pagingParam);
	}

	// �ֹ� ���� ��ü ��
	@Override
	public int orderTotal() {
		return adminDAO.orderTotal();
	}

	// ordered_status ���� ajax
	@Override
	public int updateOrderStatus(OrderedVO orderedVO) {
		return adminDAO.updateOrderStatus(orderedVO);
	}

	// �ֹ� ��� ���� list
	@Override
	public List<Map<String, Object>> orderCancelList(Map<String, Integer> pagingParam) {
		return adminDAO.orderCancelList(pagingParam);
	}

	// �ֹ� ��� ��ü ��
	@Override
	public int orderCancelTotal() {
		return adminDAO.orderCancelTotal();
	}

	// payment_type ���� ajax
	@Override
	public int updateRefundStatus(PaymentVO paymentVO) {
		return adminDAO.updateRefundStatus(paymentVO);
	}

	// ���� ���� list
	@Override
	public List<Map<String, Object>> reviewList(Map<String, Integer> pagingParam) {
		return adminDAO.reviewList(pagingParam);
	}

	// ���� ��ü ��
	@Override
	public int reviewTotal() {
		return adminDAO.reviewTotal();
	}

	// review_status ���� ���� ajax
	@Override
	public int reviewStatus(ReviewVO reviewVO) {
		return adminDAO.reviewStatus(reviewVO);
	}
	
	// ���ǰ��� list
	@Override
	public List<Map<String, Object>> contactList(Map<String, Integer> pagingParam) {
		return adminDAO.contactList(pagingParam);
	}

	// ���� ��ü ��
	@Override
	public int contactTotal() {
		return adminDAO.contactTotal();
	}

	//������� ���� �հ�
	//�� �ŷ��ݾ�
	@Override
	public OrderedDetailVO orderTotalAmount() {
		return adminDAO.orderTotalAmount();
	}

	//�� �����ݾ�
	@Override
	public PaymentVO paymentTotalAmount() {
		return adminDAO.paymentTotalAmount();
	}

	//�� �Ǹż���
	@Override
	public OrderedDetailVO orderTotalQuantity() {
		return adminDAO.orderTotalQuantity();
	}

	//������� list
	@Override
	public List<Map<String, Object>> salesList(Map<String, Integer> pagingParam) {
		return adminDAO.salesList(pagingParam);
	}

	//���� ���� ��ü ��
	@Override
	public int salesTotal() {
		return adminDAO.salesTotal();
	}


	

	

}
