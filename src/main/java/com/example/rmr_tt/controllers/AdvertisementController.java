package com.example.rmr_tt.controllers;


import com.example.rmr_tt.models.Advertisement;
import com.example.rmr_tt.repositories.AdvertisementRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @GetMapping
    public List<Advertisement> getAllAdvertisements() {
        return (List<Advertisement>) advertisementRepository.findAll();
    }

    @GetMapping("/{id}")
    public Advertisement getAdvertisementById(@PathVariable("id") long id) {
        if(advertisementRepository.findById(id).isEmpty())
            throw new RuntimeException("Advertisement not found");
        return advertisementRepository.findById(id).get();
    }

    @PostMapping
    public Advertisement saveAdvertisement(@RequestBody Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @DeleteMapping("/{id}")
    public void deleteAdvertisement(@PathVariable("id") long id) {
        if(advertisementRepository.findById(id).isEmpty())
            throw new RuntimeException("Advertisement not found");
        advertisementRepository.deleteById(id);
    }
}
