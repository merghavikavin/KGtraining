package com.example.gymregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymregister.entity.GymMember;

public interface GymMemberRepository extends JpaRepository<GymMember, Long> {

}
