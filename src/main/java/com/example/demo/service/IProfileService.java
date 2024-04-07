package com.example.demo.service;

import com.example.demo.entity.Profile;
import com.example.demo.request.ProfileRequest;

import java.util.List;

public interface IProfileService {
    public Profile addProfile(ProfileRequest request) throws Exception;

    void removeProfile(Long id);

    List<Profile> getProfiles();
}
