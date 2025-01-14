package com.boje.h5skemaproject.api.serviceimp;

import com.boje.h5skemaproject.api.ResourceNotFoundException.ResourceNotFoundException;
import com.boje.h5skemaproject.api.dto.DayDTO;
import com.boje.h5skemaproject.api.mapper.ModelMapper;
import com.boje.h5skemaproject.api.services.DayService;
import com.boje.h5skemaproject.models.Day;
import com.boje.h5skemaproject.repositories.DayRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayServiceImp implements DayService {
    private final DayRepository dayRepository;
    private ModelMapper modelMapper;

    public DayServiceImp(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }


    @Override
    public DayDTO createDay(DayDTO dayDTO) {
        Day day = modelMapper.toDay(dayDTO);
        Day savedsDay = dayRepository.save(day);
        return modelMapper.toDayDTO(savedsDay);
    }


    @Override
    public DayDTO getDayById(int id) {
        Day day = dayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Day not found with id: " + id));
        return modelMapper.toDayDTO(day);
    }


    @Override
    public List<DayDTO> getAllDays(){
        List<Day> days = dayRepository.findAll();
        return days.stream()
                .map(modelMapper::toDayDTO)
                .collect(Collectors.toList());
    }


    @Override
    public DayDTO updateDay(DayDTO dayDTO) {
        Day existingDay = dayRepository.findById(dayDTO.getDay_id())
                .orElseThrow(() -> new ResourceNotFoundException("Day not found with id: " + dayDTO.getDay_id()));
        Day updatedDay = dayRepository.save(existingDay);
        return modelMapper.toDayDTO(updatedDay);
    }


    @Override
    public void deleteDay(int id) {
        try{
            dayRepository.deleteById(id);dayRepository.deleteById(id);
        }
        catch(ResourceNotFoundException e){
            throw new ResourceNotFoundException("Day not found with id: " + id);
        }
    }
}