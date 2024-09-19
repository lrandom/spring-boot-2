package prepedu.com.springbootdemo2;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller("UploadFileController")
public class UploadFileController {

    @Value("${UPLOAD_DIR}")
    String UPLOAD_FOLDER;

    @GetMapping("/upload-form")
    public String uploadForm() {
        return "fe/upload-form";
    }

    @PostMapping("/upload-form")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            byte[] byteFile = file.getBytes();
            //get current month
            String month = new SimpleDateFormat("MM").format(new Date());
            //get current year
            String year = new SimpleDateFormat("yyyy").format(new Date());
            //create folder name
            String folderName = month + "-" + year;
            //check if folder exists
            String uploadFolder = UPLOAD_FOLDER + folderName;
            if (!Files.exists(Path.of(uploadFolder))) {
                Files.createDirectory(Path.of(uploadFolder));
            }
            String timeStamps = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String extension = file.getOriginalFilename().split("\\.")[1];

            Files.write(Path.of(uploadFolder + "/" + timeStamps + "." + extension), byteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fe/upload-form";
    }


    @GetMapping("/serve-file")
    public FileOutputStream serveFile(HttpServletResponse response) {
        File file = new File(UPLOAD_FOLDER + "451320821_386657711100395_3929528726125613421_n.jpg");
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        try {
            Files.copy(file.toPath(), response.getOutputStream());
            response.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
