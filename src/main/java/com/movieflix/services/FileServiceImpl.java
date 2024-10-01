package com.movieflix.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService{

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        // get name of the file
        String filename = file.getOriginalFilename();

        // get the file path
        String filepath = path + File.separator + filename;

        // create a file object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        // copy the file or upload file to the path
        Files.copy(file.getInputStream(), Paths.get(filepath), StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws FileNotFoundException {
        String filePath = path + File.separator + filename;
        return new FileInputStream((filePath));
    }
}
