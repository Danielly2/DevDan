package com.example.demo.service;

import com.example.demo.entity.Organization;
import com.example.demo.request.OrganizationRequest;

import java.util.List;

public interface IOrganizationService {

    public Organization addOrganization(OrganizationRequest request) throws Exception;

    void removeOrganization(Long id);

    List<Organization> getOrganizations();
}
