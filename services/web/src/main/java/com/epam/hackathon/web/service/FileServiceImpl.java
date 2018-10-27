package com.epam.hackathon.web.service;

import com.epam.hackathon.web.request.ImageType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
class FileServiceImpl implements FileService {

    @Override
    public void save(final MultipartFile file, final ImageType imageType) {
        //TODO: not implemented
        throw new AssertionError("Not implemented");
    }
}
