package pj.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.spring.vo.*; 

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
	
	// �ֹ����� ���
	public List<OrderedVO> selectorderhistory(String user_id);

	// ��ҳ��� ���
	public List<OrderedVO> selectorderhistorycancel(String user_id);

	// �ֹ����� ��
	public OrderedVO selectorderhistorydetail(String ordered_no);

	// �ֹ����� ��(��ǰ)
	public List<OrderedVO> selectorderhistorydetailp(String ordered_no);
	
	// ���� ������ ���
	public List<ReviewVO> selectReviewPossibleList(String user_id);

	// ���� �ۼ��� ���
	public List<ReviewVO> selectReviewList(String user_id);
	
	// ���� ��� �� ��ǰ ��ȸ
	public ProductVO selectProduct(String product_no);
	
	// ���� ���
	public int insertReview(ReviewVO reviewVO);
	
	// ���� ���� �� ��ȸ
	public ReviewVO selectReview(String review_no);
	
	// ���� ����
	public int updateReview(ReviewVO reviewVO);
	
	// ����   ����
	public int deleteReview(String review_no);
	
	// ���ø���Ʈ ��ȸ
	public List<WishlistVO> selectWishlist(String user_id);
	
	// ���ø���Ʈ ���
	public int insertWishlist(WishlistVO wishlistVO);
	
	// ���ø���Ʈ ����
	public int deleteWishlist(String wishlist_no);
	
	// īƮ�� �̵�
	public int insertCart(CartVO cartVO);
	
	// ���ø���Ʈ ��ȸ
	public List<WishlistVO> getGuestWishlistFromCookies(HttpServletRequest request);

	// ���ø���Ʈ ���
	public void addGuestWishlistToCookies(String product_no, HttpServletRequest request, HttpServletResponse response);

	// ���ø���Ʈ ����
	public void removeGuestWishlistFromCookies(String wishlist_no, HttpServletRequest request, HttpServletResponse response);

	// īƮ�� �̵�
	public void addGuestCartToCookies(String product_no, HttpServletRequest request, HttpServletResponse response);
	
	// �α��� �� ��ȸ�� ���ø���Ʈ DB�� �̵�
	public void migrateGuestWishlistToDB(HttpServletRequest request, String username, HttpServletResponse response);

}
