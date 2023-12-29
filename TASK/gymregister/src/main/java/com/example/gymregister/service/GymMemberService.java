package com.example.gymregister.service;

import com.example.gymregister.entity.GymMember;

import java.util.List;

public interface GymMemberService {

    List<GymMember> getAllMembers();

    GymMember getMemberById(Long memberId);

    GymMember saveMember(GymMember member);

    GymMember updateMember(Long memberId, GymMember updatedMember);

    void deleteMember(Long memberId);
}
