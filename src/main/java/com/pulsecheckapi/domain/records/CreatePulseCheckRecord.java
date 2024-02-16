package com.pulsecheckapi.domain.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreatePulseCheckRecord(
    @NotBlank
    String unit,
    @NotNull
    int measurement_value,
    @NotNull
    LocalDate measurement_date,
    @NotNull
    LocalTime measurement_time,
    @NotBlank
    String user_id
) { }
