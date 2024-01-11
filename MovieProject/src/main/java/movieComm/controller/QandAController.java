package movieComm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import movieComm.dto.QandADto;
import movieComm.service.QandAService;

@Controller
public class QandAController {

	@Autowired
    private QandAService Qa;
	
    @RequestMapping("QandA")
    public String QandA() {
        return "QandA/QandA";
    }
	
    @RequestMapping(value="/QandAList", method=RequestMethod.GET)
    @ResponseBody
    public List<QandADto> boardList(){
        return Qa.getQandA();
    }
    
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write() {
        return "write";
    }
	
    @RequestMapping(value="/writeAction", method=RequestMethod.POST)
    public String writeAction(
            HttpServletRequest req,
            @RequestParam("title")String qaTitle, 
            @RequestParam("userName")String userName,
            @RequestParam("requestDate")String requestDate,
            @RequestParam("content")String content) throws IllegalStateException, IOException {
        Qa.addQandA(new QandADto(0, qaTitle, userName, requestDate, content));
        return "QandA";
    }
    
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public String view() {
        return "view";
    }
	
    @RequestMapping(value="/boardView", method=RequestMethod.GET)
    @ResponseBody
    public QandADto QandAList(@RequestParam("qaID")int qaID){
        return Qa.getQandAOne(qaID);
    }
}
