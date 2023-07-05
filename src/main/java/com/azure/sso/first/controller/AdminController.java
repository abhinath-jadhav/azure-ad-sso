package com.azure.sso.first.controller;

import com.azure.sso.first.annoatation.GroupsAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/auth")
    @GroupsAllowed("asdad")
    public ResponseEntity<?> getAdmin1(){
        return ResponseEntity.ok("adminService.getAdmins()");
    }
    @GetMapping("/test")
    @GroupsAllowed("asdad, 1231")
    public ResponseEntity<?> getAdmin2(){
        return ResponseEntity.ok("ok");
    }
}
