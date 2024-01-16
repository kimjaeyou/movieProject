package movieComm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.mail.Service;
import movieComm.dto.QADto;
import movieComm.service.QAService;

@Controller
public class QAController {

	@Autowired
	QAService Qa;
	
	@GetMapping("/QandA/write")
	public String write() {
		return "QandA/write";
	}
	
	@PostMapping("/QandA/write")
	public String write(QADto dto) {
		Qa.insert(dto);
		return "redirect:/QandA/List";
	}
	
	@RequestMapping("/QandA/List")
	public String List(@RequestParam(name = "P", defaultValue = "1") int page, Model m) {
		int total = Qa.total();
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
		return "QandA/List";
	}
	
	@GetMapping("QandA/content/{no}")
	public String content(@PathVariable int no, Model m) {
		QADto dto = Qa.QAContent(no);
		m.addAttribute("dto", dto);
		return "QandA/content";
	}
}
