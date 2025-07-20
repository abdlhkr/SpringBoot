package com.example.spring_data_jpa.dto;


import com.example.spring_data_jpa.entities.Room;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoHome {
    private String name;
    private List<DtoRoom> rooms;
}
