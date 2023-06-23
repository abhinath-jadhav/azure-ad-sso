package com.nuline.ms.admin.service;

import com.nuline.ms.admin.models.User;
import com.nuline.ms.admin.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public User addAdmin(User admin) {
        return adminRepo.save(admin);
    }

    public List<User> getAdmins() {
        return adminRepo.findAll();
    }
}
