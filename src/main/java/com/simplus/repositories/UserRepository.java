package com.simplus.repositories;

import com.simplus.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly=true)
    public List<User> findAll();

    User findByEmail(String email);
}
