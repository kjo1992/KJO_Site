package com.KJO.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class FileUploadUtils {
	
	// 폴더를 만드는 메서드
	private static void makeDir(String savedPath, String... paths) throws Exception{ // ...:가변배열, //폴더를 만드는 메소드
		if (!new File(savedPath).exists()) {
			System.out.println("make dir");
			File dirPath = new File (savedPath);
			dirPath.mkdirs();
		} else {
			System.out.println("dir already exists");
			return;
		}
	} //makeDir
	
	// 파일 업로드
	private static void fileUpload(String savedPath, String savedName, byte[] fileData) throws Exception {
		makeDir(savedPath);
		File target = new File(savedPath,savedName);
		FileCopyUtils.copy(fileData, target);
	}
	
	// 일자에 따른 경로계산
	public String calcPath() {
		Calendar cal = Calendar.getInstance();
		// '/yyyy'(yearPath)
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		// MONTH는 0으로 시작 '/yyyy/mm'(monthPath)
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1); 
		// 'yyyy/mm/dd'(datePath)
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE)); 
		
		return datePath;
	}// calcPath
	
	// 이미지 업로드
	public String imgUpload(String fileType, byte[] fileData, String uploadPath, String LoginNum) throws Exception {
		//저장될 파일 이름 결정
		UUID uid = UUID.nameUUIDFromBytes(fileData);
		String savedName = uid.toString().replace("-","")+"."+fileType;
		
		if(uploadPath.contains("FreeBoard")) {
//			String calcPath = calcPath(uploadPath, LoginNum);
			String calcPath = calcPath();
			String savedPath = uploadPath+LoginNum+calcPath;
			
			fileUpload(savedPath, savedName, fileData);
						
			return "/img/FreeBoard/"+LoginNum+"/"+calcPath+"/"+savedName;
			
		} else if (uploadPath.contains("MyPage")) {
			String savedPath = uploadPath+LoginNum;
			fileUpload(savedPath, savedName, fileData);
			
			return "/img/MyPage/"+LoginNum+"/"+savedName;
		} else if (uploadPath.contains("Product")) {
			//Product에서는 LoginNum이 ProductName으로 대체
			String savedPath = uploadPath+LoginNum;
			fileUpload(savedPath, savedName, fileData);
			return "/img/Product/"+LoginNum+"/"+savedName;
		}
		return null;
	}
}
