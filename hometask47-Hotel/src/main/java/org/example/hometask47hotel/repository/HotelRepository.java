package org.example.hometask47hotel.repository;

import org.example.hometask47hotel.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {

    public List<HotelEntity> findByIsAvailableTrue();
}
