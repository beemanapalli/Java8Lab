package com.basicwebapp.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface StorageServce {
	
	public boolean store(MultipartFile file);
	
	
	public void loadConfig();

}
