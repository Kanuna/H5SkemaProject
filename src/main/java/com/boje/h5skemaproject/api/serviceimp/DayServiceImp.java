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
    private final ModelMapper modelMapper;

    public DayServiceImp(DayRepository dayRepository, ModelMapper modelMapper) {
        this.dayRepository = dayRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public DayDTO createDay(DayDTO dayDTO) {
        try{
            Day day = modelMapper.toDay(dayDTO);
            Day savedsDay = dayRepository.save(day);
            return modelMapper.toDayDTO(savedsDay);
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }


    @Override
    public DayDTO getDayById(int id) {
        Day day = dayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Day not found with id: " + id));
        return modelMapper.toDayDTO(day);
    }


    @Override
    public List<DayDTO> getAllDays(){
        try{
            List<Day> days = dayRepository.findAll();
            return days.stream()
                    .map(modelMapper::toDayDTO)
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
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