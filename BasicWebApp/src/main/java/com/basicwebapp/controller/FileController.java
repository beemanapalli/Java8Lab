package com.basicwebapp.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.basicwebapp.service.impl.S3StorageService;

import lombok.NonNull;

@Controller
public class FileController {
	
	private final S3StorageService s3StorageService;
	
	FileController(S3StorageService s3StorageService){
		this.s3StorageService =s3StorageService;
	}
	
	@PostMapping("/documents")
	public String handleFileUploade(@RequestParam(name="file")
	                                @NonNull MultipartFile file,
			                        RedirectAttributes redirectAttributes) {
		
		s3StorageService.loadConfig();
		s3StorageService.store(file);
		redirectAttributes.addFlashAttribute("fileUploadMessage","You successfully uploaded Documents :-> "+file.getOriginalFilename());
		//redirectAttributes.addFlashAttribute("message","You successfully uploaded Documents : "+file.getName());
		
		return "redirect:/";
	}

}
