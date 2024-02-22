package com.pulsecheckapi.domain.records;

import jakarta.validation.constraints.NotBlank;

public record GetTotalBPMRecord(
    @NotBlank
    String id
) { }
