package com.hse.gandzha.homemedicine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Medicine {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private int count;
    private String description;
    private LocalDate expirationDate;
}
