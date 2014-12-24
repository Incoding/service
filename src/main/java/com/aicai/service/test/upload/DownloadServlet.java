package com.aicai.service.test.upload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**实例地址
 * http://localhost:8080/service/download </br>
 * 关于请求后是hold,还是直接下载得讨论:
 * http://atell.iteye.com/blog/1172478</br>
 * http://www.verydemo.com/demo_c230_i18246.html</br>
 * ie下会有部分请求数据响应,然后服务端hold,等待浏览器点击确认或者取消.才会继续下载数据</br>
 * firefox 31,不会hold,请求后服务器直接传输数据.客户端弹出,保存或者取消确认框得时候也会传输数据的</br>
 * chrome 34 直接下载,不弹出确认和取消的弹框</br>
 * 亲测:ie 10 行为跟firefox31类似</br>
 * <p>把文件目录直接暴露给用户是很不安全的。所以要用Servlet来做，而且这样做，文件的存储方式就更丰富了，可以是从文件系统上取来的，也可以是数据库中经过计算生成的，或者从其它什么稀奇古怪的地方取来的。</p>
 *
 */
public class DownloadServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public static Logger logger=LoggerFactory.getLogger(DownloadServlet.class);
    
    private String contentType;
    private String enc="UTF-8";
    private String fileRoot;
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		contentType = "application/octet-stream";
		fileRoot = "E:\\电影\\优酷下载\\download";
	}

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("Do Get Method.");
//        String fileName=req.getParameter("fileName");
        String fileName="历史频道.狙击手.身在瞄准镜中文字幕.flv";
        String filePath=fileRoot+File.separator+fileName;
        
        File downloadFile=new File(filePath);
        if (downloadFile.exists()) {
            logger.info("File exist");
            resp.setContentType(contentType);
            Long length=downloadFile.length();
            resp.setContentLength(length.intValue());
            fileName = URLEncoder.encode(downloadFile.getName(), enc);
            resp.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            
            ServletOutputStream servletOutputStream=resp.getOutputStream();
            FileInputStream fileInputStream=new FileInputStream(downloadFile);
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            int size=0;
            byte[] b=new byte[1024];
            while ((size=bufferedInputStream.read(b))!=-1) {
                logger.info("write to output stream..");
                servletOutputStream.write(b, 0, size);
            }
            servletOutputStream.flush();
            servletOutputStream.close();
            bufferedInputStream.close();
            logger.info("done");
        }else {
            logger.info("File is not exist");
        }
    }

}