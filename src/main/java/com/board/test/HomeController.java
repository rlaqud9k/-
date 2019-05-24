package com.board.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.mapper.BoardMapper;
import com.myapp.vo.BoardVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardMapper boardmapper;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "no", defaultValue = "1") int no, Locale locale, Model model,
			@ModelAttribute BoardVo model1) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		double pagenum = (double) boardmapper.getContent2().size() / 20;
		model.addAttribute("pagenum", pagenum);
		model.addAttribute("serverTime", formattedDate);
		List<BoardVo> list = boardmapper.getContent2();
		
		for(int i=0; i<=list.size()-1; i++) {
			list.get(i).setFno(list.size() - i);
		}
//		System.out.println(list.get(0)+""+list.get(list.size()-1));
		List<BoardVo> listt = new ArrayList<BoardVo>();
		int s = (no - 1) * 20;
		if (no == 1) {
			s = 1;
		}
		int e = (s * 20) - 1;
		if (e >= list.size()) {
			e = list.size() - 1;
		}
		if (s==1) {
			s=0;
		}
		System.out.println(s);
		for (int i = s; i <= e; i++) {
			listt.add(list.get(i));
		}
		model.addAttribute("listt", listt);
		return "home";
	}

	@RequestMapping(value = "/LoginHome", method = RequestMethod.GET)
	public String homelogin(@RequestParam(value = "no", defaultValue = "1") int no, HttpSession session, Locale locale,
			Model model, @ModelAttribute BoardVo model1) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		double pagenum = (double) boardmapper.getContent2().size() / 20;
		model.addAttribute("pagenum", pagenum);
		model.addAttribute("serverTime", formattedDate);
		List<BoardVo> list = boardmapper.getContent2();
		for(int i=0; i<=list.size()-1; i++) {
			list.get(i).setFno(list.size() - i);
		}
		
		List<BoardVo> listt = new ArrayList<BoardVo>();
		int s = (no - 1) * 20;
		if (no == 1) {
			s = 1;
		}
		int e = (s * 20) - 1;
		if (e >= list.size()) {
			e = list.size() - 1;
		}
		if (s==1) {
			s=0;
		}
		System.out.println(s);
		for (int i = s; i <= e; i++) {
			listt.add(list.get(i));
		}
		model.addAttribute("listt", listt);
		return "Loginhome";
	}

//	@RequestMapping(value="/page", method=RequestMethod.GET)
//	public String page(@RequestParam("no") int no,Model model, @ModelAttribute BoardVo model1) {
//		System.out.println(boardmapper.getContent2().size());
//		int limit = 20;
//		int offset = boardmapper.getContent2().size() - (20 * no);
//		if(no==1) {
//			offset=0;
//		}else {
//			offset=((no-1)*20) - 1;
//		}
//		model1.setLimit(limit);
//		model1.setOffset(offset);
//		System.out.println(limit+""+offset);
//		List<BoardVo>board = boardmapper.Paging(model1);
//		Collections.reverse(board);
//		System.out.println(board);
//		model.addAttribute("listt", board);
//		return "redirect:/";
//	}

}