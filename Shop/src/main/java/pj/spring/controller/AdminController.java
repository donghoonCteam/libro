package pj.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pj.spring.service.AdminService;
import pj.spring.util.PagingUtil;
import pj.spring.vo.ProductVO;
import pj.spring.vo.UserVO;

@RequestMapping(value="/admin")
@Controller
public class AdminController {

	@Autowired
	public AdminService adminService;
	
	// ��ú���
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(Model model) {
		
		Map<String, Object> orderCount = adminService.orderCount();
		Map<String, Object> cancelCount = adminService.cancelCount();
		Map<String, Object> contentCount = adminService.contentCount();
        
        model.addAttribute("orderCount", orderCount);
        model.addAttribute("cancelCount", cancelCount);
        model.addAttribute("contentCount", contentCount);
		
		return "admin/index";
	}
	
	// ȸ�� ����
	@RequestMapping(value = "/membership.do", method = RequestMethod.GET)
	public String membership(Model model
			, @RequestParam(value="nowPage", required=false, defaultValue ="1")int nowPage) {
		
		int total = adminService.selectTotal();
		
		PagingUtil paging = new PagingUtil(nowPage, total, 10);
		
		Map<String,Integer> pagingParam =new HashMap<String,Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());
		
		//�����Ͻ� ���� : DB�� �ִ� ��ü ȸ�� ��� �����Ͱ�������
		 List<UserVO> list= adminService.userList(pagingParam);
		
		//�� ��ü ����Ͽ� ��ȸ ������ ȭ������ ������
		model.addAttribute("list", list);
		model.addAttribute("paging",paging);
		
		return "admin/membership";
	}
	
	// ��ǰ ����
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String product() {
		
		return "admin/product";
	}
	
	//��ǰ ���
	@RequestMapping(value = "/productWrite.do", method = RequestMethod.GET)
	public String productWrite() {
		
		return "admin/productWrite";
	}
	
	@RequestMapping(value = "/productWrite.do", method = RequestMethod.POST)
	public String productWrite(ProductVO productVO, MultipartFile topFile, @RequestParam(value = "multiFile")List<MultipartFile> multiFile, HttpServletRequest request ) throws IllegalStateException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user_id = authentication.getName();
		
		productVO.setUser_id(user_id);
		productVO.setProduct_no(productVO.getProduct_no());
		productVO.setProduct_status(productVO.getProduct_status());
		productVO.setCategory_name(productVO.getCategory_name());
		productVO.setProduct_price(productVO.getProduct_price());
		productVO.setProduct_stock(productVO.getProduct_stock());
		productVO.setProduct_name(productVO.getCategory_name());
		productVO.setProduct_isbn(productVO.getProduct_isbn());
		productVO.setProduct_page(productVO.getProduct_page());
		productVO.setProduct_description(productVO.getProduct_description());
		productVO.setProduct_author(productVO.getProduct_author());
		productVO.setProduct_author_description(productVO.getProduct_author_description());
		
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println("upload path -> " + path);
		
		File dir = new File(path);
		
		if(!dir.exists()) { 
			dir.mkdirs(); 
		}
		
		StringBuilder topNewFileName = new StringBuilder();
		
		if(!topFile.getOriginalFilename().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String fileRealPath = uuid + topFile.getOriginalFilename();
			
			topFile.transferTo(new File(path, fileRealPath));
			
			if (topNewFileName.length() > 0) {
				topNewFileName.append(","); // �޸��� ����
            }
			topNewFileName.append(fileRealPath);
			
		}
		
		StringBuilder newFileName = new StringBuilder();
		for(MultipartFile file : multiFile) {
			if(!file.getOriginalFilename().isEmpty()) {
				UUID uuid = UUID.randomUUID();
				String fileRealName = uuid.toString()+file.getOriginalFilename();
				
				file.transferTo(new File(path, fileRealName));
				
				if (newFileName.length() > 0) {
					newFileName.append(","); // �޸��� ����
	            }
				newFileName.append(fileRealName);
				
			}
		}
		
		productVO.setAttachment_detail_name(topFile.toString());
		productVO.setAttachment_detail_new_name(topNewFileName.toString());
		productVO.setAttachment_detail_name(multiFile.toString());
		productVO.setAttachment_detail_new_name(newFileName.toString());
		
		try {
			adminService.insertProduct(productVO);
			adminService.insertAttachment(productVO);
			adminService.insertAttachmentDetail(productVO);
			
			System.out.println("��ϿϷ�");
			return "redirect:product.do";
			
		} catch(Exception e) {
			System.out.println("��� ���� -> " + e.getMessage());
			return "redirect:productWrite.do";
		}
		
	}
	
	// �ֹ� ����
	@RequestMapping(value = "/order.do", method = RequestMethod.GET)
	public String order() {
		
		return "admin/order";
	}
	
	// ��� ����
	@RequestMapping(value = "/cancel.do", method = RequestMethod.GET)
	public String cancel() {
		
		return "admin/cancel";
	}
	
	// ���� ����
	@RequestMapping(value = "/sales.do", method = RequestMethod.GET)
	public String sales() {
		
		return "admin/sales";
	}
	
	// ���� ����
	@RequestMapping(value = "/review.do", method = RequestMethod.GET)
	public String review() {
		
		return "admin/review";
	}
	
	// ���� ����
	@RequestMapping(value = "/contact.do", method = RequestMethod.GET)
	public String contact() {
		
		return "admin/contact";
	}
	
	
}
