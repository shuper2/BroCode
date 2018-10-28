package com.epam.hackathon.web.service;

import com.epam.hackathon.web.request.ImageType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
class LocalFilesystemFileService implements FileService {

    private final String localStorageDir;

    LocalFilesystemFileService(@Value("${storage.local.dir}") final String localStorageDir) {
        this.localStorageDir = localStorageDir;
    }

    @Override
    public String save(final MultipartFile file, final ImageType imageType) throws IOException {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String filename = System.currentTimeMillis() + "." + fileExtension;
        Files.write(Paths.get(localStorageDir + System.getProperty("file.separator") + imageType).resolve(filename), file.getBytes());
        return filename;
    }
}
