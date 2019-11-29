package com.cos.crud.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@Value("${file.path}")
	private String resourcePath;
	
	@PostMapping("/file/upload")
	public @ResponseBody String imageUpload(@RequestParam("file") MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String uuidFileName = uuid+"_"+file.getOriginalFilename();
		
		Path filePath = Paths.get(resourcePath+uuidFileName);
		System.out.println("filePath : "+filePath);
		try {
			Files.write(filePath,file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath.toString();
	}
}
