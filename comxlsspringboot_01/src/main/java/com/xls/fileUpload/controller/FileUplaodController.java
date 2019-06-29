package com.xls.fileUpload.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传处理类
 *
 */
@RestController
public class FileUplaodController{

    @RequestMapping("/fileUpload")
    public Map<String,Object> proceedFileUpload(MultipartFile uploadFile) throws Exception {
        //处理上传来的数据
        System.out.println("上传过来的文件是==========="+uploadFile.getOriginalFilename());

        //保存到一个路径
        uploadFile.transferTo(new File("f:/"+uploadFile.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("result","ok");
        return  map;

    }

}
