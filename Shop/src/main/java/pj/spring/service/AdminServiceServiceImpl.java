package pj.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.AdminDAO;
import pj.spring.vo.ProductVO;
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

	// ��ǰ ����
	@Override
	public ProductVO productModify(int product_no) {
		return adminDAO.productModify(product_no);
	}
	
	// ��ǰ ����
	@Override
	public int productDelete(int product_no) {
		return adminDAO.productDelete(product_no);
	}

	
	

}
