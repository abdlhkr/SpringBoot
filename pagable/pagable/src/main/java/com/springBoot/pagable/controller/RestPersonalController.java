package com.springBoot.pagable.controller;

import com.springBoot.pagable.dto.DtoPersonel;
import com.springBoot.pagable.entity.Personel;
import com.springBoot.pagable.service.IPersonalService;
import com.springBoot.pagable.utils.RestPageableEntity;
import com.springBoot.pagable.utils.RestPageableRequest;
import com.springBoot.pagable.utils.RestRootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/personel")
public class    RestPersonalController extends RestBaseController implements IPersonalController {

     @Autowired
     private IPersonalService personalService;


    // public Page findAll(@RequestParam(value = "pageNumber") int pageNumber
    //                   ,@RequestParam(value = "pageSize") int pageSize) {
     @GetMapping("/page")
     @Override
    public RestRootEntity<RestPageableEntity<DtoPersonel>> findAll(RestPageableRequest restPageableRequest){
//        Pageable request = toPageable(restPageableRequest);
//        return  personalService.findAllPageable(request);
         Page<Personel> page = personalService.findAllPageable(toPageable(restPageableRequest));
         RestPageableEntity<DtoPersonel> personelRestPageableEntity = toPageableResponse(page,personalService.changeToDto(page.getContent()));
         return ok(personelRestPageableEntity);
    }
}
