package com.jpa.app.springjpamanytomany.repository;

import com.jpa.app.springjpamanytomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
