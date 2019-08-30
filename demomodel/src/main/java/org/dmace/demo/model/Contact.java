package org.dmace.demo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {

    private Long id;
    private String name;
    private String lastName;
    private String fullname;
    private String group;
    private LocalDate dob;
    private String phone;
    private String email;
    private String address;
    private String comments;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public String getName() { return name; }

    public String getFullname() {
        return fullname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }
//        contact.setGroup;
    public LocalDate getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getComments() {
        return comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(fullname, contact.fullname) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(group, contact.group) &&
                Objects.equals(dob, contact.dob) &&
                Objects.equals(phone, contact.phone) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(comments, contact.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, lastName, group, dob, phone, email, address, comments);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
