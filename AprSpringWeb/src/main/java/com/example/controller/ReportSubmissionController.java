package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.commands.ReportCommand;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ReportSubmissionController {

	@RequestMapping("/report/submission")
	public String form() {
		return "report/submissionForm";
	}

	@PostMapping(value = "/report/submitReport1")
	public String submitReport1(String studentNumber, MultipartFile report) {
		printInfo(studentNumber, report);
		System.out.println(upload(report));
		return "report/submissionComplete";
	}

	// c:/upload폴더로 업로드
	private String upload(MultipartFile tempfile) {
		String fileName = makeName(tempfile.getOriginalFilename());

		File newFile = new File("c:/upload/" + fileName);

		try {
			tempfile.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return newFile.getPath();
	}

	private String makeName(String oName) {
		long currentTime = System.currentTimeMillis();
		Random random = new Random();
		int r = random.nextInt(50);// 0 ~ 49
		int index = oName.lastIndexOf(".");
		String ext = oName.substring(index + 1);

		return currentTime + "_" + r + "." + ext;
	}

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}

	@RequestMapping(value = "/report/submitReport2", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request, Model m) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		String path = request.getServletContext().getRealPath("/mainImg");
		try {
			report.transferTo(new File(path + "/" + report.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) { 
			e.printStackTrace();
		}
		m.addAttribute("path", report.getOriginalFilename());
		
		return "report/submissionComplete";
	}

	@RequestMapping(value = "/report/submitReport3", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand, HttpServletRequest request, Model m) {
		
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		try {
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			System.out.println(path);
			reportCommand.getReport().transferTo(new File(path,reportCommand.getReport().getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.addAttribute("path", reportCommand.getReport().getOriginalFilename());
		return "report/submissionComplete";
	}
}
