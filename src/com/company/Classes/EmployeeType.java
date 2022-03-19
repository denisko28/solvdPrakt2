package com.company.Classes;

public class EmployeeType {
    private String position;
    private String responsibility;

    public EmployeeType() {}

    public EmployeeType(String position, String responsibility) {
        this.position = position;
        this.responsibility = responsibility;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getResponsibility() {
        return responsibility;
    }
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public String toString() {
        return "EmployeeType{" +
                "position='" + position + '\'' +
                ", responsibility='" + responsibility + '\'' +
                '}';
    }
}
