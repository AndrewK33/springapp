package com.geekbrains.webapp.springapp.repositories;


import com.geekbrains.webapp.springapp.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
