package com.springBoot.pagable.service.serviceImple;

import com.springBoot.pagable.dto.DtoDepartment;
import com.springBoot.pagable.dto.DtoPersonel;
import com.springBoot.pagable.entity.Personel;
import com.springBoot.pagable.repository.PersonalRepository;
import com.springBoot.pagable.service.IPersonalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonalServiceImple implements IPersonalService {

    @Autowired
    private PersonalRepository personalRepository;



    public Page<Personel> findAllPageable(Pageable pageable){
        Page<Personel> page = personalRepository.findAll(pageable);
        return  page;
    }

    @Override
    public List<DtoPersonel> changeToDto(List<Personel> personels) {
        List<DtoPersonel> dtoPersonels = new ArrayList<>();
        for (Personel personel : personels) {
            DtoPersonel dtoPersonel = new DtoPersonel();
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(personel,dtoPersonel);
            BeanUtils.copyProperties(personel.getDepartment(),dtoDepartment);
            dtoPersonel.setDepartment(dtoDepartment);
            dtoPersonels.add(dtoPersonel);
        }
        return dtoPersonels;
    };
}
