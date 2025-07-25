package com.springBoot.pagable.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestPageableRequest {
    private int pageNumber;
    private int pageSize;
    private String columnName;
    private boolean isAscending;
}
