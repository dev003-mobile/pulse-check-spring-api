package com.pulsecheckapi.domain.records;

import com.pulsecheckapi.domain.entities.PulseCheckEntity;
import jakarta.validation.constraints.NotBlank;

public record DeletePulseCheckRecord(
    @NotBlank
    String id
) { }
