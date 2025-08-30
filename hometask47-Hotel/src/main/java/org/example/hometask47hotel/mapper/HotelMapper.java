package org.example.hometask47hotel.mapper;

import org.example.hometask47hotel.dto.HotelDto;
import org.example.hometask47hotel.entity.HotelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelEntity toEntity(HotelDto hotelDto);

    HotelDto toDto(HotelEntity hotelEntity);
}
