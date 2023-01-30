package de.bund.bfr.kidaeditorbackend.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
public class ZipHelper {

    public static File zipDirectory(File directoryToZip) throws IOException {
        String zipPath = directoryToZip.getPath() + ".zip";
        File zipFile = new File(zipPath);
        if (zipFile.exists()) {
            log.info("Zipfile already exists. Deleting old file.");
            zipFile.delete();
        }
        log.info("Creating zip file: " + zipFile.getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(zipPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        zipFile(directoryToZip, directoryToZip.getName(), zipOutputStream);
        zipOutputStream.close();
        fileOutputStream.close();
        log.info("Zip creation complete at: " + zipFile.getAbsolutePath());
        return new File(zipPath);
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
