package com.pulsecheckapi.domain.records;

import com.pulsecheckapi.domain.entities.PulseCheckEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public record PulseCheckRecord(
    String id,
    String unit,
    int measurement_value,
    LocalDate measurement_date,
    String measurement_description_date,
    LocalTime measurement_time,
    String user_id
) {
  public PulseCheckRecord(PulseCheckEntity data) {
    this(
        data.getId(), data.getUnit(),
        data.getMeasurement_value(),
        data.getMeasurement_date(),
        data.getMeasurement_description_date(),
        data.getMeasurement_time(),
        data.getId());
  }
}