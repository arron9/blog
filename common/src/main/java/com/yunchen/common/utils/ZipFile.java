package com.yunchen.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
    private static final int BUFFER = 8192;

    public static void compress(File src, String srcKey, File dest) throws IOException {
        FileOutputStream fos = new FileOutputStream(dest);
        FileLock lock;
        try {
            lock = fos.getChannel().tryLock();
        } catch (OverlappingFileLockException e) {
            fos.close();
            return;
        }

        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(fos);

            try (FileInputStream fis = new FileInputStream(src)) {
                zos.putNextEntry(new ZipEntry(srcKey));

                int count;
                byte[] data = new byte[BUFFER];
                while ((count = fis.read(data)) != -1) {
                    zos.write(data, 0, count);
                }
            }
        } finally {
            lock.release();

            if (zos == null) {
                fos.close();
            } else {
                zos.close();
            }
        }
    }
}
