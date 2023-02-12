package com.Contact.ContactManager.dao;

import com.Contact.ContactManager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepo extends JpaRepository<User,Integer> {

}
