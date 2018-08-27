package com.yarikwest.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "families")
@Getter
@Setter
public class Family extends BaseEntity {

    @OneToOne(mappedBy = "family")
    @JsonIgnore
    private Father father;

    @OneToMany(mappedBy = "family")
    @JsonIgnore
    private List<Child> children = new ArrayList<>();
}
