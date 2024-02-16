package com.pulsecheckapi.domain.entities;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

import com.pulsecheckapi.domain.records.PulseCheckRecord;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "blood_pressure")
@Table(name = "blood_pressure")
@EqualsAndHashCode(of = "id")
public class PulseCheckEntity {
  public PulseCheckEntity(PulseCheckRecord data) {
    this.unit = data.unit();
    this.measurement_date = data.measurement_date();
    this.measurement_time = data.measurement_time();
    this.measurement_value = data.measurement_value();
    this.user_id = data.user_id();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String unit;
  private int measurement_value;
  private LocalDate measurement_date;
  private LocalTime measurement_time;
  private String user_id;
}