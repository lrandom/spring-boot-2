package prepedu.com.springbootdemo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@Controller("UploadFileController")
public class UploadFileController {

    @GetMapping("/upload-form")
    public String uploadForm() {
        return "fe/upload-form";
    }

    @PostMapping("/upload-form")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            byte[] byteFile = file.getBytes();
            Files.write(Path.of("/Users/luan_prep_vn/Desktop/spring-uploads/" + file.getOriginalFilename().trim()), byteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fe/upload-form";
    }
}
