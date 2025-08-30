package org.example.hometask47hotel.service;

import org.example.hometask47hotel.dto.HotelDto;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    HotelDto save(HotelDto hotelDto);

    HotelDto findById(UUID id);

    HotelDto update(HotelDto hotelDto);

    List<HotelDto> findAll();

    List<HotelDto> findAllAvailable();

}
