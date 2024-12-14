package pj.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pj.spring.vo.AddressBookVO;
import pj.spring.vo.ContactVO;
import pj.spring.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	public SqlSession sqlSession;
	
	private final String namespace = "pj.spring.mapper.userMapper";
	
	// ȸ������
	public int insert(UserVO userVO) {
		return sqlSession.insert(namespace + ".userInsert", userVO);
	}

	// ���̵� �ߺ� üũ
	public int selectCntByUid(String user_id) {
		return sqlSession.selectOne(namespace + ".selectCntByUid", user_id);
	}

	// �α���
	public UserVO selectLogin(String username) {
		return sqlSession.selectOne(namespace + ".selectUserByLogin", username);
	}
	
	// �ּҷ� ���
	public List<AddressBookVO> list(String user_id) {
		return sqlSession.selectList(namespace + ".addrlistSelect", user_id);
	}

	// �ּҷ� ���
	public int addrinsert(AddressBookVO addressbookVO) {
		return sqlSession.insert(namespace + ".addrInsert", addressbookVO);
	}
	
	// �ּҷ� ����
	public int addrdelete(String address_book_no) {
		return sqlSession.delete(namespace + ".addrDelete", address_book_no);
	}

	// �ּҷ� ����
	public AddressBookVO addrmodify(String address_book_no) {
		return sqlSession.selectOne(namespace + ".addrModify", address_book_no);
	}

	// �ּҷ� ������Ʈ
	public int addrmodifyOk(AddressBookVO addressbookVO) {
		return sqlSession.update(namespace + ".addrModifyOk", addressbookVO);
	}
	
	// ȸ�� ����
	public UserVO memberinfoselect(String user_id) {
		return sqlSession.selectOne(namespace + ".memberinfoSelect", user_id);
	}

	// ȸ�� ����  ������Ʈ
	public int memberinfomodify(UserVO userVO) {
		return sqlSession.update(namespace + ".memberinfoModify", userVO);
	}

	// �����ϱ�
	public int insertcontact(ContactVO contactVO) {
		return sqlSession.insert(namespace + ".insertContact", contactVO);
	}
	
	// �����ϱ� ÷������
	public int insertattachment(ContactVO contactVO) {
		return sqlSession.insert(namespace + ".insertAttachment", contactVO);
	}
	
	// �����ϱ� ÷������ ��
	public int insertattachmentdetail(ContactVO contactVO) {
		return sqlSession.insert(namespace + ".insertAttachmentDetail", contactVO);
	}
	
	// �����ϱ� ���
	public List<ContactVO> selectcontactlist(String user_id) {
		return sqlSession.selectList(namespace + ".selectContactList", user_id);
	}

	// �����ϱ� ��
	public ContactVO selectcontact(String contact_no) {
		return sqlSession.selectOne(namespace + ".selectContact", contact_no);
	}
	
	// �����ϱ� ����
	public int deletecontact(String contact_no) {
		return sqlSession.delete(namespace + ".deleteContact", contact_no);
	}
}
