package com.example.demo.service;

import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.request.ProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements IProfileService {
    private final ProfileRepository profileRepository;
    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Profile addProfile(ProfileRequest request) throws Exception {
        try{
            Profile profile = new Profile();
            profile.setLastName(request.getLastName());
            profile.setFirstName(request.getFirstName());
            profile.setActive(true);
            return profileRepository.save(profile);
        }catch (Exception ex){
            // ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }

        }

        @Override
        public void removeProfile(Long id) {
            Optional<Profile> profile = profileRepository.findById(id);
            if (profile.isPresent()){
                Profile profile1 = profile.get();
                profileRepository.delete(profile1);
            }
            System.out.println("Profile Not Found");
        }

        @Override
        public List<Profile> getProfiles() {

            return profileRepository.findAll();
        }
}
