package com.provider.web.entity;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Provider")
@Data

@ApiModel(description = "Details about Provider entity. ")
public class Provider implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotBlank
    private String providerId;

    @NotBlank
    @Size(min = 1, max = 128, message = "firstName must be between 1 and 128 characters")
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 128, message = "secondName must be between 1 and 128 characters")
    private String secondName;

    @NotNull
    @DecimalMin(value = "0.0", message = "yearsExperience must be greater than 0")
    private Double yearsExperience;

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


    public Provider(@NotNull String id, @NotBlank String providerId, @NotBlank String firstName, @NotBlank String secondName, @NotNull Double yearsExperience, @NotBlank String bankAccount, String updateDate, @NotBlank String email, @NotBlank String address, @NotBlank String country, @NotBlank String cellphone) {
        this.id = id;
        this.providerId = providerId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.yearsExperience = yearsExperience;
        this.bankAccount = bankAccount;
        this.updateDate = updateDate;
        this.email = email;
        this.address = address;
        this.country = country;
        this.cellphone = cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Double getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Double yearsExperience) {
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

    @Override
    public String toString() {
        return "Provider{" +
                "id='" + id + '\'' +
                ", providerId='" + providerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", bankAccount='" + bankAccount + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
