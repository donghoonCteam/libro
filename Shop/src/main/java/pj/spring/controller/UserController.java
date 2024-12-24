package pj.spring.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pj.spring.service.UserService;
import pj.spring.vo.*;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;

	// �α���
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login() {
		
		return "user/account/login";
	}
	
	//	ȸ������
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		
		return "user/account/join";
	}
	
	@RequestMapping(value = "/joinOk.do", method = RequestMethod.POST)
	public String joinOk(UserVO userVO) {

		System.out.println("user_id : " + userVO.getUser_id());
		System.out.println("user_password : " + userVO.getUser_password());
		System.out.println("user_name : " + userVO.getUser_name());
		System.out.println("user_email : " + userVO.getUser_email());
		System.out.println("user_phone : " + userVO.getUser_phone());
		
		BCryptPasswordEncoder epwe = new BCryptPasswordEncoder(); // ��ȣȭ�� �ȵǴ� 
		
		userVO.setUser_password(epwe.encode(userVO.getUser_password()));
		
		int result = userService.insert(userVO);
		
		if(result > 0) {
			System.out.println("��ϿϷ�");
		}else {
			System.out.println("��Ͻ���");
		}
		
		return "redirect:/";
	}
	
	
	// ���̵� �ߺ� üũ
	@ResponseBody
	@RequestMapping(value = "/ajax/checkID.do", method = RequestMethod.GET)
	public String checkID(String user_id) {
		
		String msg = "";
		
		int isId = userService.selectCntByUid(user_id);
		
		/*
			ajax ��û�� ��Ʈ�ѷ������� response ���ڼ��� ������ �� �����Ƿ� �ַ� ���䰪�� �������� �ۼ��Ͽ� 
			ȭ�鿡�� �����մϴ�.
		*/
		
		if(isId > 0){
			// ID �ߺ�
			
			msg = "fail";
		}else {
			// ID �ߺ� X
			
			msg = "success";
		}
		
		return msg;
	}
	
	// ȸ�� ����
	@RequestMapping(value="memberinfo.do", method=RequestMethod.GET)
	public String memberinfo(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		UserVO vo = userService.memberinfoselect(username);
		
		model.addAttribute("vo", vo);
		
		return "user/account/memberinfo";
	}
	
	@RequestMapping(value="memberinfoOk.do", method=RequestMethod.POST)
	public String memberinfo(UserVO vo, HttpServletRequest request) {
		
		BCryptPasswordEncoder epwe = new BCryptPasswordEncoder(); // ��ȣȭ�� �ȵǴ� 
		
		vo.setUser_password(epwe.encode(vo.getUser_password()));
		
		int result = userService.memberinfomodify(vo);
		
		if(result > 0) {
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("���� ����");
		}

		return "redirect:memberinfo.do";
	}

	// ȸ��Ż��
	@RequestMapping(value="deleteAccount.do")
	public String deleteAccount(Principal principal) {
		
		int result = userService.deleteAccount(principal.getName());
		
		if(result > 0) {
			System.out.println("Ż�� �Ϸ�");
		}else {
			System.out.println("Ż�� ����");
		}
		
		return "redirect:/";
	}
	
	// �ּҷ� ���
	@RequestMapping(value="/addr.do", method = RequestMethod.GET)
	public String addr(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<AddressBookVO> list = userService.list(username);
		
		System.out.println("�ּҷ� ���� : " + list.size());
		
		model.addAttribute("list", list);
		
		return "user/account/addr";
	}

	// �ּҷ� ���
	@RequestMapping(value="/addrregister.do", method = RequestMethod.GET)
	public String addrregister() {
		
		return "user/account/addrregister";
	}

	@RequestMapping(value="/addrregisterOk.do", method = RequestMethod.POST)
	public String addrregister(AddressBookVO vo, Principal principal) {
		
		System.out.println("�⺻ : " + vo.getAddress_book_top());
		System.out.println(principal.getName());
		
		vo.setUser_id(principal.getName());
		
		if("Y".equals(vo.getAddress_book_top()))
		{
			int result1 = userService.updateAddrTop(principal.getName());
			System.out.println("�⺻ ����");
		}
		
		int result = userService.addrinsert(vo);
		
		if(result > 0) {
			System.out.println("��� �Ϸ�");
		}else {
			System.out.println("��� ����");
		}

		return "redirect:/addr.do";
	}
	
	// �ּҷ� ����
	@RequestMapping(value="/addrdelete.do")
	public String addrdelete(String address_book_no) {
		
		int result = userService.addrdelete(address_book_no);
		
		if(result > 0) {
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("���� ����");
		}
		
		return "redirect:/addr.do";
	}
	
	// �ּҷ� ����
	@RequestMapping(value="addrmodify.do", method=RequestMethod.GET)
	public String addrmodify(String address_book_no, Model model) {
		
		AddressBookVO vo = userService.addrmodify(address_book_no);
		
		System.out.println(vo.getAddress_book_top());
		
		model.addAttribute("vo", vo);

		return "user/account/addrmodify";
	}
	
	@RequestMapping(value="addrmodifyOk.do", method=RequestMethod.POST)
	public String addrmodify(AddressBookVO vo, Principal principal) {
		
		System.out.println("�⺻ : " + vo.getAddress_book_top());
		System.out.println(principal.getName());
		
		if("Y".equals(vo.getAddress_book_top()))
		{
			int result1 = userService.updateAddrTop(principal.getName());
			System.out.println("�⺻ ����");
		}
		int result = userService.addrmodifyOk(vo);
		
		if(result > 0) {
			System.out.println("���� �Ϸ�");

			return "redirect:/addr.do";
		}else {
			System.out.println("���� ����");
			
			return "redirect:addrmodify.do?address_book_no=" + vo.getAddress_book_no();
		}
	}
	
	// �� �Խù�
	@RequestMapping(value="mypost.do", method=RequestMethod.GET)
	public String myposting(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<ContactVO> contactlist = userService.selectcontactlist(username);
		List<ReviewVO> reviewpossiblelist = userService.selectReviewPossibleList(username);
		List<ReviewVO> reviewlist = userService.selectReviewList(username);
		
		System.out.println("�ּҷ� ���� : " + contactlist.size());
		System.out.println("�ּҷ� ���� : " + reviewpossiblelist.size());
		System.out.println("�ּҷ� ���� : " + reviewlist.size());
		
		model.addAttribute("contactlist", contactlist);
		model.addAttribute("reviewpossiblelist", reviewpossiblelist);
		model.addAttribute("reviewlist", reviewlist);
		
		return "user/account/mypost";
	}
	
	// �����ϱ�
	@RequestMapping(value="inquiry.do", method=RequestMethod.GET)
	public String inquiry() {
		
		return "user/account/inquiry";
	}

	@RequestMapping(value="inquiryOk.do", method=RequestMethod.POST)
	public String inquiry(ContactVO vo, @RequestParam(value = "multiFile")List<MultipartFile> multiFile, HttpServletRequest request) throws IllegalStateException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		System.out.println("username" + username);
		vo.setUser_id(username);
		System.out.println("username ����");
		
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println("upload path : " + path);
		
		File dir = new File(path);
		
		if(!dir.exists()) { 
			dir.mkdirs(); 
		}
		
	    try {
	    	userService.insertcontact(vo);
	    	
	    	if (multiFile != null && !multiFile.isEmpty()) {
				
	    		for(MultipartFile file : multiFile) {
	    			
					if(!file.getOriginalFilename().isEmpty()) {
					UUID uuid = UUID.randomUUID();
					String originalFileName = file.getOriginalFilename();
					String newFileName  = uuid.toString() + "_" + originalFileName;
					
					file.transferTo(new File(path, newFileName ));
					
	                userService.insertattachment(vo); // ÷������ ���� ���� (PK ����)
					
	             // ÷������ �� ���� ����
					vo.setAttachment_detail_name(originalFileName); // ���� ���ϸ�
					vo.setAttachment_detail_new_name(newFileName); // �� ���ϸ�
					vo.setAttachment_detail_path(path); // ���
					vo.setAttachment_no(vo.getAttachment_no()); // ÷������ ��ȣ
					vo.setAttachment_detail_create_id(username); // ������ ID
					vo.setAttachment_detail_update_id(username); // ������ ID
					
					System.out.println("newFileName" + vo.getAttachment_detail_new_name());
					System.out.println("path" + vo.getAttachment_detail_path());
	                userService.insertattachmentdetail(vo); // ÷������ �� ����
					}
				}
	    	}
	        // ����
	        System.out.println("��� ����");
	        return "redirect:inquirydetail.do?contact_no=" + vo.getContact_no();

	    } catch (Exception e) {
	        // ���� ó��
	        System.err.println("��� ����: " + e.getMessage());
	        return "redirect:inquiry.do";
	    }
	}
	
	// �����ϱ� ����
	@RequestMapping(value="inquirymodify.do", method=RequestMethod.GET)
	public String inquirymodify(String contact_no, Model model) {
			
		ContactVO vo = userService.updateContact(contact_no);
			
			model.addAttribute("vo", vo);
			
		return "user/account/inquirymodify";
	}
	
	@RequestMapping(value="inquirymodifyOk.do", method=RequestMethod.POST)
	public String inquirymodify(ContactVO vo, @RequestParam(value = "multiFile")List<MultipartFile> multiFile, HttpServletRequest request) throws IllegalStateException, IOException {
		
		System.out.println("������");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		vo.setContact_update_id(username);
		
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println("upload path : " + path);
		
		File dir = new File(path);
		
		if(!dir.exists()) { 
			dir.mkdirs(); 
		}
		
		try {
			
			userService.updateokcontact(vo);
			
			System.out.println("updateokcontact ����");
			
	    	if (multiFile != null && !multiFile.isEmpty()) {
	    		
	    		List<ContactVO> attachmentList  = userService.selectattachment(vo.getContact_no());
	    		if (attachmentList != null && !attachmentList.isEmpty()) {
		    		for (ContactVO attachment : attachmentList) {
		    			userService.deletetattachmentdetail(attachment.getAttachment_no());
		    			userService.deletetattachment(attachment.getAttachment_no());
		    		}
		    		System.out.println("���� �Ϸ�");
	    		}
	    		for(MultipartFile file : multiFile) {
	    			
					if(!file.getOriginalFilename().isEmpty()) {
						UUID uuid = UUID.randomUUID();
						String originalFileName = file.getOriginalFilename();
						String newFileName  = uuid.toString() + "_" + originalFileName;
						
						file.transferTo(new File(path, newFileName ));
						
		                userService.insertattachment(vo); // ÷������ ���� ���� (PK ����)
		                System.out.println("1�� �Ϸ�");
						System.out.println(username);
		                
		             // ÷������ �� ���� ����
						vo.setAttachment_detail_name(originalFileName); // ���� ���ϸ�
						vo.setAttachment_detail_new_name(newFileName); // �� ���ϸ�
						vo.setAttachment_detail_path(path); // ���
						vo.setAttachment_no(vo.getAttachment_no()); // ÷������ ��ȣ
						vo.setAttachment_detail_create_id(username); // ������ ID
						vo.setAttachment_detail_update_id(username); // ������ ID
						
						System.out.println("newFileName" + vo.getAttachment_detail_new_name());
						System.out.println("path" + vo.getAttachment_detail_path());
		                userService.insertattachmentdetail(vo); // ÷������ �� ����
		                System.out.println("2�� �Ϸ�");
					}
					
		    		System.out.println("���� ��� �Ϸ�");
	    		}
	    	}
	    	
			System.out.println("���� ����");
			return "redirect:inquirydetail.do?contact_no=" + vo.getContact_no();

		} catch (Exception e) {
			// ���� ó��
			System.err.println("���� ����: " + e.getMessage());
			return "redirect:inquiry.do";
		}
	}

	// �����ϱ� ��
	@RequestMapping(value="inquirydetail.do")
	public String inquirydetail(String contact_no, Model model) {
		
//		System.out.println("contact_no " + contact_no);
		
		ContactVO vo = userService.selectcontact(contact_no);
		
//		System.out.println("����Ʈ " + vo.getContact_no());
		
		model.addAttribute("vo", vo);
		
		return "user/account/inquirydetail";
	}
	
	// �����ϱ� ����
	@RequestMapping(value="contactdelete.do")
	public String deletecontact(String contact_no) {
		
		int result = userService.deletetcontact(contact_no);
		
		if(result > 0) {
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("���� ����");
		}
		
		return "redirect:/mypost.do";
	}
	
	// ���� ���
	@RequestMapping(value="reviewregister.do", method = RequestMethod.GET)
	public String reviewregister(String product_no, Model model) {
		
		ProductVO vo = userService.selectProduct(product_no);
		
		model.addAttribute("vo", vo);
		
		return "user/account/reviewregister";
	}

	@RequestMapping(value="reviewregisterOk.do", method = RequestMethod.POST)
	public String reviewregister(ReviewVO vo) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		vo.setUser_id(username);
		
		int result = userService.insertReview(vo);
		
		if(result > 0) {
			System.out.println("��� �Ϸ�");
		}else {
			System.out.println("��� ����");
		}

		return "redirect:/mypost.do";
	}
	
	// ���� ����
	@RequestMapping(value="reviewupdate.do", method = RequestMethod.GET)
	public String reviewupdate(String product_no, String review_no, Model model) {
		
		ProductVO vo = userService.selectProduct(product_no);
		ReviewVO rvo = userService.selectReview(review_no);
		
		model.addAttribute("vo", vo);
		model.addAttribute("rvo", rvo);
		
		return "user/account/reviewupdate";
	}

	@RequestMapping(value="reviewupdateOk.do", method = RequestMethod.POST)
	public String reviewupdate(ReviewVO vo) {
		
		int result = userService.updateReview(vo);

		if(result > 0) {
			System.out.println("���� �Ϸ�");

			return "redirect:/mypost.do";
		}else {
			System.out.println("���� ����");
			
			return "redirect:reviewupdate.do?review_no=" + vo.getReview_no();
		}
	}

	// ���� ����
	@RequestMapping(value="reviewdelete.do")
	public String reviewdelete(String review_no) {
		
		int result = userService.deleteReview(review_no);
		
		if(result > 0) {
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("���� ����");
		}

		return "redirect:/mypost.do";
	}

	// ��������
	@RequestMapping(value="notice.do", method=RequestMethod.GET)
	public String notice() {
		
		return "user/account/notice";
	}

	// �ֹ�(+���)���� ���
	@RequestMapping(value="orderhistory.do", method=RequestMethod.GET)
	public String orderhistory(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<OrderedVO> list = userService.selectorderhistory(username);
		List<OrderedVO> cancellist = userService.selectorderhistorycancel(username);
		
		System.out.println("�ֹ����� ���� : " + list.size());
		System.out.println("��ҳ��� ���� : " + cancellist.size());
		
		model.addAttribute("list", list);
		model.addAttribute("cancellist", cancellist);
		
		return "user/account/orderhistory";
	}
	
	// �ֹ����� ��
	@RequestMapping(value="orderhistorydetail.do")
	public String orderhistorydetail(String ordered_no, Model model) {
		
		System.out.println("ordered_no " + ordered_no);
		
		OrderedVO vo = userService.selectorderhistorydetail(ordered_no);
		List<OrderedVO> list = userService.selectorderhistorydetailp(ordered_no);
		
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		
		return "user/account/orderhistorydetail";
	}

	// ���ø���Ʈ ��ȸ
	@RequestMapping(value="wishlist.do")
	public String wishlist(Model model, HttpServletRequest request) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		// ��ȸ��
		if (username.equals("anonymousUser")) { 
			List<WishlistVO> list = userService.getGuestWishlistFromCookies(request);
			model.addAttribute("list", list);
		// ȸ��
		} else { 
			List<WishlistVO> list = userService.selectWishlist(username);
			System.out.println("���ø���Ʈ ���� : " + list.size());
			model.addAttribute("list", list);
		}
		
		return "user/account/wishlist";
	}
	
	// ���ø���Ʈ ���
	@RequestMapping(value="wishlistinsert.do")
	public String wishlistinsert(WishlistVO vo, HttpServletRequest request, HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		// ��ȸ��
		if (username.equals("anonymousUser")) { 
			userService.addGuestWishlistToCookies(vo.getProduct_no(), request, response);
			
		// ȸ��
		} else { 
			
			vo.setUser_id(username);
			int result = userService.selectDedupeWishlist(vo.getProduct_no());
			
			System.out.println("�ߺ���" + result);
			
			if (result > 0) {
				System.out.println("�̹� ��ϵ� ��ǰ�Դϴ�.");
			} else {
				int result1 = userService.insertWishlist(vo);
	 		}
		}
		
		return "redirect:/wishlist.do";
	}
	
	// ���ø���Ʈ ����
	@RequestMapping(value="wishlistdelete.do")
	public String wishlistdelete(String wishlist_no, HttpServletRequest request, HttpServletResponse response) {
		
		   // ��Ű ��������
//	    Cookie[] cookies = request.getCookies();
//	    
//	    if (cookies != null) {
//	        for (Cookie cookie : cookies) {
//	            // ��Ű �̸��� ���� ���
//	            System.out.println("��Ű �̸�: " + cookie.getName() + ", ��Ű ��: " + cookie.getValue());
//	        }
//	    } else {
//	        System.out.println("��Ű�� �������� �ʽ��ϴ�.");
//	    }
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		// ��ȸ��
		if (username.equals("anonymousUser")) { 
			userService.removeGuestWishlistFromCookies(wishlist_no, request, response);
		// ȸ��
		} else { 
			int result = userService.deleteWishlist(wishlist_no);
		
			if (result > 0) {
				System.out.println("ȸ�� ���ø���Ʈ ���� �Ϸ�");
			} else {
				System.out.println("ȸ�� ���ø���Ʈ ���� ����");
			}
		}
		
		return "redirect:/wishlist.do";
	}

	// īƮ�� �̵�
	@RequestMapping(value="cartinsert.do")
	public String cartinsert(String wishlist_no, CartVO vo, HttpServletRequest request, HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		if (username.equals("anonymousUser")) { // ��ȸ��
//			// ��ȸ���� ��Ű���� ���� �� īƮ ��Ű�� �̵�
//			String productNo = userService.removeGuestWishlistFromCookies(wishlist_no, request, response);
//			if (productNo != null) {
//				userService.addGuestCartToCookies(productNo, request, response);
//				System.out.println("��ȸ�� īƮ ��� �Ϸ�");
//			} else {
//				System.out.println("��ȸ�� ���ø���Ʈ ���� ����");
//			}
		} else { // ȸ��
			int result = userService.deleteWishlist(wishlist_no);
			if (result > 0) {
				vo.setUser_id(username);
				int result1 = userService.insertCart(vo);
		
				if (result1 > 0) {
						System.out.println("ȸ�� īƮ ��� �Ϸ�");
				} else {
					System.out.println("ȸ�� īƮ ��� ����");
				}
			} else {
				System.out.println("ȸ�� ���ø���Ʈ ���� ����");
			}
		}
		
		return "redirect:/wishlist.do";
	}
	
	// �α��� �� ȣ��Ǵ� �޼��忡�� ��ȸ�� ���ø���Ʈ DB�� �̵�
	@RequestMapping(value = "cookietodb.do")
	public String loginUser(String username, HttpServletRequest request, HttpServletResponse response) {
	    
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		username = authentication.getName();
		
	    Cookie[] cookies = request.getCookies();
	    boolean foundRecentlyProductCookie = false;
	    boolean foundWishlistCookie = false;
	    
	    if (cookies != null) {
	        
	        for (Cookie cookie : cookies) {
	        	System.out.println("��Ű �̸�: " + cookie.getName() + ", ��Ű ��: " + cookie.getValue());
	        	
	        	if (cookie.getName().startsWith("recentlyproduct_")) {
	        		foundRecentlyProductCookie = true;
	        	}
	        	if (cookie.getName().startsWith("wishlist_")) {
	        		foundWishlistCookie = true;
	        	}
	        }

	        // wishlist_ ��Ű�� �߰ߵǾ��� ��� DB�� �̵� ó��
	        if (foundRecentlyProductCookie || foundWishlistCookie) {
	            userService.migrateGuestWishlistToDB(request, username, response);
	        }
	    } else {
	        System.out.println("��Ű�� �������� �ʽ��ϴ�.");
	    }

	    return "redirect:/"; // �����̷��� ó��
	}
	

	// �ֱ� �� ��ǰ ��ȸ
	@RequestMapping(value="recentlyproducts.do")
	public String recentlyproducts(Model model, HttpServletRequest request) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		// ��ȸ��
		if (username.equals("anonymousUser")) { 
			List<RecentlyproductVO> list = userService.getGuestRecentlyProductFromCookies(request);
			model.addAttribute("list", list);
			// ȸ��
		} else { 
			List<RecentlyproductVO> list = userService.selectRecentlyproduct(username);
			System.out.println("�ֱ� �� ��ǰ ���� : " + list.size());
			model.addAttribute("list", list);
		}
		
		return "user/account/recentlyproducts";
	}
	
	// �ֱ� �� ��ǰ ���
	@RequestMapping(value="recentlyproductinsert.do")
	public String recentlyproductinsert(RecentlyproductVO vo, HttpServletRequest request, HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		// ��ȸ��
		if (username.equals("anonymousUser")) { 
			userService.addGuestRecentlyProductToCookies(vo.getProduct_no(), request, response);
		// ȸ��
		} else { 
			vo.setUser_id(username);
			int result = userService.insertRecentlyproduct(vo);
			
			if (result > 0) {
				System.out.println("ȸ�� ���ø���Ʈ ��� �Ϸ�");
			} else {
				System.out.println("ȸ�� ���ø���Ʈ ��� ����");
			}
		}
		
		return "redirect:/recentlyproducts.do";
	}
	
	// �ֱ� �� ��ǰ ����
	@RequestMapping(value="recentlyproductdelete.do")
	public String recentlyproductdelete(String recentlyproduct_no, HttpServletRequest request, HttpServletResponse response) {
		
		// ��Ű ��������
//	    Cookie[] cookies = request.getCookies();
//	    
//	    if (cookies != null) {
//	        for (Cookie cookie : cookies) {
//	            // ��Ű �̸��� ���� ���
//	            System.out.println("��Ű �̸�: " + cookie.getName() + ", ��Ű ��: " + cookie.getValue());
//	        }
//	    } else {
//	        System.out.println("��Ű�� �������� �ʽ��ϴ�.");
//	    }
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		// ��ȸ��
		if (username.equals("anonymousUser")) { 
			userService.removeGuestRecentlyProductFromCookies(recentlyproduct_no, request, response);
			// ȸ��
		} else { 
			int result = userService.deleteRecentlyproduct(recentlyproduct_no);
			
			if (result > 0) {
				System.out.println("ȸ�� �ֱٺ���ǰ ���� �Ϸ�");
			} else {
				System.out.println("ȸ�� �ֱٺ���ǰ ���� ����");
			}
		}
		
		return "redirect:/recentlyproducts.do";
	}
	
