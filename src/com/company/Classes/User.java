package com.company.Classes;

import java.util.Date;

public abstract class User extends Person {
    private String phone;
    private String email;
    private Date registerDate;
    private String login;
    private String password;

    public User() {}

    public User(String phone, String email, Date registerDate, String login, String password, String firstName,
                String lastName, String patronymic ) {
        super(firstName, lastName, patronymic);
        this.phone = phone;
        this.email = email;
        this.registerDate = registerDate;
        this.login = login;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void sendMessage();

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate.toString() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                super.toString() +
                '}';
    }
}
