package pj.spring.service;

import java.util.List;
import java.util.Map;

import pj.spring.vo.OrderedVO;
import pj.spring.vo.PaymentVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.UserVO;

public interface AdminService {
	
	// ��ú��� �ֹ� ����  �� ��
	public Map<String, Object> orderCount();
	
	// ��ú��� ��� ����  �� ��
	public Map<String, Object> cancelCount();
	
	// ��ú��� ����/���� ����  �� ��
	public Map<String, Object> contentCount();
	
	// ȸ�� ���� list
	public List<UserVO> userList(Map<String,Integer> pagingParam);
	
	// ȸ�� ��ü ��
	public int selectTotal();
	
	// ��ǰ ���
	public int insertProduct(ProductVO productVO);
	
	// ��ǰ ÷������
	public int insertAttachment(ProductVO productVO);
	
	// ��ǰ ÷������ ��
	public int insertAttachmentDetail(ProductVO productVO);
	
	// ��ǰ ���� list
	public List<ProductVO> productList(Map<String,Integer> pagingParam);
	
	// ��ǰ ��ü ��
	public int productTotal();
	
	// ��ǰ ���� ��
	public ProductVO productModify(int product_no);
	
	// ��ǰ ����
	public int productModifyUpdate(ProductVO productVO);
	
	/*
	 * // ��ǰ ���� public int productDelete(int product_no);
	 */
	
	// �ֹ� ���� List
	public List<Map<String, Object>> orderList(Map<String,Integer> pagingParam);
	
	// �ֹ� ���� ��ü ��
	public int orderTotal();
	
	// ordered_status ���� ajax
	public int updateOrderStatus(OrderedVO orderedVO);
	
	// �ֹ� ��� ���� List
	public List<Map<String, Object>> orderCancelList(Map<String,Integer> pagingParam);
	
	// �ֹ� ��� ��ü ��
	public int orderCancelTotal();
	
	// payment_type ���� ajax
	public int updateRefundStatus(PaymentVO paymentVO);
	
	// ���� ���� list
	public List<Map<String, Object>> reviewList(Map<String,Integer> pagingParam);
	
	// ���� ��ü ��
	public int reviewTotal();
	
	

}
