package org.example.hometask47hotel.service.impl;

import org.example.hometask47hotel.dto.HotelDto;
import org.example.hometask47hotel.entity.HotelEntity;
import org.example.hometask47hotel.mapper.HotelMapper;
import org.example.hometask47hotel.repository.HotelRepository;
import org.example.hometask47hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository hotelRepository, HotelMapper mapper) {
        this.hotelRepository = hotelRepository;
        this.mapper = mapper;
    }

    @Override
    public HotelDto save(HotelDto hotelDto) {
        HotelEntity hotelEntity = mapper.toEntity(hotelDto);
        hotelEntity = hotelRepository.save(hotelEntity);
        return mapper.toDto(hotelEntity);
    }

    @Override
    public HotelDto findById(UUID id) {
        HotelEntity hotelEntity = hotelRepository.findById(id).orElseThrow();
        return mapper.toDto(hotelEntity);
    }

    @Override
    public HotelDto update(HotelDto hotelDto) {
        HotelEntity hotelEntity = mapper.toEntity(hotelDto);
        HotelEntity updatedEntity = hotelRepository.save(hotelEntity);
        return mapper.toDto(updatedEntity);
    }

    @Override
    public List<HotelDto> findAll() {
        var list = hotelRepository.findAll();
        return list.stream()
                .map(hotelEntity -> mapper.toDto(hotelEntity))
                .toList();
    }

    @Override
    public List<HotelDto> findAllAvailable() {
        var list = hotelRepository.findByAvailableTrue();
        return list.stream()
                .map(hotelEntity -> mapper.toDto(hotelEntity))
                .toList();
    }

    @Override
    public HotelDto setRented(UUID id) {
        HotelDto byId = findById(id);
        byId.setAvailable(false);
        return update(byId);
    }

    @Override
    public HotelDto setUnRented(UUID id) {
        HotelDto byId = findById(id);
        byId.setAvailable(true);
        return update(byId);
    }
}
