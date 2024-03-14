package com.example.contactapp.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "CONTACT_DETAILS")
public class Contact {
    @Id
    @GeneratedValue
    @Column(name = "CONTACT_ID")
    private Integer contactId;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    @Column(name = "CONTACT_NUMBER")
    private Long contactNumber;
    @Column(name = "CREATE_DATE",updatable = false)
    @CreationTimestamp
    private LocalDate createDate;
    @Column(name = "UPDATE_DATE", insertable = false)
    @UpdateTimestamp
    private LocalDate updateDate;
    @Column(name = "ACTIVE_SW")
    public String activeSw;
}
