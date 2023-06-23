package com.nuline.ms.admin.models;

import com.nuline.ms.admin.models.enums.UserRole;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Users")
public class User{

    @Id
    private String id;
    private String username;
    private String name;
    private String password;
    private String email;
    private List<UserRole> roles;
    private boolean accountNonExpired;

}
