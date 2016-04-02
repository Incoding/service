package com.aicai.service.test.upload;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * http://andy-ghg.iteye.com/blog/1772215 </br>
 * http://jinnianshilongnian.iteye.com/blog/2004660</br>
 * 这种测试可以经过interceptor,和exception resolver
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:applicationContext.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:dispatcher-servlet.xml")
})
public class TestTestUpload {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * 这种形式的上传可以处理,
     * 1 使用fileupload, 可以处理
     * 2 springmvc 形式上传也可以处理
     * @throws Exception
     */
    @Test
    public void testView() throws Exception {
        MockMultipartHttpServletRequestBuilder multipart = MockMvcRequestBuilders.fileUpload("/test/uploadByFileUpload");
        File file1 = new File("/Users/user/Downloads/各种视频格式/test.txt");
        FileBody fileBody = new FileBody(file1);
        HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("filenew", fileBody).build();
        ByteArrayOutputStream fileOutputStream = new ByteArrayOutputStream();
        reqEntity.writeTo(fileOutputStream);

        MediaType mediaType = MediaType.parseMediaType(reqEntity.getContentType().getValue());
        multipart.contentType(mediaType);
        multipart.content(fileOutputStream.toByteArray());
        MvcResult uploadMvcResult = mockMvc.perform(multipart).andReturn();
        String uploadResult = uploadMvcResult.getResponse().getContentAsString();
        System.out.println(uploadResult);
    }

    /**
     * 这种形式的上传,
     * 1 使用fileupload, 可以处理
     * 2 springmvc 形式上传也可以处理
     * @throws Exception
     */
    @Test
    public void testView2() throws Exception {
//        String urlTemplate = "/test/uploadmultipart";
//        String urlTemplate = "/test/testupload";
        String urlTemplate = "/test/testuploadGetPart";
//        String urlTemplate = "/test/uploadByFileUpload";
        File file1 = new File("/Users/user/Downloads/各种视频格式/test.txt");
        FileBody fileBody = new FileBody(file1);
        HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("filenew", fileBody).addPart("filenew2", fileBody).build();
        ByteArrayOutputStream fileOutputStream = new ByteArrayOutputStream();
        reqEntity.writeTo(fileOutputStream);
        byte[] content = fileOutputStream.toByteArray();
        MvcResult uploadMvcResult = mockMvc.perform(post(urlTemplate).content(content).contentType(MediaType.parseMediaType(reqEntity.getContentType().getValue()))).andReturn();
        String uploadResult = uploadMvcResult.getResponse().getContentAsString();
        System.out.println(uploadResult);
    }
}
