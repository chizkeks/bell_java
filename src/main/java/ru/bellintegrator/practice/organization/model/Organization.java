package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.model.Office;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Organization")
public class Organization {
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
     * Полное имя
     */
    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 12)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 9)
    private String kpp;

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
     * Связь организации с офисом
     */
    @OneToMany(
            mappedBy = "organization",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Office> offices;

    /**
     * Конструктор для hibernate
     */
    public Organization() {

    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getInn() { return inn; }

    public void setInn(String inn) { this.inn = inn; }

    public String getKpp() { return kpp; }

    public void setKpp(String kpp) { this.kpp = kpp; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }

    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void setOffices(Set<Office> offices) { this.offices = offices; }

    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.setOrganization(null);
    }

}
