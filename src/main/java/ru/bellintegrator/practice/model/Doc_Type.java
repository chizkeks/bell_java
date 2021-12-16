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

@Entity(name = "Doc_Type")
public class Doc_Type {

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
     * Связь типа документа с документом
     */
    @OneToMany(mappedBy ="documentType",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Document> documents;

    /**
     * Конструктор для hibernate
     */
    public Doc_Type() {

    }

    public Integer getCode() { return code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Set<Document> getDocuments() {
        if (documents == null) {
            documents = new HashSet<>();
        }
        return documents;
    }

    public void seDocuments(Set<Person> persons) { this.documents = documents; }

    public void addDocument(Document document) {
        getDocuments().add(document);
        document.setDocumentType(this);
    }

    public void removeDocument(Document document) {
        getDocuments().remove(document);
        document.setDocumentType(null);
    }
}
