package controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("upload")
public class UploadController {

    @PostMapping("/one")
    public void uploadFile() {

    }

}
