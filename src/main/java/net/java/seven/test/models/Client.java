package net.java.seven.test.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private String name;
    private String surname;
    private String phone;
    private String address;

    @Column(name = "count_opened_line")
    private int countOpenedLine;

    @Column(name = "count_closed_line")
    private int countClosedLine;

    public int getCountOpenedLine() {
        return countOpenedLine;
    }

    public void setCountOpenedLine(int countOpenedLine) {
        this.countOpenedLine = countOpenedLine;
    }

    public int getCountClosedLine() {
        return countClosedLine;
    }

    public void setCountClosedLine(int countClosedLine) {
        this.countClosedLine = countClosedLine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", countOpenedLine=" + countOpenedLine +
                ", countClosedLine=" + countClosedLine +
                '}';
    }
}
