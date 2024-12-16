package pj.spring.service;

import java.util.List;

import pj.spring.vo.AddressBookVO;
import pj.spring.vo.ContactVO;
import pj.spring.vo.UserVO;

public interface UserService {
	
	// ȸ������
	public int insert(UserVO userVO);

	// �α���
	public UserVO selectLogin(String username);

	// ���̵� �ߺ� üũ
	public int selectCntByUid(String user_id);
	
	// �ּҷ� ���
	public List<AddressBookVO> list(String user_id);
	
	// �ּҷ� ���
	public int addrinsert(AddressBookVO addressbookVO);
	
	// �ּҷ� ����
	public int addrdelete(String address_book_no);

	// �ּҷ� ����
	public AddressBookVO addrmodify(String address_book_no);

	// �ּҷ� ������Ʈ
	public int addrmodifyOk(AddressBookVO addressbookVO);
	
	// ȸ�� ����
	public UserVO memberinfoselect(String user_id);

	// ȸ�� ���� ������Ʈ
	public int memberinfomodify(UserVO userVO);
	
	// �����ϱ�
	public int insertcontact(ContactVO contactVO);

	// �����ϱ� ÷������
	public int insertattachment(ContactVO contactVO);

	// �����ϱ� ÷������ ��
	public int insertattachmentdetail(ContactVO contactVO);
	
	// �����ϱ� ���
	public List<ContactVO> selectcontactlist(String user_id);
	
	// �����ϱ� ��
	public ContactVO selectcontact(String contact_no);

	// �����ϱ� ����
	public ContactVO updateContact(String contact_no);
	
	// �����ϱ� ������Ʈ
	public int updateokcontact(ContactVO contactVO);
	
	// �����ϱ� ÷������ ������Ʈ
	public List<ContactVO> selectattachment(String contact_no);
	
	// �����ϱ� ÷������ ����
	public int deletetattachment(String attachment_no);
	
	// �����ϱ� ÷������ �� ����
	public int deletetattachmentdetail(String attachment_no);
	
	// �����ϱ� ����
	public int deletetcontact(String contact_no);
}
