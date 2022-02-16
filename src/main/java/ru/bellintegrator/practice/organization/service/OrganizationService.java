package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import javax.validation.Valid;


public interface OrganizationService {

    /**
     * Добавить нового человека в БД
     *
     * @param organization
     */
    void add(@Valid OrganizationView organization);

    /**
     * Получить список людей
     *
     * @return {@Organization}
     */
    List<OrganizationView> all();

    /**
     * Получить список людей
     *
     * @return {@Organization}
     */
    List<OrganizationView> organizations(OrganizationView organization);

    /**
     * Получить организацию по ID
     *
     * @return {@Organization}
     */
    OrganizationView organization(Long id);

    /**
     * Обновить данные об организации
     */
    void update(OrganizationView organization);
}
