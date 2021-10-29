package com.depromeet.dgdg.controller.upload;

import com.depromeet.dgdg.controller.dto.response.BaseResponse;
import com.depromeet.dgdg.service.upload.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class S3ImageController {

    private final S3Service s3Service;

    @PostMapping("/api/v1/upload/images")
    public BaseResponse<String> upload(@RequestPart(value = "images") MultipartFile images) throws IOException {
        return BaseResponse.success(s3Service.upload(images));
    }

    @GetMapping("/api/v1/download/images")
    public ResponseEntity<byte[]> download(@RequestParam String storedFileName) throws IOException {
        return s3Service.getObject("storedFileName");
    }

}
