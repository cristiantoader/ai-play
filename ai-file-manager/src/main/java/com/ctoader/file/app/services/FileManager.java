package com.ctoader.file.app.services;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by crist on 11/27/2016.
 */
public interface FileManager {
    boolean isAvailable();
    String processUploadFileRequest(String user, String fileName, InputStream inputStream);
    InputStream processDownloadFileRequest(String user, String fileId) throws IOException;
}
