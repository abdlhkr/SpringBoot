package com.GaleriProject.GaleriProject.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError<T> {
    private int status;
    private Exception<T> exception;
}
