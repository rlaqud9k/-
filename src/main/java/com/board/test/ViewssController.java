package com.board.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myapp.mapper.BoardMapper;
import com.myapp.vo.BoardVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ViewssController {

	@Autowired
	private BoardMapper boardmapper;
	
	@RequestMapping(value = "/viewss/delete", method = RequestMethod.GET)
	public String Memberdelete() {
		return "/viewss/delete";
	}
	@RequestMapping(value = "/viewss/modi", method = RequestMethod.GET)
	public String Membermodi() {
		
//		String[] a = button.split(",");
//		int no = Integer.valueOf(a[1]);

//		System.out.println(list);
//	
		return "/viewss/modi";
	}
	@RequestMapping(value = "/viewss/writer", method = RequestMethod.GET)
	public String Memberwriter() {
		return "/viewss/writer";
	}
	@RequestMapping(value = "/viewss/look", method = RequestMethod.GET)
	public String Memberlook() {
		return "/viewss/look";
	}
	//수정 삭제구분
	@RequestMapping(value = "/viewss/md", method = RequestMethod.POST)
	public String Membermd(@RequestParam(value="id", defaultValue="i") String id,HttpSession session,@RequestParam("button") String button, Model model) {
		String sid = (String) session.getAttribute("id");
		System.out.println("id"+sid);
		if(button.equals("home")) {
			return "redirect:/LoginHome";
		}
		if(id.equals(sid)) {
		if(button.equals("modi,")||button.equals("delete,")) {
			List<BoardVo> list = boardmapper.getContent2();
			button = button + list.get(0).getNo();
		}
		String[] a = button.split(",");
		int no = Integer.valueOf(a[1]);
		model.addAttribute("no", no);
		if(a[0].equals("delete")) {
			return "/viewss/delete";
		}
		List<BoardVo> list = boardmapper.lookdo2(no);
		model.addAttribute("content", list.get(0).getContent());
		model.addAttribute("title", list.get(0).getTitle());
		
		return "/viewss/modi";
		}else {
			if(sid==null) {
				return "redirect:/";
			}
		return "redirect:/LoginHome";
		}
	}
	//쓰기 ->읽기
	@RequestMapping(value = "/viewss/lookdo1", method = RequestMethod.GET)
	public String Memberlookdo1(HttpSession session, Model model) {
		BoardVo board = (BoardVo)session.getAttribute("boardvo");
		session.removeAttribute("boardvo");
		List<BoardVo> list = boardmapper.getContent(board);
		int i = list.size()-1;
		System.out.println(list.get(i));
		model.addAttribute("title",list.get(i).getTitle());
		model.addAttribute("content",list.get(i).getContent());
		model.addAttribute("id",list.get(i).getId());
		System.out.println(list.get(i).getId());
		return "/viewss/look";
	}
	//페이징에서 넘어오기
	@RequestMapping(value = "/viewss/lookdo2", method = RequestMethod.GET)
	public String Memberlookdo2(@RequestParam("no") int no,@RequestParam("id") String id, Model model) {
		List<BoardVo> list = boardmapper.lookdo2(no);
		model.addAttribute("title",list.get(0).getTitle());
		model.addAttribute("content",list.get(0).getContent());
//		model.addAttribute("id", list.get(0).getId());
		model.addAttribute("id", id);
		model.addAttribute("no", no);
		boardmapper.count(no);
		return "/viewss/look";
	}
	
	@RequestMapping(value = "/viewss/ud", method = RequestMethod.POST)
	public String Memberud(@ModelAttribute BoardVo board, @RequestParam("button") String button, Model model) {
		String[] a = button.split(",");
		int no = Integer.valueOf(a[1]);
		String yon = a[0];
		board.setNo(no);
		if(yon.equals("yes")) {
			boardmapper.updateboard(board);
		}
		
		return "redirect:/LoginHome";
	}
	
	//쓰기
	@RequestMapping(value = "/viewss/writerdo", method = RequestMethod.POST)
	public String Memberwriterdo(@RequestParam("button") String button, @ModelAttribute BoardVo board,HttpSession session) {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
		String id = (String) session.getAttribute("id");
		session.setAttribute("boardvo", board);
		board.setId(id);
		board.setDate(String.valueOf(sd.format(date)));
		if(button.equals("yes")) {
		 boardmapper.insertcontent(board);
		 return "redirect:/LoginHome";
		}else {		
				return "redirect:/LoginHome";
			
		}
		
		
	}
	//삭제
	@RequestMapping(value = "/viewss/deletedo", method = RequestMethod.POST)
	public String Memberdeletedo(@RequestParam("button") String button) {
		String[] a = button.split(",");
		if(a[0].equals("yes")) {
			boardmapper.deleteboard(Integer.valueOf(a[1]));
			return "redirect:/LoginHome";
		}
		return "redirect:/LoginHome";
	}
	
}
