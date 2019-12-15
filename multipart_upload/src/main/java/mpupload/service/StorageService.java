package mpupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class StorageService {

    private static final String STORAGE_PATH = "../multipart_upload/src/main/resources/storage";

    public void storeFile(MultipartFile file) throws FileNotFoundException {
        String fName = file.getName();
        File localFile = new File(STORAGE_PATH + "/" + fName);

        FileOutputStream fis = new FileOutputStream(localFile);

    }

}
