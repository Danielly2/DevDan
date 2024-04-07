package com.example.demo.controller;

import com.example.demo.entity.Organization;
import com.example.demo.request.OrganizationRequest;
import com.example.demo.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1")
public class OrganizationController {
    private final IOrganizationService iOrganizationService;
    @Autowired
    public OrganizationController(IOrganizationService iOrganizationService){
        this.iOrganizationService = iOrganizationService;

    }
    @PostMapping
    public String saveOrganization(@RequestBody OrganizationRequest request) throws Exception{
        Organization organization = iOrganizationService.addOrganization(request);
        return "Profile created successfully";
    }
}
