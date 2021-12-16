package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;

@Entity(name = "Person")
public class Person {

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
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50)
    private String middleName;

    /**
     * Фамилия
     */
    @Column(name = "surname", length = 50, nullable = false)
    private String surname;

    /**
     * Должность
     */
    @Column(name = "job_title", length = 128)
    private String jobTitle;

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
     * Связь пользователя с гражданством
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Citizenship citezenship;

    /**
     * Связь пользователя с документом
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Document document;

    /**
     * Связь пользователя с офисом
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="office_id")
    private Office office;

    /**
     * Конструктор для hibernate
     */
    public Person() {

    }

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getJobTitle() { return jobTitle; }

    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }

    public Document getDocument() { return document; }

    public void setDocument(Document document) { this.document = document; }

    public Citizenship getCitezenship() { return citezenship; }

    public void setCitezenship(Citizenship citezenship) { this.citezenship = citezenship; }

    public Office getOffice() { return office; }

    public void setOffice(Office office) { this.office = office; }
}
