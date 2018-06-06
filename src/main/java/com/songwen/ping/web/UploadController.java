package com.songwen.ping.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/5/10.
 * 图片上传
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){

        return "upload";
    }

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request){
        try {
            //上传目录
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";

            //目录不存在，创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }

            //上传文件名
            String  fileName= file.getOriginalFilename();

            //服务器保存的文件对象
            File serverFile = new File(uploadDir + fileName);

            //将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);

        } catch (Exception e) {
            //打印错误椎栈信息
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }*/

    /**
     * 上传图片
     * 自定义文件名(UUID格式)
     * @param file
     * @param request
     * @return
     */
  /*  @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request){
        try {
            //上传目录
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";

            //目录不存在，创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }

            //文件名称
            String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //上传文件名
            String fileName = UUID.randomUUID()+suffix;
            //服务器保存的文件对象
            File serverFile = new File(uploadDir + fileName);

            //将上传的文件写入到服务器端文件内
            file.transferTo(serverFile);

        } catch (Exception e) {
            //打印错误椎栈信息
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }*/

    /**
     * 上传图片
     * 自定义文件名(时间格式)
     * @param file
     * @param request
     * @return
     */
   /* @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request){
        try {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            String path = "/upload/images/" + ymd + "/";


            //上传目录
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+ path;

            //目录不存在，创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }

            String picNameOld = file.getOriginalFilename();
            String picType = picNameOld.substring(picNameOld.lastIndexOf("."),picNameOld.length());
            String picNameNew = UUID.randomUUID() + picType;

            //最终文件名
            File realFile=new File(dir + File.separator + picNameNew);
            FileUtils.copyInputStreamToFile(file.getInputStream(), realFile);


            //文件名称
            //String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //上传文件名
           // String fileName = UUID.randomUUID()+suffix;
            //服务器保存的文件对象
           // File serverFile = new File(uploadDir + fileName);

            //将上传的文件写入到服务器端文件内
           // file.transferTo(serverFile);

        } catch (Exception e) {
            //打印错误椎栈信息
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }
*/

    /**
     *
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file  上传对象
     * @throws Exception
     */

    private void executeUpload(String uploadDir,MultipartFile file) throws Exception
    {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

    /**
     *上传多个文件
     * @param request   请求对象
     * @param file 上传文件集合
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public  String uploads(HttpServletRequest request,MultipartFile[] file)
    {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i =0;i<file.length;i++) {
                if(file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }




}
