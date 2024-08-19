package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Part;



public class FileUploadUtils {
	
	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String [] items = contentDisposition.split(",");
		
		for(String item : items) {
			System.out.println(item);
			// 속성명= 값;
			if (item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=")+2, item.length() - 1);
				
			}
		}
		return null;
	}
	
	
	//uploadPath 를 기준으로 paths 폴더들을 생성 해 주는 메소드
	// => 한 폴더에 첨부파일을 다 업로드 하면 서버 성능이 저하 되기 때문에 파일을 분산시켜 주는 것
	public static void makeDir(String uploadPath, String ... paths) {
		
		int lastIndex = paths.length - 1;
		//마지막 폴더가 이미 존제하면 폴더를 만들 필요가 없음
		if (new File(uploadPath + paths[lastIndex]).exists()) {
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if (!dir.exists()) {
				dir.mkdir();
			}
		}
	}
	
	
	//uploadPath를 기준으로 연/월/일 폴더로 나누어서 경로를 반환하는 메소드
	public static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		// 2024
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		// 2024\\08
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		// 2024\\08\\19 
		String dayPath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, dayPath);
		
		
		
		return dayPath;
	}
	
	//첨부파일을 uploadPath에 업로드 하는 메소드
	public static String upload(String uploadPath, Part file) {
		// 첨부파일명을 가져옴
		String fileName = getFileName(file);
		//uuid를 생성, 8-4-4-4-12_파일명
		UUID uuid = UUID.randomUUID();
		String filePath = calculatePath(uploadPath) + File.separator + uuid + "_" + fileName;
		
		
		
		
		try(InputStream is = file.getInputStream();
			OutputStream os = new FileOutputStream(uploadPath + filePath)) {
			
			byte [] buffer = new byte[1024 * 4];
			int readCount = 0;
			while((readCount = is.read(buffer)) != -1) {
				os.write(buffer, 0 , readCount);
			}
			
			
			// \\ 를 / 로 바꾼 파일명으로 수정
			return filePath.replace(File.separatorChar, '/');
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
		
		

	}

}
