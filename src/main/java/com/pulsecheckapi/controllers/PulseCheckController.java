package com.pulsecheckapi.controllers;

import com.pulsecheckapi.domain.records.GetRangeDatePulseCheckRecord;
import com.pulsecheckapi.domain.records.PulseCheckRecord;
import com.pulsecheckapi.domain.entities.PulseCheckEntity;

import jakarta.validation.Valid;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.pulsecheckapi.domain.records.DeletePulseCheckRecord;
import com.pulsecheckapi.domain.repositories.PulseCheckRepository;

import java.util.List;

@RestController
@RequestMapping("/pulse-check")
public class PulseCheckController {
  @Autowired
  PulseCheckRepository _repository;

  @GetMapping("/all")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public List<PulseCheckRecord> getAllMeasurements() {
    List<PulseCheckRecord> _pulseCheckRecord = _repository.findAll().stream().map(PulseCheckRecord::new).toList();
    return _pulseCheckRecord;
  }

  @PostMapping("/filter")
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity getRangeFilter(@RequestBody @Valid GetRangeDatePulseCheckRecord data) {
    List<PulseCheckEntity> _pulseCheck = _repository.findAll();
    List<PulseCheckEntity> _pulseFilter = _pulseCheck.stream()
        .filter(pulse -> {
          boolean result = pulse.getMeasurement_date().isAfter(data.start_date()) && pulse.getMeasurement_date().isBefore(data.end_date()) ||
                  pulse.getMeasurement_date().isEqual(data.start_date()) || pulse.getMeasurement_date().isEqual(data.end_date());
          return result;
        })
        .toList();
    return ResponseEntity.ok(_pulseFilter);
  }
    
  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public void deleteMeasurement(@RequestBody @Valid DeletePulseCheckRecord data) {
    _repository.deleteById(data.id());
  }

  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.CREATED)
  public PulseCheckEntity createMeasurement(@RequestBody @Valid PulseCheckRecord data) {
    PulseCheckEntity _pulseCheck = _repository.save(new PulseCheckEntity(data));
    return _pulseCheck;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public int getTotalBPM(@PathVariable String id) {
    List<PulseCheckEntity> _listPulseCheck = _repository.findAll();
    int result = _listPulseCheck.stream()
            .filter(pulse -> pulse.getUser_id().equals(id))
            .mapToInt(PulseCheckEntity::getMeasurement_value)
            .sum();
    return result;
  }

  @GetMapping("/count-measurement/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public Long getCountMeasurement(@PathVariable String id) {
    List<PulseCheckEntity> _listPulseCheck = _repository.findAll();
    Long countMeasurement = _listPulseCheck.stream()
        .filter(pulse -> pulse.getUser_id().equals(id))
        .count();
    return countMeasurement;
  }
}