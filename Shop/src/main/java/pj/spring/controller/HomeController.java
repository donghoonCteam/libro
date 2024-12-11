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
		
		List<ProductVO> tvo = homeService.selectTodayBook();
		List<ProductVO> bsvo = homeService.selectBestSellerBook();
		List<ProductVO> hvo = homeService.selectHotBook();
		
		model.addAttribute("tvo", tvo);
		model.addAttribute("bsvo", bsvo);
		model.addAttribute("hvo", hvo);
		
		return "home";
	}
	
	@RequestMapping(value="/index_search.do", method= RequestMethod.GET)
	public String indexSearch(Model model, SearchVO searchVO, @RequestParam(value="nowpage", required = false, defaultValue="1") int nowpage, HttpServletRequest request) {
		
		int total = homeService.selectProductTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 10);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<ProductVO> isvo = homeService.selectIndexSearch(searchVO); 
		
		return "user/menu/index_search";
	}
	
	
	/*
	 * @RequestMapping(value = "/list.do", method = RequestMethod.GET) public String
	 * newList() {
	 * 
	 * return "user/menu/new_list"; }
	 */
}
