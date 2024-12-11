package pj.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/index_search.do", method= RequestMethod.GET)
	public String indexSearch(Model model, SearchVO searchVO, @RequestParam(value="nowPage", required = false, defaultValue="1") int nowpage, HttpServletRequest request) {
		
		int total = homeService.selectProductTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 5);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<ProductVO> search = homeService.selectIndexSearch(searchVO);
		model.addAttribute("search", search);
		model.addAttribute("paging", paging);
		
		// �˻�� �ҷ����� ����
		model.addAttribute("searchVo", searchVO);
		
		return "user/menu/index_search";
	}
	
	
	/*
	 * @RequestMapping(value = "/list.do", method = RequestMethod.GET) public String
	 * newList() {
	 * 
	 * return "user/menu/new_list"; }
	 */
}
