package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User getUserById(Long id);

    User getUserByEmail(String email);


}
