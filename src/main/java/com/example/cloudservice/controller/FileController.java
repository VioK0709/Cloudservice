package com.example.cloudservice.controller;

import com.example.cloudservice.model.dto.FileResponse;
import com.example.cloudservice.model.dto.NewFilenameRequest;
import com.example.cloudservice.model.entity.FileEntity;
import com.example.cloudservice.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.example.cloudservice.exceptions.MessageConstant.FILE;
import static com.example.cloudservice.exceptions.MessageConstant.LIST;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping(FILE)
    public ResponseEntity<String> uploadFile(@RequestHeader(value = "auth-token") String authToken,
                                             @RequestParam(value = "file") MultipartFile file) {
        String result = fileService.uploadFile(authToken, file);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping(FILE)
    public ResponseEntity<String> deleteFile(@RequestHeader(value = "auth-token") String authToken,
                                             @RequestParam(value = "filename") String filename) {
        String result = fileService.deleteFile(authToken, filename);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(FILE)
    public ResponseEntity<FileEntity> getFile(@RequestHeader("auth-token") String authToken,
                                              @RequestParam("filename") String filename) {
        return fileService.getFile(authToken, filename);
    }


    @PutMapping(FILE)
    public ResponseEntity<String> renameFile(@RequestHeader("auth-token") String authToken,
                                             @RequestParam String filename,
                                             @RequestBody NewFilenameRequest newFilename) {
        String result = fileService.renameFile(authToken, filename, newFilename);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping(LIST)
    public List<FileResponse> getAllFiles(@RequestHeader("auth-token") String authToken,
                                          @RequestParam("limit") Integer limit) {
        return fileService.getAllFiles(authToken, limit);
    }
}