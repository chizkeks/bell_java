package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id){
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o WHERE o.id = :id", Organization.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Organization> findByAttributes (String name, String inn, Boolean isActive) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);

        Predicate predicate
                = criteriaBuilder.equal(organizationRoot.get("name"), name);
        if(inn!=null && inn.equals("")) {
            Predicate predicateInn
                    = criteriaBuilder.equal(organizationRoot.get("inn"), inn);
            predicate
                    = criteriaBuilder.and(predicate, predicateInn);
        }
        if(isActive!=null) {
            Predicate predicateIsActive
                    = criteriaBuilder.equal(organizationRoot.get("is_active"), isActive);
            predicate
                    = criteriaBuilder.and(predicate, predicateIsActive);
        }

        criteriaQuery.where(predicate);
        return em.createQuery(criteriaQuery).getResultList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

}
