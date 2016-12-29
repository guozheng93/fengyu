//package com.fengyu.web.common.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//
//import com.alibaba.dubbo.common.json.JSON;
//import com.alibaba.dubbo.common.json.ParseException;
//import com.fengyu.common.config.Global;
//import com.fengyu.common.exception.MapperSupport.CommonExceptionHandler;
//import com.fengyu.common.exception.MapperSupport.CommonExceptionType;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.net.ftp.FTPClient;
//import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
//import org.glassfish.jersey.media.multipart.FormDataParam;
//import org.springframework.stereotype.Component;
//
//import sun.misc.BASE64Decoder;
//
//
///**
// * Created by guozheng on 2016/6/23.
// */
//@Component
//@Path("/common")
//public class UploadController {
//    /**
//     * Constants operating with images
//     */
//    private static final String ARTICLE_IMAGES_PATH = Global.getConfig("imagesPath");
//
//    /**
//     * 图片上传
//     *
//     * @param fileInputStream
//     * @param disposition
//     * @return
//     */
//    @POST
//    @Path("uploadimage/{type}")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public String uploadimage(
//                                @Context HttpServletRequest request,
//                                @PathParam("type") String type,
//                                @FormDataParam("file") java.io.InputStream fileInputStream,
//                                @FormDataParam("file") FormDataContentDisposition disposition) {
//    	String uuid = UUID.randomUUID().toString().replace("-", "");
//    	String fileName = disposition.getFileName();
//    	String fileExt = fileName.substring(fileName.lastIndexOf("."));
//    	String imageName = uuid + fileExt;
//        Date dt=new Date();
//        SimpleDateFormat matter=new SimpleDateFormat("yyyyMMdd");
//
//        String staticFile = type +"/"+ matter.format(dt)+"/"+imageName;
//
//        File file = new File(ARTICLE_IMAGES_PATH + staticFile);
//        try {
//            //使用common io的文件写入操作
//            FileUtils.copyInputStreamToFile(fileInputStream, file);
//
//        }catch (IOException ex) {
//            throw  new CommonExceptionHandler(ex, CommonExceptionType.METHODNOTFOUND,imageName);
//        }
//
//        return staticFile;
//    }
//
//    @Path("uploadimage64/{type}")
//    @POST
//    @SuppressWarnings("unchecked")
//    public String uploadimage64(String json, @PathParam("type") String type) throws IOException
//    {
//        Map<String, Object> args = null;
//        try {
//            args = JSON.parse(json, Map.class);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String base64 = (String) args.get("base64");
//        base64 = base64.replaceAll("data:image/png;base64,", "");
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] b = decoder.decodeBuffer(base64);
//        for (int i = 0; i < b.length; ++i) {
//        	if (b[i] < 0) {
//                b[i] += 256;
//            }
//        }
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        String imageName = uuid + ".png";
//        Date dt=new Date();
//        SimpleDateFormat matter=new SimpleDateFormat("yyyyMMdd");
//        String staticFile = type +"/"+ matter.format(dt)+"/"+imageName;
//        File file = new File(ARTICLE_IMAGES_PATH + staticFile);
//        FileUtils.writeByteArrayToFile(file, b);
//    	Map<String, Object> result = new HashMap<String, Object>();
//        result.put("path", staticFile);
//        return JSON.json(result);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
