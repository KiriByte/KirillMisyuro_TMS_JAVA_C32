package org.example.hometask47hotel.controller;

import org.example.hometask47hotel.dto.HotelDto;
import org.example.hometask47hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hotels/")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public List<HotelDto> findAll() {
        return hotelService.findAll();
    }

    @GetMapping("/allAvailable")
    public List<HotelDto> findAllAvailable() {
        return hotelService.findAllAvailable();
    }

    @GetMapping("/{id}")
    public HotelDto findById(@PathVariable UUID id) {
        return hotelService.findById(id);
    }

    @PostMapping("/add")
    public HotelDto addHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.save(hotelDto);
    }

    @PutMapping("/update")
    public HotelDto updateHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.update(hotelDto);
    }

    @PutMapping("/rent")
    public HotelDto rentHotel(@RequestBody UUID id) {
        return hotelService.setRented(id);
    }

    @PutMapping("/unrent")
    public HotelDto unRentHotel(@RequestBody UUID id) {
        return hotelService.setUnRented(id);
    }


}
