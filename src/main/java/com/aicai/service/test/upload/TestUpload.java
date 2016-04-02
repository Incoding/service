package com.aicai.service.test.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class TestUpload {
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 8; // 8MB
    class UploadProgressListener implements ProgressListener {
        private HttpServletRequest request;
        private DecimalFormat df = new DecimalFormat("#00.0");
        UploadProgressListener(HttpServletRequest request) {
            this.request = request;
        }
        public void update(long bytesRead, long bytesTotal, int items) {
            double percent = (double) bytesRead * 100 / (double) bytesTotal;
            request.getSession().setAttribute("UPLOAD_PERCENTAGE",df.format(percent));
        }
    }
    /**此方法上传的文件打开后会带  boundry等信息.
    http://www.cnblogs.com/goodwin/archive/2010/09/28/1837387.html
     */
    @RequestMapping(value="test/testupload")
    public void testUpload(HttpServletRequest request){
        try {
            String header = request.getHeader("Content-Type");
            // 请求头
            System.out.println(header);
            // 请求体
            ServletInputStream inputStream = request.getInputStream();
            String path = TestUpload.class.getResource("").getPath()+"withBoundry.txt";
            File file = new File(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] b = new byte[1024];
            while(inputStream.read(b) > 0){
                fileOutputStream.write(b);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * 这个getPart()是servlet3.0新增的方法 (为了通用性,暂时不用)
     * http://my.oschina.net/Barudisshu/blog/150026
     * @param request
     */
    @RequestMapping(value="test/testuploadGetPart")
    @Deprecated
    public void testUploadGetPart(HttpServletRequest request){
        try {
            Part filenew = request.getPart("filenew");
            System.out.println(filenew.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("test/uploadmultipart")
	public void upload(@RequestParam("file1")MultipartFile file,@RequestParam("file2")MultipartFile file2,@RequestParam("file3")MultipartFile file3) {
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file3.getName());
		return;
	}

    /**  fileupload实现上传 (好)
     * http://blog.csdn.net/hzc543806053/article/details/7524491
     * @param request
     */
    @RequestMapping("test/uploadByFileUpload")
    public void uploadByFileUpload(HttpServletRequest request) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD); // 磁盘缓存
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setProgressListener(new UploadProgressListener(request));
        List<FileItem> formItems = null;
        try {
            formItems = upload.parseRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        if (formItems != null && formItems.size() > 0) {
            for (FileItem item : formItems) {
                System.out.println(item.getName());

//                try {
//                    File storeFile = new File("~/xxx");
//                    item.write(storeFile);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


            }

        }
        return;
    }


}
