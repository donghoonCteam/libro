package pj.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.spring.service.HomeService;
import pj.spring.util.PagingUtil;
import pj.spring.vo.ProductVO;
import pj.spring.vo.SearchVO;


// model : ȭ�鿡 �ѷ��ֱ� ����
// @RequestParam : pagingó�� �� nowpage�� default ���� 1�� ����
// HttpServletRequest : �Ķ���� ȣ��?�� ����
@Controller
public class HomeController {
	
	@Autowired
	public HomeService homeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) { // ȭ�鿡 �ѷ��ֱ� ���� model ����
		
		List<ProductVO> today = homeService.selectTodayBook();
		List<ProductVO> bestseller = homeService.selectBestSellerBook();
		List<ProductVO> hot = homeService.selectHotBook();
		
		model.addAttribute("today", today);
		model.addAttribute("bestseller", bestseller);
		model.addAttribute("hot", hot);
		
		return "home";
	}
	
	@RequestMapping(value="/indexSearch.do", method= RequestMethod.GET)
	public String indexSearch(Model model, SearchVO searchVO, @RequestParam(value="nowPage", required = false, defaultValue="1") int nowpage, HttpServletRequest request) {
		
		int total = homeService.selectProductTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 5);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<ProductVO> search = homeService.selectIndexSearch(searchVO);
		List<ProductVO> recommend = homeService.selectRecommend();
		
		model.addAttribute("search", search);
		model.addAttribute("paging", paging);
		// �˻�� �ҷ����� ����
		model.addAttribute("searchVo", searchVO);
		model.addAttribute("recommend", recommend);
		
		return "user/menu/indexSearch";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectCart.do", produces = "application/json; charset=UTF-8")
	public List<ProductVO> selectCart(HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user_id = authentication.getName();
		System.out.println("user_id : " + user_id);

        // �α����� ����ڶ�� user_id �������� (Ȯ���ϱ�)
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
            	user_id = ((UserDetails) principal).getUsername();
            } else {
            	user_id = principal.toString();
            }
        }

        // ��ȸ���� ��� ���ǿ��� guest_no ��������
        String guest_no = (String) session.getAttribute("guest_no");

        // �ʿ��� ���� ó��
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", user_id);
        params.put("guest_no", guest_no);

        // DB ���� ȣ�� (Mapper�� ���� ������ ��������)
        return homeService.selectCart(params);
    }
	
	
	@ResponseBody
	@RequestMapping(value = "/deleteCart.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public int deleteCart(@RequestParam("cart_no") String cart_no) {
	    
	    int result = homeService.deleteCart(cart_no);
	    	
	    return result;
	}
}
