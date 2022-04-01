package com.company.Enumerations;

public enum EmployeeType {
    CEO ("CEO", "general bank management"),
    BranchHead ("Branch head", "branch management"),
    SimpleEmployee ("Simple employee", "accounts opening, new clients registration");

    private final String position;
    private final String responsibility;

    EmployeeType(String position, String responsibility) {
        this.position = position;
        this.responsibility = responsibility;
    }

    public String getPosition() { return position; }

    public String getResponsibility() { return responsibility; }

    @Override
    public String toString() {
        return "EmployeeType{" +
                "position='" + position + '\'' +
                ", responsibility='" + responsibility + '\'' +
                '}';
    }
}