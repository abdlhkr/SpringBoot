package com.springBoot.pagable.repository;

import com.springBoot.pagable.entity.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonalRepository extends JpaRepository<Personel,Long> {
    Page<Personel> findAll(Pageable pageable);
}
