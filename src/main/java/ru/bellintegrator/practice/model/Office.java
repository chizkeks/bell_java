package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address", length = 255)
    private String address;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 15)
    private String phone;

    /**
     * Флаг активности
     */
    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT false", nullable = false)
    private Boolean isActive;

    /**
     * Связь офиса с организацией
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="org_id")
    private Organization organization;

    /**
     * Связь офиса с пользователями
     */
    @OneToMany(
            mappedBy = "office",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Person> persons;

    /**
     * Конструктор для hibernate
     */
    public Office() {

    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }

    public Organization getOrganization() { return organization; }

    public void setOrganization(Organization organization) { this.organization = organization; }

    public Set<Person> getPersons() {
        if (persons == null) {
            persons = new HashSet<>();
        }
        return persons;
    }

    public void setPersons(Set<Person> persons) { this.persons = persons; }

    public void addPerson(Person person) {
        getPersons().add(person);
        person.setOffice(this);
    }

    public void removePerson(Person person) {
        getPersons().remove(person);
        person.setOffice(null);
    }
}
