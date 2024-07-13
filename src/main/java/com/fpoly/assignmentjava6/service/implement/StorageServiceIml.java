package com.fpoly.assignmentjava6.service.implement;

import com.fpoly.assignmentjava6.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class StorageServiceIml implements StorageService {
    private final Path rootLocation ;

     public StorageServiceIml(){
         this.rootLocation= Paths.get("src/main/resources/static/image");
     }
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }catch (Exception e){

        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
