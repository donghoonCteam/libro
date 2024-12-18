package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.UserDAO;
import pj.spring.vo.*;

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

	// �ּҷ� ����
	@Override
	public int addrdelete(String address_book_no) {
		return userDAO.addrdelete(address_book_no);
	}

	// �ּҷ� ����
	@Override
	public AddressBookVO addrmodify(String address_book_no) {
		return userDAO.addrmodify(address_book_no);
	}

	// �ּҷ� ������Ʈ
	@Override
	public int addrmodifyOk(AddressBookVO addressbookVO) {
		return userDAO.addrmodifyOk(addressbookVO);
	}

	// ȸ�� ����
	@Override
	public UserVO memberinfoselect(String user_id) {
		return userDAO.memberinfoselect(user_id);
	}

	// ȸ�� ���� ������Ʈ
	@Override
	public int memberinfomodify(UserVO userVO) {
		return userDAO.memberinfomodify(userVO);
	}

	// �����ϱ�
	@Override
	public int insertcontact(ContactVO contactVO) {
		return userDAO.insertcontact(contactVO);
	}

	// �����ϱ� ÷������
	@Override
	public int insertattachment(ContactVO contactVO) {
		return userDAO.insertattachment(contactVO);
	}

	// �����ϱ� ÷������ ��
	@Override
	public int insertattachmentdetail(ContactVO contactVO) {
		return userDAO.insertattachmentdetail(contactVO);
	}

	// �����ϱ� ���
	@Override
	public List<ContactVO> selectcontactlist(String user_id) {
		return userDAO.selectcontactlist(user_id);
	}

	// �����ϱ� ��
	@Override
	public ContactVO selectcontact(String contact_no) {
		return userDAO.selectcontact(contact_no);
	}

	// �����ϱ� ����
	@Override
	public ContactVO updateContact(String contact_no) {
		return userDAO.updatecontact(contact_no);
	}

	// �����ϱ� ������Ʈ
	@Override
	public int updateokcontact(ContactVO contactVO) {
		return userDAO.updateokcontact(contactVO);
	}
	
	// �����ϱ� ÷������ ������Ʈ
	@Override
	public List<ContactVO> selectattachment(String contact_no) {
		return userDAO.selectattachment(contact_no);
	}
	
	// �����ϱ� ÷������ �� ������Ʈ
	@Override
	public int deletetattachment(String attachment_no) {
		return userDAO.deleteAttachment(attachment_no);
	}
	
	// �����ϱ� ÷������ �� ������Ʈ
	@Override
	public int deletetattachmentdetail(String attachment_no) {
		return userDAO.deleteAttachmentDetail(attachment_no);
	}
	
	// �����ϱ� ����
	@Override
	public int deletetcontact(String contact_no) {
		return userDAO.deletecontact(contact_no);
	}
	
	// �ֹ����� ���
	public List<OrderedVO> selectorderhistory(String user_id) {
		return userDAO.selectorderhistory(user_id);
	}

	// ��ҳ��� ���
	@Override
	public List<OrderedVO> selectorderhistorycancel(String user_id) {
		return userDAO.selectorderhistorycancel(user_id);
	}

	// �ֹ����� ��
	@Override
	public OrderedVO selectorderhistorydetail(String ordered_no) {
		return userDAO.selectOrderhistorydetail(ordered_no);
	}

	// �ֹ����� ��(��ǰ)
	@Override
	public List<OrderedVO> selectorderhistorydetailp(String ordered_no) {
		return userDAO.selectOrderhistorydetailp(ordered_no);
	}

	// ���� ������ ���
	@Override
	public List<ReviewVO> selectReviewPossibleList(String user_id) {
		return userDAO.selectReviewPossibleList(user_id);
	}

	// ���� �ۼ��� ���
	@Override
	public List<ReviewVO> selectReviewList(String user_id) {
		return userDAO.selectReviewList(user_id);
	}

	// ���� ��� �� ��ǰ ��ȸ
	@Override
	public ProductVO selectProduct(String product_no) {
		return userDAO.selectProduct(product_no);
	}

	// ���� ���
	@Override
	public int insertReview(ReviewVO reviewVO) {
		return userDAO.insertReview(reviewVO);
	}
	
	// ���� ���� �� ��ȸ
	@Override
	public ReviewVO selectReview(String review_no) {
		return userDAO.selectReview(review_no);
	}

	// ���� ����
	@Override
	public int updateReview(ReviewVO reviewVO) {
		return userDAO.updateReview(reviewVO);
	}

	// ����   ����
	@Override
	public int deleteReview(String review_no) {
		return userDAO.deleteReview(review_no);
	}
}
