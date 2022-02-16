package ru.bellintegrator.practice.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationDao dao;

    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> all() {
        List<Organization> all = dao.all();
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> organizations(OrganizationView organization) {
        //List<Organization> all = dao.all();
        List<Organization> all = dao.findByAttributes(organization.name, organization.inn, organization.isActive);
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OrganizationView organization(Long id) {
        Organization organization = dao.loadById(id);
        return mapperFacade.map(organization, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OrganizationView view) {
        Organization organization = dao.loadById(view.id);
        organization.setName(view.name);
        organization.setFullName(view.fullName);
        organization.setInn(view.inn);
        organization.setKpp(view.kpp);
        organization.setAddress(view.address);
        if(view.phone!=null) organization.setPhone(view.phone);
        if(view.isActive!=null) organization.setActive(view.isActive);
        dao.save(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp, view.address, view.phone, view.isActive);
        dao.save(organization);
    }
}
