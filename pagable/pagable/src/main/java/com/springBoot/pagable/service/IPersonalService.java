package com.springBoot.pagable.service;

import com.springBoot.pagable.dto.DtoPersonel;
import com.springBoot.pagable.entity.Personel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonalService {
    Page<Personel> findAllPageable(Pageable pageable);
    List<DtoPersonel> changeToDto(List<Personel> personels);
}
