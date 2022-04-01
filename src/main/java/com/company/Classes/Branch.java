package com.company.Classes;

public final class Branch {
    private String name;
    private Address address;
    private String phone;
    private Employee head;

    public Branch() {}

    public Branch(String name, Address address, String phone, Employee head) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", address=" + address.toString() +
                ", phone='" + phone + '\'' +
                ", head=" + head.toString() +
                '}';
    }
}
