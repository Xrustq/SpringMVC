package com.epam.shop.less.shop.entity;

import javax.persistence.*;
import java.util.Set;

// https://stackoverflow.com/questions/37970743/unique-violation-7-error-duplicate-key-value-violates-unique-constraint-users/37972960

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_basket", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "basket_id"))
//    private Set<Basket> basket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

//    public Set<Basket> getBasket() {
//        return basket;
//    }
//
//    public void setBasket(Set<Basket> basket) {
//        this.basket = basket;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(firstName, user.firstName) &&
//                Objects.equals(lastName, user.lastName) &&
//                Objects.equals(email, user.email) &&
//                Objects.equals(password, user.password) &&
//                Objects.equals(confirmPassword, user.confirmPassword);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(firstName, lastName, email, password, confirmPassword);
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
//                ", roles=" + roles +
//                '}';
//    }
}
