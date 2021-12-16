package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Citizenship")
public class Citizenship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;

    /**
     * Имя
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * Связь гражданства с пользователем
     */
    @OneToMany(mappedBy ="citezenship",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> persons;

    /**
     * Конструктор для hibernate
     */
    public Citizenship() {

    }

    public Integer getCode() { return code; }

    public void setCode(Integer code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Person> getPersons() {
        if (persons == null) {
            persons = new HashSet<>();
        }
        return persons;
    }

    public void setPersons(Set<Person> persons) { this.persons = persons; }

    public void addPerson(Person person) {
        getPersons().add(person);
        person.setCitezenship(this);
    }

    public void removePerson(Person person) {
        getPersons().remove(person);
        person.setCitezenship(null);
    }
}
