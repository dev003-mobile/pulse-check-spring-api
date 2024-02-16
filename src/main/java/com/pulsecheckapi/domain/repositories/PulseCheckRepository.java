package com.pulsecheckapi.domain.repositories;

import com.pulsecheckapi.domain.entities.PulseCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PulseCheckRepository extends JpaRepository<PulseCheckEntity, String> { }