//	// īƮ�� �̵�
//	@RequestMapping(value="cartinsert.do")
//	public String cartinsert(String wishlist_no, CartVO vo, HttpServletRequest request, HttpServletResponse response) {
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName();
//		
//		if (username.equals("anonymousUser")) { // ��ȸ��
////			// ��ȸ���� ��Ű���� ���� �� īƮ ��Ű�� �̵�
////			String productNo = userService.removeGuestWishlistFromCookies(wishlist_no, request, response);
////			if (productNo != null) {
////				userService.addGuestCartToCookies(productNo, request, response);
////				System.out.println("��ȸ�� īƮ ��� �Ϸ�");
////			} else {
////				System.out.println("��ȸ�� ���ø���Ʈ ���� ����");
////			}
//		} else { // ȸ��
//			int result = userService.deleteWishlist(wishlist_no);
//			if (result > 0) {
//				vo.setUser_id(username);
//				int result1 = userService.insertCart(vo);
//				
//				if (result1 > 0) {
//					System.out.println("ȸ�� īƮ ��� �Ϸ�");
//				} else {
//					System.out.println("ȸ�� īƮ ��� ����");
//				}
//			} else {
//				System.out.println("ȸ�� ���ø���Ʈ ���� ����");
//			}
//		}
//		
//		return "redirect:/wishlist.do";
//	}
//	
//	// �α��� �� ȣ��Ǵ� �޼��忡�� ��ȸ�� ���ø���Ʈ DB�� �̵�
//	@RequestMapping(value = "cookietodb.do")
//	public String loginUser(String username, HttpServletRequest request, HttpServletResponse response) {
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		username = authentication.getName();
//		
//		Cookie[] cookies = request.getCookies();
//		
//		if (cookies != null) {
//			boolean foundWishlistCookie = false;  // wishlist_ ��Ű�� �����ϴ��� ���θ� �����ϴ� ����
//			
//			for (Cookie cookie : cookies) {
//				System.out.println("��Ű �̸�: " + cookie.getName() + ", ��Ű ��: " + cookie.getValue());
//				
//				// ��Ű �̸��� wishlist_�� �����ϸ�
//				if (cookie.getName().startsWith("wishlist_")) {
//					foundWishlistCookie = true;
//					break;  // wishlist_ ��Ű�� ã���� �ݺ��� ����
//				}
//			}
//			
//			// wishlist_ ��Ű�� �߰ߵǾ��� ��� DB�� �̵� ó��
//			if (foundWishlistCookie) {
//				userService.migrateGuestWishlistToDB(request, username, response);
//			}
//		} else {
//			System.out.println("��Ű�� �������� �ʽ��ϴ�.");
//		}
//		
//		return "redirect:/"; // �����̷��� ó��
//	}
}
