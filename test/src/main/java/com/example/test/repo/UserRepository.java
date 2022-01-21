package com.example.test.repo;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    public List<User> findById(int id);
    public List<User> findByName(String name);
}
