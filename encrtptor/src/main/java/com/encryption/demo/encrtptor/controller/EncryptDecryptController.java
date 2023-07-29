package com.encryption.demo.encrtptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptDecryptController {

   /* BaseAESEncryptDecryptUtility baseAESEncryptDecryptUtility = new BaseAESEncryptDecryptUtility("lkhueielehn ckncnc",3);

    @GetMapping("/encrypt")
    public String getEncryptString() {
        return baseAESEncryptDecryptUtility.encrypt("Hi raa");
    }

    @GetMapping("/decrypt/{input}")
    public String getDecryptString(@RequestParam("input") String input) {
        return baseAESEncryptDecryptUtility.decrypt(input);
    }*/

    @GetMapping("/hello")
    public String getEncryptString() {
        return "Hellow everyone";
    }
}
