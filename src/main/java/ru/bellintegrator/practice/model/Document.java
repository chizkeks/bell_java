package ru.bellintegrator.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity(name = "Document")
public class Document {
    @Id
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctype_id")
    private Doc_Type documentType;

    @Column(name = "number")
    private String number;

    @Column(name = "issue_date")
    private Date issueDate;

    /**
     * Связь документа с пользователем
     */
    @OneToOne(mappedBy ="document", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, optional = false)
    private Person person;


    public Long getId() { return id; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public Date getIssueDate() { return issueDate; }

    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    public Doc_Type getDocumentType() { return documentType; }

    public void setDocumentType(Doc_Type documentType) { this.documentType = documentType; }

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }
}
