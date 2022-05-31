package com.java.RateSystem.repository;

import com.java.RateSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
    @Query("SELECT s FROM User s WHERE s.name = :name AND s.password= :password")
    Optional<User> findByLoginAndPassword (String name, String password);
}
