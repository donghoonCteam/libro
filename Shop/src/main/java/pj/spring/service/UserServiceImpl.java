package pj.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID; 

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj.spring.dao.UserDAO;
import pj.spring.vo.AddressBookVO;
import pj.spring.vo.CartVO;
import pj.spring.vo.ContactVO;
import pj.spring.vo.OrderedVO;
import pj.spring.vo.ProductVO;
import pj.spring.vo.ReviewVO;
import pj.spring.vo.UserVO;
import pj.spring.vo.WishlistVO;

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

	// ���ø���Ʈ ��ȸ
	@Override
	public List<WishlistVO> selectWishlist(String user_id) {
		return userDAO.selectWishlist(user_id);
	}

	// ���ø���Ʈ ���
	@Override
	public int insertWishlist(WishlistVO wishlistVO) {
		return userDAO.insertWishlist(wishlistVO);
	}

	// ���ø���Ʈ ����
	@Override
	public int deleteWishlist(String wishlist_no) {
		return userDAO.deleteWishlist(wishlist_no);
	}

	// īƮ�� �̵�
	@Override
	public int insertCart(CartVO cartVO) {
		return userDAO.insertCart(cartVO);
	}

	// ���ø���Ʈ ��ȸ
	@Override
	public List<WishlistVO> getGuestWishlistFromCookies(HttpServletRequest request) {
		List<WishlistVO> list = new ArrayList<>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().startsWith("wishlist_")) {
		
					String product_no = cookie.getValue();

					ReviewVO product = userDAO.selectProductForGuest(product_no);
					
					WishlistVO vo = new WishlistVO();
					vo.setProduct_no(product.getProduct_no());
					vo.setAttachment_detail_new_name(product.getAttachment_detail_new_name());
					vo.setProduct_name(product.getProduct_name());
					vo.setProduct_author(product.getProduct_author());
					vo.setProduct_publisher(product.getProduct_publisher());
					vo.setReview_starrating(product.getReview_starrating());
					vo.setWishlist_no(cookie.getName().substring("wishlist_".length()));
//					System.out.println("��ȸ�� ���ù�ȣ : " + vo.getWishlist_no());
					list.add(vo);
				}	
			}
		}
		return list;
	}

	// ���ø���Ʈ ���
	@Override
	public void addGuestWishlistToCookies(String product_no, HttpServletRequest request, HttpServletResponse response) {
		String wishlistId = UUID.randomUUID().toString(); // ������ UUID ����
		Cookie cookie = new Cookie("wishlist_" + wishlistId, String.valueOf(product_no)); // ��Ű �̸��� �ϰ��ǰ� ����
		cookie.setPath("/"); // ��Ű�� ��� ��ο��� ��ȿ�ϵ��� ����
		cookie.setMaxAge(60 * 60 * 24 * 7); // 7�� ����
		response.addCookie(cookie); // ��Ű�� Ŭ���̾�Ʈ�� ����
	}

	// ���ø���Ʈ ����
	@Override
	public void removeGuestWishlistFromCookies(String wishlist_no, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies" + cookies);
		if (cookies != null) {
			for (Cookie cookie : cookies) {
//				System.out.println("name::"+cookie.getName().startsWith("wishlist_"));
//				System.out.println("value::"+cookie.getValue());
//				System.out.println("wishlist_no::"+wishlist_no);
				if (cookie.getName().startsWith("wishlist_") && cookie.getValue().equals(wishlist_no)) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					System.out.println("Deleting cookie: " + cookie.getName());
				}
			}
		}
	}

	// īƮ�� �̵�
	@Override
	public void addGuestCartToCookies(String product_no, HttpServletRequest request, HttpServletResponse response) {
	    Cookie cookie = new Cookie("cart_" + UUID.randomUUID(), product_no);
	    cookie.setPath("/");
	    cookie.setMaxAge(60 * 60 * 24 * 7); // 7�� ����
	    response.addCookie(cookie);
	}

	// �α��� �� ��ȸ�� ���ø���Ʈ DB�� �̵�
	@Override
	public void migrateGuestWishlistToDB(HttpServletRequest request, String username, HttpServletResponse response) {
	    Cookie[] cookies = request.getCookies();

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().startsWith("wishlist_")) {
	                // ��Ű�� ���� ��ǰ ��ȣ(product_no)
	                String product_no = cookie.getValue();

	                // DB�� ������ ���ø���Ʈ ��ü ����
	                WishlistVO vo = new WishlistVO();
	                vo.setProduct_no(product_no);
	                vo.setUser_id(username);  // �α����� ȸ���� ID
	                vo.setWishlist_create_id(username);
	                vo.setWishlist_update_id(username);

	                // DB�� ���ø���Ʈ ����
	                int result = userDAO.insertWishlist(vo);
	                if (result > 0) {
	                    System.out.println("��ȸ�� ���ø���Ʈ DB�� �̵� ����");
	                } else {
	                    System.out.println("��ȸ�� ���ø���Ʈ DB�� �̵� ����");
	                }

	                // ��Ű ����
	                cookie.setMaxAge(0);  // ��Ű ���� �ð� 0���� �����Ͽ� ����
	                cookie.setPath("/");
	                response.addCookie(cookie);  // ������ ��Ű�� Ŭ���̾�Ʈ�� ����
	                System.out.println("��Ű ����: " + cookie.getName());
	            }
	        }
	    }
	}

//	@Override
//	public List<WishlistVO> getGuestRecentlyProductFromCookies(HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addGuestRecentlyProductToCookies(String product_no, HttpServletRequest request,
//			HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void removeGuestRecentlyProductFromCookies(String wishlist_no, HttpServletRequest request,
//			HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		
//	}


}
