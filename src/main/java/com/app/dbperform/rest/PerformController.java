package com.app.dbperform.rest;

import com.app.dbperform.service.LoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@RestController
public class PerformController {
    private final LoaderService loaderService;

    @Autowired
    public PerformController(LoaderService loaderService) {
        this.loaderService = loaderService;
    }

    @RequestMapping(value="/load", method = RequestMethod.POST)
    ResponseEntity<String> loadFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(loaderService.loadFile(file));
    }

//    @Bean
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver
//                = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(5242880);
//        return multipartResolver;
//    }
}
