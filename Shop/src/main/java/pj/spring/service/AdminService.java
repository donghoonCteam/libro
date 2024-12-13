package pj.spring.service;

import java.util.List;
import java.util.Map;

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
	
	
}
