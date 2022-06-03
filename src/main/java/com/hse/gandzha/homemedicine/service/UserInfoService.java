package com.hse.gandzha.homemedicine.service;

import com.hse.gandzha.homemedicine.entity.Medicine;
import com.hse.gandzha.homemedicine.entity.UserInfo;
import com.hse.gandzha.homemedicine.repository.UserInfoRepository;
import lombok.Data;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final MedicineService medicineService;

    public UserInfo findByEmail(String email) {
        return userInfoRepository.findByEmail(email).orElseThrow(() ->
                new ObjectNotFoundException("User not found with email", email));
    }

    public void save(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    public void deleteMedicine(String email, Medicine medicine) {
        UserInfo userInfo = userInfoRepository.findByEmail(email).orElseThrow(() ->
                new ObjectNotFoundException("User not found with email", email));
        Medicine deleteMedicine = new Medicine();
        for (Medicine m : userInfo.getMedicine()) {
            if (medicine.getId().equals(m.getId())) {
                deleteMedicine = m;
            }
        }
        if (deleteMedicine.getCount() == 0) {
            userInfo.getMedicine().remove(deleteMedicine);
        } else {
            for (Medicine m : userInfo.getMedicine()) {
                if (medicine.getId().equals(m.getId())) {
                    deleteMedicine.setCount(deleteMedicine.getCount() + 1);
                }
            }
        }
        userInfoRepository.save(userInfo);
    }

    @Transactional
    public void addMedicine(String email, List<Medicine> medicine) {
        UserInfo userInfo = userInfoRepository.findByEmail(email).orElseThrow(() ->
                new ObjectNotFoundException("User not found with email", email));

        userInfo.getMedicine().addAll(medicine);
        userInfoRepository.save(userInfo);
    }
}
