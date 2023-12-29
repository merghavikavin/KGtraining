package com.example.gymregister.service;

import com.example.gymregister.entity.GymMember;
import com.example.gymregister.repository.GymMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberServiceImpl implements GymMemberService {

    @Autowired
    private GymMemberRepository gymMemberRepository;
    
    @Override
    public List<GymMember> getAllMembers() {
        return gymMemberRepository.findAll();
    }

    @Override
    public GymMember getMemberById(Long memberId) {
        return gymMemberRepository.findById(memberId).orElse(null);
    }

    @Override
    public GymMember saveMember(GymMember member) {
        return gymMemberRepository.save(member);
    }

    @Override
    public GymMember updateMember(Long memberId, GymMember updatedMember) {
        GymMember existingMember = gymMemberRepository.findById(memberId).orElse(null);

        if (existingMember != null) {
            // Update the fields you want to allow modification
            existingMember.setFirstName(updatedMember.getFirstName());
            existingMember.setLastName(updatedMember.getLastName());
            existingMember.setGender(updatedMember.getGender());
            existingMember.setEmail(updatedMember.getEmail());
            existingMember.setPhone(updatedMember.getPhone());
            existingMember.setAddress(updatedMember.getAddress());
            existingMember.setMembershipType(updatedMember.getMembershipType());
            existingMember.setMembershipDuration(updatedMember.getMembershipDuration());
            existingMember.setWorkoutPreferences(updatedMember.getWorkoutPreferences());

            // Save the updated member
            return gymMemberRepository.save(existingMember);
        } else {
            // Handle case where the member with the given ID is not found
            throw new RuntimeException("Member not found with id: " + memberId);
        }
    }

    @Override
    public void deleteMember(Long memberId) {
        gymMemberRepository.deleteById(memberId);
    }
}
