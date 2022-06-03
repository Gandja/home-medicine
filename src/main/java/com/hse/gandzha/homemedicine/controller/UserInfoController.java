package com.hse.gandzha.homemedicine.controller;

import com.hse.gandzha.homemedicine.entity.UserInfo;
import com.hse.gandzha.homemedicine.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/userinfo", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @PostMapping("/new/user")
    public UserInfo saveOrUpdateUserInfo(@RequestBody UserInfo request){
        userInfoService.save(request);
        return request;
    }

    @PostMapping ()
    public UserInfo getUserMedicine(@RequestBody UserInfo request) {
        return userInfoService.findByEmail(request.getEmail());
    }

    @DeleteMapping()
    public void deleteMedicine(@RequestBody UserInfo request) {
        userInfoService.deleteMedicine(request.getEmail(),request.getMedicine().get(0));
    }

    @PutMapping("addMedicine")
    public void addMedicine(@RequestBody UserInfo request) {
        userInfoService.addMedicine(request.getEmail(),request.getMedicine());
    }
}
