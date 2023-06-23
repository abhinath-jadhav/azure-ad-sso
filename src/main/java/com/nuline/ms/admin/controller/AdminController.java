package com.nuline.ms.admin.controller;

import com.nuline.ms.admin.models.User;
import com.nuline.ms.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping("/admin")
    public ResponseEntity<?> addAdmin(@RequestBody User admin){
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }

    @GetMapping("/admin")
    public ResponseEntity<?> getAdmin(){
        return ResponseEntity.ok(adminService.getAdmins());
    }

    @GetMapping("/admin/auth")
    public ResponseEntity<?> getAdmin1(){
        return ResponseEntity.ok("adminService.getAdmins()");
    }
    @GetMapping("/admin/test")
    public ResponseEntity<?> getAdmin2(){
        return ResponseEntity.ok("ok");
    }
}
