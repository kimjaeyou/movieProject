package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {

	@GetMapping("/download")
	public void fileDownload(HttpServletResponse response) throws IOException {

		File file = new File("c:\\upload\\1681715514817_35.png");

		String fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");

		response.setContentType("application/octet-stream; charset=utf-8");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");// 다운로드 받을 파일명 지정

		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = response.getOutputStream();

		try (FileInputStream fis = new FileInputStream(file);){
			FileCopyUtils.copy(fis, out);
		}
		out.flush();
	}

}





