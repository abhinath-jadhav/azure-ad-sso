package com.azure.sso.first.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {



    @GetMapping("/auth")
    public ResponseEntity<?> getAdmin1(){
        return ResponseEntity.ok("adminService.getAdmins()");
    }
    @GetMapping("/test")
    public ResponseEntity<?> getAdmin2(){
        return ResponseEntity.ok("ok");
    }
}
