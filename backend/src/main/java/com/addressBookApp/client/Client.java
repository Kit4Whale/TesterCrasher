package com.addressBookApp.client;

public class Client {
    private Integer id;
    private String fullname;
    private String address;
    private String email;
    private String phone_number;
    private String group;

    public Client() {
    }

    public Client(Integer id,
                  String fullname,
                  String address,
                  String email,
                  String phone_number,
                  String group) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
