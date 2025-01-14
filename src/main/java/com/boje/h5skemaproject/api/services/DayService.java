package com.boje.h5skemaproject.api.services;
import com.boje.h5skemaproject.api.dto.DayDTO;

import java.util.List;

public interface DayService {
    DayDTO createDay(DayDTO dayDTO);
    DayDTO getDayById(int id);
    List<DayDTO> getAllDays();
    DayDTO updateDay(DayDTO dayDTO);
    void deleteDay(int id);
}