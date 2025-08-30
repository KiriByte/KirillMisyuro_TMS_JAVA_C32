package org.example.hometask47hotel.mapper;

import org.example.hometask47hotel.dto.HotelDto;
import org.example.hometask47hotel.entity.HotelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    public HotelEntity toEntity(HotelDto hotelDto);

    public HotelDto toDto(HotelEntity hotelEntity);
}
