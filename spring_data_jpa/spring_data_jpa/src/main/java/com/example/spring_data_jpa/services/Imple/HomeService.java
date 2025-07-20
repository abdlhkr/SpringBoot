package com.example.spring_data_jpa.services.Imple;

import com.example.spring_data_jpa.dto.DtoHome;
import com.example.spring_data_jpa.dto.DtoRoom;
import com.example.spring_data_jpa.entities.Home;
import com.example.spring_data_jpa.entities.Room;
import com.example.spring_data_jpa.repository.HomeRepository;
import com.example.spring_data_jpa.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private HomeRepository repository;

    @Override
    public DtoHome getHomeById(int id) {
       Optional<Home> home = repository.findById(id);
       if (home.isPresent()) {
           DtoHome dtoHome = new DtoHome();
           BeanUtils.copyProperties(home.get(), dtoHome);
           DtoRoom dtoRoom = new DtoRoom();
           List<Room> roomList= home.get().getRooms();
           List<DtoRoom> dtoRoomList= new ArrayList<>();
              for (Room room : roomList) {
                DtoRoom dtoRoomItem = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoomItem);
                dtoRoomList.add(dtoRoomItem);
              }
           dtoHome.setRooms(dtoRoomList);
           return dtoHome;
       }else {
              return null;
       }
    }
}
