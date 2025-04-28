package com.carrijo.hexagonal.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCPF;

    public Customer () {
        this.isValidCPF = false;
    }

    public Customer (String id,String name,Address address,String cpf,Boolean isValidCPF) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCPF = isValidCPF;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Address getAdress () {
        return address;
    }

    public void setAdress (Address address) {
        this.address = address;
    }

    public String getCpf () {
        return cpf;
    }

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCPF () {
        return isValidCPF;
    }

    public void setValidCPF (Boolean validCPF) {
        isValidCPF = validCPF;
    }
}
