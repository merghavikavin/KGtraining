package com.fileupload.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileupload.upload.entity.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    
}
