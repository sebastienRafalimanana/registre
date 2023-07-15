package org.registre.mg.presentation.presence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validation")
public class Validation {
    @GetMapping
    public String checkValidation(){
        return "hello word";
    }
}
