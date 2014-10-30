package com.aicai.service.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestUpload {

    @RequestMapping(value="test/testupload")
    public void testUpload(HttpServletRequest request){
        try {
            String header = request.getHeader("Content-Type");
            // 请求头
            System.out.println(header);
            // 请求体
            ServletInputStream inputStream = request.getInputStream();
            String path = TestUpload.class.getResource("").getPath()+"text555.txt";
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] b = new byte[1024];
            while(inputStream.read(b) > 0){
                fileOutputStream.write(b);
            }
            inputStream.close();
            fileOutputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
