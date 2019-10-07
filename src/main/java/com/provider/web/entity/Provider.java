package com.provider.web.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Provider")
@Data


public class Provider implements Serializable {
    @Id
    @NotNull
    private long id;

    @NotBlank
    private String providerId;

    @NotBlank
    private String firtsName;

    @NotBlank
    private String secondName;

    @NotNull
    private int yearsExperience;

    @NotBlank
    private String bankAccount;

    private String updateDate;

    @NotBlank
    private String email;

    @NotBlank
    private  String address;

    @NotBlank
    private  String country;

    @NotBlank
    private  String cellphone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Provider() {
    }

    public Provider(@NotNull long id, @NotBlank String providerId, @NotBlank String firtsName, @NotBlank String secondName, @NotNull int yearsExperience, @NotBlank String bankAccount, String updateDate, @NotBlank String email, @NotBlank String address, @NotBlank String country, @NotBlank String cellphone) {
        this.id = id;
        this.providerId = providerId;
        this.firtsName = firtsName;
        this.secondName = secondName;
        this.yearsExperience = yearsExperience;
        this.bankAccount = bankAccount;
        this.updateDate = updateDate;
        this.email = email;
        this.address = address;
        this.country = country;
        this.cellphone = cellphone;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
