package com.nuline.ms.admin.repository;

import com.nuline.ms.admin.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends MongoRepository<User, String> {
}
