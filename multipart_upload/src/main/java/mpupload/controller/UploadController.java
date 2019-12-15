package mpupload.controller;

import lombok.RequiredArgsConstructor;
import mpupload.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller("upload")
@RequiredArgsConstructor
public class UploadController {

    private StorageService storageService;

    public UploadController(StorageService uploadService) {
        this.storageService = uploadService;
    }

    @PostMapping("/one")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        storageService.storeFile(file);
    }

}
