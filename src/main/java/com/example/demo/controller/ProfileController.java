package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.request.ProfileRequest;
import com.example.demo.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1")
public class ProfileController {

    private final IProfileService iProfileService;

    @Autowired
    public ProfileController(IProfileService iProfileService) {

        this.iProfileService = iProfileService;
    }

    @PostMapping("/profiles")
    public String saveProfile(@RequestBody  ProfileRequest request) throws Exception {
        Profile profile = iProfileService.addProfile(request);
        return "Profile created successful";
    }
}
