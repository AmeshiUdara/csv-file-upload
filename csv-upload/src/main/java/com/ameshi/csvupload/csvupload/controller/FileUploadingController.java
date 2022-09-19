package com.ameshi.csvupload.csvupload.controller;

import com.ameshi.csvupload.csvupload.service.EmployeeService;
import com.ameshi.csvupload.csvupload.service.FileUploadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/*")
public class FileUploadingController {
    @Autowired
    private FileUploadingService fileUploadingService;

//    @Autowired
//    private EmployeeService employeeService;

    @PostMapping("uploadFile")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        return fileUploadingService.fileUploading(file);
    }

//    @GetMapping("getPlaFeedList")
//    public List<PlaFeed> getPlaFeedList(@RequestParam Map<String,Object> map){
//        try{
//            return 	plaFeedService.getPlaFeedList(map);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }

//    }

}
