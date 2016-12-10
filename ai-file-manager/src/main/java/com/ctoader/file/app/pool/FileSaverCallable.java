package com.ctoader.file.app.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

public class FileSaverCallable implements Callable<Void> {

    private String filePath;
    private InputStream inputStream;

    private static final Logger LOG = LoggerFactory.getLogger(FileSaverCallable.class);

    public FileSaverCallable(String filePath, InputStream inputStream) {
        this.filePath = filePath;
        this.inputStream = inputStream;
    }

    @Override
    public Void call() throws Exception {
        LOG.info("Started saving file {}.", this.filePath);
        long start = System.currentTimeMillis();

        byte[] buffer = new byte[1024];

        try (OutputStream fos = new FileOutputStream(this.filePath)){
            while (this.inputStream.read(buffer) != -1) {
                fos.write(buffer);
            }

            fos.flush();
        }

        LOG.info("Finished saving file {} in {} ms.", this.filePath, System.currentTimeMillis() - start);
        return null;
    }
}
