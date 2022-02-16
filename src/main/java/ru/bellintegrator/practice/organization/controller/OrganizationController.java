package ru.bellintegrator.practice.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController (OrganizationService organizationService) { this.organizationService = organizationService;}

    @GetMapping("/organization/{id:[0-9]}")
    public OrganizationView organization(@PathVariable("id") Long organizationID) {
        return organizationService.organization(organizationID);
    }

    @GetMapping("/organization/all")
    public List<OrganizationView> allOrganizations() {
        return organizationService.all();
    }

    @GetMapping("/organization/list")
    public List<OrganizationView> organizations(@RequestBody OrganizationView organization) {

        return organizationService.organizations(organization);
    }

    @PostMapping("/organization/save")
    public void save(@RequestBody OrganizationView organization) {
        organizationService.add(organization);
    }

    @PostMapping("/organization/update")
    public void update(@RequestBody OrganizationView organization){
        organizationService.update(organization);
    }

}
