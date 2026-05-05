package com.bn.spring_security.repositories;

import com.bn.spring_security.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

    UserDetails findByLogin (String role);

}
