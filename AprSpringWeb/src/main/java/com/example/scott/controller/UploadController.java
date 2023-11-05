package com.example.scott.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.FileinfoDto;
import com.example.service.FileinfoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

	@Autowired
	FileinfoService service;

	@GetMapping("/filedownload/{fileid}")
	public void fileDownload(@PathVariable("fileid") int id, HttpServletResponse response, HttpServletRequest request) throws IOException {

		FileinfoDto dto = service.fileOne(id);
		String path = null;
		path = request.getServletContext().getRealPath("/mainImg");
		File file = new File(path, dto.getPath());

		String fileName = new String(dto.getName().getBytes("utf-8"), "iso-8859-1");

		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");// 다운로드 받을 파일명 지정

		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = response.getOutputStream();

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		out.flush();
	}

	@GetMapping("/list")
	public String list(Model m) {
		List<FileinfoDto> fList = service.fileList();
		m.addAttribute("fList", fList);
		return "file/list";
	}

	@GetMapping("/upload")
	public String form() {
		return "file/fileform";
	}

	@PostMapping("/upload")
	public String submit(String description, MultipartFile file, Model m , HttpServletRequest request) {
		if (!file.getOriginalFilename().equals("")) {
			String fileName = upload(file, request);

			FileinfoDto dto = new FileinfoDto();
			dto.setName(file.getOriginalFilename());
			dto.setPath(fileName);
			dto.setFilesize(file.getSize());
			dto.setDescription(description);

			service.insertFile(dto);

			m.addAttribute("dto", dto);
		}
		return "file/result";
	}

	private String upload(MultipartFile file, HttpServletRequest request) {
		String origName = file.getOriginalFilename();
		int index = origName.lastIndexOf(".");
		String ext = origName.substring(index + 1);// 파일 확장자 저장

		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;

		try {
			String path = request.getServletContext().getRealPath("/mainImg");
			File f = new File(path, fileName);
			file.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	
	@GetMapping("/delete/{fileid}")
	private String delete(@PathVariable("fileid") int fileid, Model m, HttpServletRequest request) {
	    FileinfoDto dto = service.fileOne(fileid);
	    if (dto != null) {
	        String path = request.getSession().getServletContext().getRealPath("/mainImg");
	        File file = new File(path, dto.getPath());
	        if (file.exists()) {
	            if (file.delete()) {
	                int result = service.deleteFile(dto);
	                if (result > 0) {
	                    // 파일 삭제 및 DB에서 파일 정보 삭제 성공
	                	System.out.printf("message", "파일이 삭제되었습니다.");
	                } else {
	                    // DB에서 파일 정보 삭제 실패
	                	System.out.printf("error", "파일 삭제에 실패하였습니다.");
	                }
	            } else {
	                // 파일 삭제 실패
	                System.out.printf("\n error", "파일 삭제에 실패하였습니다. \n");
	            }
	        } else {
	            // 파일이 존재하지 않음
	        	System.out.printf("error", "삭제할 파일이 존재하지 않습니다.");
	        }
	    } else {
	        // 파일 정보가 존재하지 않음
	    	System.out.printf("error", "삭제할 파일 정보가 존재하지 않습니다.");
	    }

	    // 파일 목록 페이지로 이동
	    return "redirect:/list"; 
	}

	
	
	
	
	
	
	
	
	
	
	
}
