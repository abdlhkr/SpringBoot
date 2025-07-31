package com.GaleriProject.GaleriProject.repository;

import com.GaleriProject.GaleriProject.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
//    @Query(value = "SELECT a from Adress a where a.id in :adressIdList")
//    public List<Adress> findAllByAccountId(@Param("adressIdList") List<Long> adressIdList);
    // alttaki springten gelen yukarıdaki ile aynı işi yapıyor
    List<Adress> findByIdIn(List<Long> idList);
    Optional<Adress> findById(long id);
}
