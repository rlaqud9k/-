package com.board.test;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, Model model, @ModelAttribute BoardVo model1) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		double pagenum = (double) boardmapper.getContent2().size() / 20;
		model.addAttribute("pagenum", pagenum);
		model.addAttribute("serverTime", formattedDate);
		List<BoardVo> list = boardmapper.getContent2();
		int limit = 20;
		int offset = list.size() - 20;
		if (offset < 0) {
			offset = 0;
		}
		model1.setOffset(offset);
		model1.setLimit(limit);
		List<BoardVo> list1 = boardmapper.Paging(model1);
		Collections.reverse(list1);
		model.addAttribute("listt", list1);
		return "home";
	}

	@RequestMapping(value = "/LoginHome", method = RequestMethod.GET)
	public String homelogin(HttpSession session, Locale locale, Model model, @ModelAttribute BoardVo model1) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		double pagenum = (double) boardmapper.getContent2().size() / 20;
		model.addAttribute("pagenum", pagenum);
		model.addAttribute("serverTime", formattedDate);
		List<BoardVo> list = boardmapper.getContent2();
		int limit = 20;
		int offset = list.size() - 20;
		if (offset < 0) {
			offset = 0;
		}
		model1.setOffset(offset);
		model1.setLimit(limit);
		List<BoardVo> list1 = boardmapper.Paging(model1);
		Collections.reverse(list1);
		model.addAttribute("listt", list1);
		return "Loginhome";
	}

}
