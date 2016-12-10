package com.ctoader.file.app.services;

import com.ctoader.file.app.pool.FileSaverCallable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;

/**
 * Created by crist on 11/27/2016.
 */
@Service
class FileManagerImpl implements FileManager {

    @Value("${ai.file-manager.default-file-root-path}")
    private String rootFilePath;

    @Autowired
    private ExecutorService executorService;

    private static final Logger LOG = LoggerFactory.getLogger(FileManagerImpl.class);

    public boolean isAvailable() {
        return Files.exists(Paths.get(rootFilePath)) && executorService != null;
    }

    public String processUploadFileRequest(String user, String fileName, InputStream inputStream) {
        LOG.info("Processing user {} file {} upload.", user, fileName);

        // make user folder is created.
        File parent = new File(this.rootFilePath + File.separator + user);
        if (!parent.exists()) parent.mkdirs();

        String filePath = makeFilePathFromParams(user, fileName);
        this.executorService.submit(new FileSaverCallable(filePath, inputStream));
        return filePath;
    }

    public InputStream processDownloadFileRequest(String user, String fileName) throws IOException {
        String filePathString = makeFilePathFromParams(user, fileName);
        Path filePath = Paths.get(filePathString);
        if (!Files.exists(filePath)) {
            LOG.error("Generated file path {} does not exist.", filePath);
            throw new RuntimeException("File does not exist.");
        }

        return Files.newInputStream(filePath);
    }

    private String makeFilePathFromParams(String user, String fileName) {
        return this.rootFilePath + File.separator + user + File.separator + fileName;
    }
}
