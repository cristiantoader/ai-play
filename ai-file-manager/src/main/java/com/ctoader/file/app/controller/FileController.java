package com.ctoader.file.app.controller;

import com.ctoader.file.app.services.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by crist on 11/27/2016.
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("fileToUpload") MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            LOG.warn("Attempted to load empty file, not allowed.");
            return null;
        }

        return this.fileService.uploadFile(
                multipartFile.getOriginalFilename(),
                multipartFile.getInputStream());
    }

    @RequestMapping(value = "/download/{fileId}", method = RequestMethod.GET)
    public void downloadFile(@PathVariable("fileId") String fileId, HttpServletResponse httpServletResponse) {
        try {
            InputStream inputStream = this.fileService.downloadFile(fileId);
            IOUtils.copyLarge(inputStream, httpServletResponse.getOutputStream());
            httpServletResponse.flushBuffer();

        } catch (Exception e) {
            LOG.error("Failed downloading file", e);
            throw new RuntimeException("Could not download file.");
        }
    }
}
