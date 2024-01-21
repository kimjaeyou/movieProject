package movieComm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.mail.Service;
import jakarta.servlet.http.HttpSession;
import movieComm.dto.QADto;
import movieComm.dto.UserDto;
import movieComm.service.QAService;

@SessionAttributes("user")
@Controller
public class QAController {

	@Autowired
	QAService Qa;
	
	
	
	@ModelAttribute("user")
	public UserDto getDto() {
		return new UserDto();
	}
	
	@GetMapping("/QandA/write")
	public String write(@ModelAttribute("user")UserDto dto) {
		return "QandA/write";
	}
	
	@PostMapping("/QandA/write")
	public String write(QADto dto) {
		Qa.insert(dto);
		return "redirect:QandA";
	}
	
	@RequestMapping("QandA")
	public String List(HttpSession session, @RequestParam(name = "P", defaultValue = "1") int page, Model m) {
		int total = Qa.total();
		String userID = (String) session.getAttribute("userid");
		if(total > 0) {
			int perPage = 10;
			int startRow = (page - 1) * perPage;
			
			List<QADto> QAList = Qa.QAList(startRow);
			
			m.addAttribute("QAList", QAList);
			
			int pageNum = 10;
			int totalPages = total/perPage + (total % perPage > 0 ? 1 : 0);
			
			int begin = (page -1) / pageNum * pageNum + 1;
			int end = begin + pageNum - 1;
			if(end > totalPages) {
				end = totalPages;
			}
			m.addAttribute("begin", begin);
			m.addAttribute("end", end);
			m.addAttribute("pageNum", pageNum);
			m.addAttribute("totalPages", totalPages);
		}
		m.addAttribute("total", total);
		m.addAttribute("userID", userID);
		System.out.println(userID);
		return "QandA/List";
	}
	
	@GetMapping("QandA/content/{no}")
	public String content(@PathVariable int no, Model m) {
		QADto dto = Qa.QAContent(no);
		m.addAttribute("dto", dto);
		
		return "QandA/content";
	}
	
	@PutMapping("/QandA/update")
	public String update(QADto dto) {
		Qa.updateQA(dto);
		return "redirect:List";
	}
	
	@DeleteMapping("/QandA/delete")
	@ResponseBody
	public String delete(int no) {
		int i = Qa.deleteQA(no);
		return ""+i;
	}
	
	@GetMapping("/QandA/search")
	public String search(int searchn, String search, @RequestParam(name = "P", defaultValue = "1") int page, Model m) {
		int count = Qa.countSearch(searchn, search);
		if(count > 0) {
			int perPage = 10;
			int startRow = (page - 1) * perPage;
			
			List<QADto> QAList = Qa.QAListSearch(searchn, search, startRow);
			
			m.addAttribute("QAList", QAList);
			
			int pageNum = 5;
			int totalPages = count/perPage + (count % perPage > 0 ? 1 : 0);
			
			int begin = (page -1) / pageNum * pageNum + 1;
			int end = begin + pageNum - 1;
			if(end > totalPages) {
				end = totalPages;
			}
			m.addAttribute("begin", begin);
			m.addAttribute("end", end);
			m.addAttribute("pageNum", pageNum);
			m.addAttribute("totalPages", totalPages);
		}
		m.addAttribute("count", count);
		m.addAttribute("searchn", searchn);
		m.addAttribute("search", search);
		return "QandA/List";
	}
}
