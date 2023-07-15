package org.registre.mg.presentation.presence;

import org.apache.commons.codec.binary.Base64;
import org.registre.mg.business.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping("validation")
public class ValidationController {
    @Autowired
    ValidationService validationService;
    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String checkValidation(@RequestPart MultipartFile file){
        try {
            byte[] image = Base64.encodeBase64(file.getBytes());  //Todo:convertie file to base64
            String imageBase64 = new String(image);
            validationService.faceDetection(imageBase64);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "hello word";
    }
}
