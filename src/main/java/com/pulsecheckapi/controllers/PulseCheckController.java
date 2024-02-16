package com.pulsecheckapi.controllers;

import com.pulsecheckapi.domain.records.PulseCheckRecord;
import com.pulsecheckapi.domain.entities.PulseCheckEntity;

import jakarta.validation.Valid;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
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

  @GetMapping
  @Transactional
  @ResponseStatus(HttpStatus.OK)
  public List<PulseCheckRecord> getAllMeasurements() {
    List<PulseCheckRecord> _pulseCheckRecord = _repository.findAll().stream().map(PulseCheckRecord::new).toList();
    return _pulseCheckRecord;
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
}