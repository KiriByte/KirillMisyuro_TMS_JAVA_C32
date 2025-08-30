package org.example.hometask47client.service;

import org.example.hometask47client.dto.HotelDto;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    List<HotelDto> getHotels();

    HotelDto rentHotel(UUID id);

    HotelDto unrentHotel(UUID id);
}
