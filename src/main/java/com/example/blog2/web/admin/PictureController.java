package com.example.blog2.web.admin;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.blog2.po.Result;
import com.example.blog2.po.StatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author hikari
 * @version 1.0
 * @date 2021/7/5 21:14
 */
@RestController
@CrossOrigin
public class PictureController {
    @PostMapping(value = "/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new Result(true, StatusCode.ERROR,"上传图片为空",null);
        }
        JSONObject postData = new JSONObject();
        String fileName = file.getOriginalFilename();//上传的文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取后缀
        fileName = UUID.randomUUID() + suffixName;//生成唯一文件名
        try {
            byte[] fileBytes = file.getBytes();//转换为byte数组
            postData.put("fileName",fileName);
            postData.put("data",fileBytes);
            RestTemplate client = new RestTemplate();
            //FilePath是你服务端的项目接口路径
            JSONObject json = client.postForEntity("http://hikari.top/pic_server/upload/upImg", postData, JSONObject.class).getBody();
            System.out.println("上传成功");
            return new Result(true, StatusCode.OK,"上传图片成功",json.get("data"));
        } catch (IOException | JSONException e) {
            System.out.println(e.toString());
        }
        System.out.println("上传失败");
        return new Result(true, StatusCode.ERROR,"上传图片失败",null);
    }
}
