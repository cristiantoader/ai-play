package com.ctoader.file.app.services;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by crist on 11/27/2016.
 */
public interface FileService {
    String uploadFile(String originalFilename, InputStream inputStream);
    InputStream downloadFile(String fileId) throws IOException;
}
