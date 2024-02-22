package com.pulsecheckapi.domain.records;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record GetRangeDatePulseCheckRecord(
    @NotNull
    @PastOrPresent
    LocalDate start_date,
    @PastOrPresent
    LocalDate end_date
) { }