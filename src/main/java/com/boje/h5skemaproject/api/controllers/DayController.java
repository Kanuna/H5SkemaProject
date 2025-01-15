package com.boje.h5skemaproject.api.controllers;

import com.boje.h5skemaproject.api.dto.DayDTO;
import com.boje.h5skemaproject.api.serviceimp.DayServiceImp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {
    private final DayServiceImp dayServiceImp;

    public DayController(DayServiceImp dayServiceImp) {
        this.dayServiceImp = dayServiceImp;
    }

    @PostMapping
    public DayDTO createDay(@RequestBody DayDTO dayDTO) {
        return dayServiceImp.createDay(dayDTO);
    }

    @GetMapping("/{id}")
    public DayDTO getDay(@PathVariable int id) {
        return dayServiceImp.getDayById(id);
    }

    @GetMapping("/all")
    public List<DayDTO> getAllDays() {
        return dayServiceImp.getAllDays();
    }

    @PutMapping("/update")
    public DayDTO updateDay(@RequestBody DayDTO dayDTO) {
        return dayServiceImp.updateDay(dayDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDay(@PathVariable int id) {
        dayServiceImp.deleteDay(id);
    }
}