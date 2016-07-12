package net.frog.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;
 
@Component("fileUtil")
public class FileUtil {
	 private static final String filePath = "C:\\file\\";
	 
		public  List<Map<String,Object>>  parseInsertFileInfo(MultipartFile multipartfile){
		
			
			 
			Random rnd =new Random();
			StringBuffer buf =new StringBuffer();
			 /*
			  * ·£´ý ¹®ÀÚ¿­
			  */
			for(int i=0;i<20;i++){
			    if(rnd.nextBoolean()){
			        buf.append((char)((int)(rnd.nextInt(26))+97));
			    }else{
			        buf.append((rnd.nextInt(10))); 
			    }
			}
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	        Map<String, Object> listMap = null; 
	        //·£´ýÈ­
	        
	        String originalFileName = null;
	        String originalFileExtension = null;
	        String storedFileName = null;

	        File file= new File(filePath);//make dir
	        if(file.exists() == false){
	            file.mkdirs();
	        }
	        
	        if(multipartfile.isEmpty()==false){
	        	originalFileName = multipartfile.getOriginalFilename();
	        	originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
	        	storedFileName =  buf+originalFileExtension;
	        	file = new File(filePath+storedFileName);
	        	
	        	try {
					multipartfile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	 listMap = new HashMap<String,Object>();

	                listMap.put("ORIGINAL_FILE_NAME", originalFileName);
	                listMap.put("STORED_FILE_NAME", storedFileName);
	                listMap.put("FILE_SIZE", multipartfile.getSize());
	                list.add(listMap);
	        	        	
	        }
	        
	        
	        return list;
		}
}

/*
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
 
@Component("fileUtils")

    private static final String filePath = "C:\\dev\\file\\";
    

    public List<Map<String,Object>> parseInsertFileInfo(Map<String,Object> map, HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
         
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;
         
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 
         
        String boardIdx = (String)map.get("IDX");
         
        File file = new File(filePath);
        if(file.exists() == false){
            file.mkdirs();
        }
         
        while(iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = CommonUtils.getRandomString() + originalFileExtension;
                 
                file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);
                 
                listMap = new HashMap<String,Object>();
                listMap.put("BOARD_IDX", boardIdx);
                listMap.put("ORIGINAL_FILE_NAME", originalFileName);
                listMap.put("STORED_FILE_NAME", storedFileName);
                listMap.put("FILE_SIZE", multipartFile.getSize());
                list.add(listMap);
            }
        }
        return list;
    }
}

*/