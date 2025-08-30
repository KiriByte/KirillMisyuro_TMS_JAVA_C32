package org.example.hometask47client.service.impl;

import org.example.hometask47client.dto.HotelDto;
import org.example.hometask47client.service.HotelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service

public class HotelServiceImpl implements HotelService {

    private final RestTemplate restTemplate;
    @Value("${hotels.service.url}")
    private String URI;

    public HotelServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<HotelDto> getHotels() {
        HotelDto[] hotels = restTemplate.getForObject(URI + "/allAvailable", HotelDto[].class);
        return Arrays.asList(hotels);
    }

    @Override
    public HotelDto rentHotel(UUID id) {
        return restTemplate.exchange(URI + "/rent",
                HttpMethod.PUT,
                new HttpEntity<>(id),
                HotelDto.class).getBody();
    }

    @Override
    public HotelDto unrentHotel(UUID id) {
        return restTemplate.exchange(URI + "/unrent",
                HttpMethod.PUT,
                new HttpEntity<>(id),
                HotelDto.class).getBody();

    }
}
