package com.psykey.psykeyapirest.repository.model.user;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "dni", nullable = false)
    private String dni;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "province", nullable = false)
    private String province;

    @NotNull
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @NotNull
    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "patient_relationship")
    private String patientRelationship;
    
    @Column(name = "reason")
    private String reason;
    
    @Column(name = "therapy_type")
    private String therapyType;
    
    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client", referencedColumnName = "id")
    private User client;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee", referencedColumnName = "id")
    private User employee;

    @Column(name = "username")
    private String username;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(final String dni) {
        this.dni = dni;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(final String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

    public String getPatientRelationship() {
        return this.patientRelationship;
    }

    public void setPatientRelationship(final String patientRelationship) {
        this.patientRelationship = patientRelationship;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public String getTherapyType() {
        return this.therapyType;
    }

    public void setTherapyType(final String therapyType) {
        this.therapyType = therapyType;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public User getClient() {
        return this.client;
    }

    public void setClient(final User client) {
        this.client = client;
    }

    public User getEmployee() {
        return this.employee;
    }

    public void setEmployee(final User employee) {
        this.employee = employee;
    }

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(final String username) {
		this.username = username;
	}
}
