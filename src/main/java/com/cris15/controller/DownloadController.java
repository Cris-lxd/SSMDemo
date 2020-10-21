package com.cris15.controller;/*
 *  create by 20224
 *  2020/10/19
 * */

import com.alibaba.fastjson.JSONObject;
import com.cris15.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/")
public class DownloadController {
    @Autowired
    private TestMapper testMapper;

    @RequestMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        File file  = new File("D:\\desktop\\狴犴.png");
        String filename = file.getName();
        FileInputStream fis = new FileInputStream(file);
        downloadByInputstream(response,fis,filename);
        fis.close();
    }

    @RequestMapping("download2")
    @ResponseBody
    public Object download2(HttpServletResponse response,Long id) throws IOException {
        String s = testMapper.selectById(id);
        if(s.equals("") || s == null){
            return JSONObject.toJSON("数据库没有该条记录，请联系管理员") ;
        }
        File file = new File("D:/desktop/"+s);
        response.setCharacterEncoding("UTF-8");
        if(!file.exists()){
            return JSONObject.toJSON("服务器没有该文件，或已被手动删除");
        }else{
            String filename = file.getName();
            FileInputStream fis = new FileInputStream(file);
            downloadByInputstream(response,fis,filename);
        }

        return null;
    }

    /**
     * 下载方法
     * @param response
     * @param stream
     * @param filename
     * @throws IOException
     */
    public void downloadByInputstream(HttpServletResponse response,FileInputStream stream,String filename) throws IOException {
        InputStream is = new BufferedInputStream(stream);
        byte[] bytes = new byte[is.available()];
        /*is.read(bytes);
        is.close();*/
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"),"ISO8859-1"));
        response.setContentType("application/octet-stream");
        OutputStream os = response.getOutputStream();

        int lengthOfRead = 0;
        int lengthOfNum = 0;
        while((lengthOfRead = is.read(bytes))>0){
            lengthOfNum += lengthOfRead;
            os.write(bytes,0,lengthOfRead);
        }
        //os.write(bytes);
        is.close();
        os.flush();
        os.close();
    }
}
