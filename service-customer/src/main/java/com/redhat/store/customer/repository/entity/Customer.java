package com.redhat.store.customer.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The numberID (a.k.a. DNI) should no be null")
    @Size( min = 8 , max = 8, message = "The numberID needs to be size of 8")
    @Column(name = "number_id" , unique = true ,length = 8, nullable = false)
    private String numberID;

    @NotEmpty(message = "The name shouldn't be null")
    @Column(name="first_name", nullable=false)
    private String firstName;

    @NotEmpty(message = "The last_name shouldn't be null")
    @Column(name="last_name", nullable=false)
    private String lastName;

    @NotEmpty(message = "The email shouldn't be null")
    @Email(message = "It's not a well formed email address")
    @Column(unique=true, nullable=false)
    private String email;

    @Column(name="photo_url")
    private String photoUrl;


    @NotNull(message = "The region_id shouldn't be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Region region;

    private String state;
}
