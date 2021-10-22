package com.repository;



import com.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
<<<<<<< HEAD
    //AnhLT
    Role findByName(String name);
=======

>>>>>>> 741a35df26d2524d322d67b744e52f5a620c92bd
}
