package com.springBoot.pagable.controller;

import com.springBoot.pagable.dto.DtoPersonel;
import com.springBoot.pagable.utils.RestPageableEntity;
import com.springBoot.pagable.utils.RestPageableRequest;
import com.springBoot.pagable.utils.RestRootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonalController {
    RestRootEntity<RestPageableEntity<DtoPersonel>> findAll(RestPageableRequest restPageableRequest);
}
