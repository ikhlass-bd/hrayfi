package com.hrayfiproject.hrayfi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Hrayfi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHrayfi;
    @NotNull
    @Size(min = 3,max = 20)

    private String nameHrayfi;
    
    public String profession;
    private String adresse;

    private String telephone;


    public Long getIdHrayfi() {
        return idHrayfi;
    }

    public void setIdHrayfi(Long idHrayfi) {
        this.idHrayfi = idHrayfi;
    }

    public String getNameHrayfi() {
        return nameHrayfi;
    }

    public void setNameHrayfi(String nameHrayfi) {
        this.nameHrayfi = nameHrayfi;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Hrayfi() {
        super();
    }

    @Override
    public String toString() {
        return "Hrayfi{" +
                "idHrayfi=" + idHrayfi +
                ", nameHrayfi='" + nameHrayfi + '\'' +
                ", profession='" + profession + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Hrayfi(Long idHrayfi, String nameHrayfi, String profession, String adresse, String telephone) {
        this.idHrayfi = idHrayfi;
        this.nameHrayfi = nameHrayfi;
        this.profession = profession;
        this.adresse = adresse;
        this.telephone = telephone;
    }
}


