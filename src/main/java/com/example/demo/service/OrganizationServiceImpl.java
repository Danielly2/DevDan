package com.example.demo.service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;
import com.example.demo.request.OrganizationRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrganizationServiceImpl implements IOrganizationService{
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    @Override
    public Organization addOrganization(OrganizationRequest request) throws Exception {
        try{
            Organization organization = new Organization();
            organization.setLastName(request.getLastName());
            organization.setFirstName(request.getFirstName());
            organization.setActive(true);
            return organizationRepository.save(organization);
        }catch (Exception ex){
            // ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    public void removeOrganization(Long id) {
        Optional<Organization> organization = organizationRepository.findById(id);
        if (organization.isPresent()){
            Organization organization1 = organization.get();
            organizationRepository.delete(organization1);
        }
        System.out.println("Organization Not Found");
    }

    @Override
    public List<Organization> getOrganizations() {

        return organizationRepository.findAll();
    }
}
