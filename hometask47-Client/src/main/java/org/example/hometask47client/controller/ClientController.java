package org.example.hometask47client.controller;

import org.example.hometask47client.dto.HotelDto;
import org.example.hometask47client.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    private final HotelService hotelService;

    public ClientController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public List<HotelDto> allAvailable() {
        return hotelService.getHotels();
    }

    @PostMapping("/rent")
    public HotelDto rentHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.rentHotel(hotelDto.getId());
    }

    @PostMapping("/unrent")
    public HotelDto unrentHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.unrentHotel(hotelDto.getId());
    }
}
