package prepedu.com.springbootdemo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import prepedu.com.springbootdemo2.dto.ProductDTO;
import prepedu.com.springbootdemo2.entities.Image;
import prepedu.com.springbootdemo2.entities.Product;
import prepedu.com.springbootdemo2.repositories.CategoryRepo;
import prepedu.com.springbootdemo2.repositories.ImageRepo;
import prepedu.com.springbootdemo2.repositories.ProductRepo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ProductService {
    @Value("${UPLOAD_DIR}")
    String UPLOAD_DIR;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ImageRepo imageRepo;

    public void create(ProductDTO dto, MultipartFile[] files, RedirectAttributes redirectAttributes) {
        try {
            ArrayList<String> filePaths = new ArrayList<>();
            //upload files
            for (MultipartFile uploadFile : files) {
                //check image size
                if (uploadFile.getSize() > 1024 * 1024 * 20) {
                    redirectAttributes.addFlashAttribute("error_message", "Image size must be less than 2MB");
                    return;
                }
                //upload file
                //save file path to dto
                //create date folder
                Date date = new Date();
                String dateFolder = date.getYear() + "-" + date.getMonth() + "-" + date.getDate();
                if (!new File(UPLOAD_DIR + dateFolder).exists()) {
                    new File(UPLOAD_DIR + dateFolder).mkdir();
                }
                //create file name
                String fileName = date.getTime() + uploadFile.getOriginalFilename();
                File file = new File(UPLOAD_DIR + dateFolder + "/" + fileName);
                uploadFile.transferTo(file);
                filePaths.add(dateFolder + "/" + fileName);
            }

            try {
                Product savedProduct = productRepo.save(dto.mapToProduct());
                for (int i = 0; i < filePaths.size(); i++) {
                    Image image = new Image();
                    image.setPath(filePaths.get(i));
                    image.setProductId(savedProduct.getId());
                    if (i == 0) {
                        image.setIsThumbnail(1);
                    }
                    imageRepo.save(image);
                }
            } catch (Exception e) {
                //delete files
                for (String filePath : filePaths) {
                    new File(UPLOAD_DIR + filePath).delete();
                }
                throw e;
            }

            redirectAttributes.addFlashAttribute("success_message", "Product created successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error_message", "Product created failed");
        }
    }

    public void list(Model model) {
        ArrayList<ProductDTO> productDTO = new ArrayList<>();
        productRepo.findAll().forEach(product -> {
            productDTO.add(product.mapToDTO());
        });
        model.addAttribute("list", productDTO);
    }

    public void getOne(Long id, Model model) {
        productRepo.findById(id).ifPresent(product -> {
            model.addAttribute("dto", product.mapToDTO());
        });
    }

    public void update(Long id, ProductDTO userDTO) {
        productRepo.findById(id).ifPresent(product -> {
            productRepo.save(userDTO.mapToProduct());
        });
    }

    public void deleteOne(Long id) {
        productRepo.findById(id).ifPresent(product -> {
            productRepo.delete(product);
        });
    }
}
