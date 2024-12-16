package pj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.UserDAO;
import pj.spring.vo.AddressBookVO;
import pj.spring.vo.ContactVO;
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
}
