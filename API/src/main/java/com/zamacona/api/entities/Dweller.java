package com.zamacona.api.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dweller {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer dwellerNumber;

    private String name;

    private String lastName;

    private Integer houseHoldMembers;

    private Boolean includeAll;

    private String birthDate;

    private String email;

    private String vaultLocation;

    private Integer vaultNumber;

    private Boolean isCommie;

}
