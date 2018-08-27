package com.yarikwest.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "children")
@Getter
@Setter
public class Child extends BaseEntity {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "birthDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "sex")
    private String sex;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "familyId")
    private Family family;

}
