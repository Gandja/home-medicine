package com.hse.gandzha.homemedicine.repository;

import com.hse.gandzha.homemedicine.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID>, CustomUserRepository  {


    Optional<UserInfo> findByEmail(String email);
}
