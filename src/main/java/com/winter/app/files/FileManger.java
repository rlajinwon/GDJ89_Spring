package com.winter.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.users.UserFileDTO;

@Component
public class FileManger {
	
	public String fileSave(String path,MultipartFile profile) throws Exception {
		
		
	File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2.어떤 파일을 저장??
		// 1) 시간
//		Calendar ca = Calendar.getInstance();
//		long mil = ca.getTimeInMillis(); //1234567
//		
//		String f = profile.getOriginalFilename();
//		f = f.substring(f.lastIndexOf("."));
//		System.out.println(f);
//		f = mil + f;
//		
		// 2) 객체 사용 
		String f = UUID.randomUUID().toString();
		
		f = f + "_" + profile.getOriginalFilename();
		
		
		// 3. HDD에 저장 
		file = new File(file,f);
//		profile.transferTo(file);
		
		//2) FileCopyUtils 
		FileCopyUtils.copy(profile.getBytes(), file);
		
		return f;
		
	}

}
