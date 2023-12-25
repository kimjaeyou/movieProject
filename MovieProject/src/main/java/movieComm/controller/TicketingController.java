package movieComm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TicketingController {
	@RequestMapping({"ticketing"})
	public String Ticketing(Model m,HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		m.addAttribute("userid",userid);
		
		
		return"";
	}
}
