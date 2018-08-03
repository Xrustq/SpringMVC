package com.epam.shop.less.shop.dao;

import com.epam.shop.less.shop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {

    Role getOne(Long id);
}
