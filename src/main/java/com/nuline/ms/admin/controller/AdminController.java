package com.nuline.ms.admin.controller;

import com.nuline.ms.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/auth")
    public ResponseEntity<?> getAdmin1(){
        return ResponseEntity.ok("adminService.getAdmins()");
    }
    @GetMapping("/test")
    public ResponseEntity<?> getAdmin2(){
        return ResponseEntity.ok("ok");
    }
}
