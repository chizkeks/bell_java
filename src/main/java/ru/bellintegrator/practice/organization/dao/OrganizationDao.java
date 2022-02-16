package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Получить список Organization по имени (обязательное поле), ИНН и флагу активности
     *
     * @param name, inn, isActive
     * @return
     */
    List<Organization> findByAttributes (String name, String inn, Boolean isActive);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);

}
