package com.ctoader.file.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by crist on 11/27/2016.
 */
@Service
class FileServiceImpl implements FileService {

    @Autowired
    private FileManager fileManager;

    private static final String USER = "ctoader"; // for now keep this hardcoded.
    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    public String uploadFile(String fileName, InputStream inputStream) {
        if (!this.fileManager.isAvailable()) {
            LOG.warn("File manager is not available, cannot process file.");
            return null;
        }

        return this.fileManager.processUploadFileRequest(USER, fileName, inputStream);
    }

    public InputStream downloadFile(String fileId) throws IOException {
        if (!this.fileManager.isAvailable()) {
            LOG.warn("File manager is not available, cannot process file.");
            return null;
        }

        return this.fileManager.processDownloadFileRequest(USER, fileId);
    }
}
