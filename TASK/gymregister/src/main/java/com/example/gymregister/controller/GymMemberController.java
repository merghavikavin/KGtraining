package com.example.gymregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gymregister.entity.GymMember;
import com.example.gymregister.service.GymMemberService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class GymMemberController {

    @Autowired
    private GymMemberService gymMemberService;

    @GetMapping("/")
    public ResponseEntity<List<GymMember>> getAllMembers() {
        List<GymMember> members = gymMemberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymMember> getMemberById(@PathVariable Long id) {
        GymMember member = gymMemberService.getMemberById(id);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add/member")
    public ResponseEntity<GymMember> addMember(@RequestBody GymMember member) {
        GymMember createdMember = gymMemberService.saveMember(member);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    
    public ResponseEntity<GymMember> updateMember(@PathVariable Long id, @RequestBody GymMember updatedData) {
        GymMember updatedMember = gymMemberService.updateMember(id, updatedData);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMember(@PathVariable Long id) {
        gymMemberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

}
