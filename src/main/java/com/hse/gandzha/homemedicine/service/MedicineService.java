package com.hse.gandzha.homemedicine.service;

import com.hse.gandzha.homemedicine.entity.Medicine;
import com.hse.gandzha.homemedicine.repository.MedicineRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Data
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public Medicine findById(UUID id) {
        return medicineRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException());
    }

    public void deleteMedicine(UUID id) {
        medicineRepository.deleteById(id);
    }
}
