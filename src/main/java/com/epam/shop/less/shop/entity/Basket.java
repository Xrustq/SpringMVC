//package com.epam.shop.less.shop.entity;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "basket")
//public class Basket {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "basket_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @ManyToMany(mappedBy = "basket")
//    private Set<User> users;
//
////    @ManyToMany
////    @JoinColumn(name = "product_id")
////    private User user;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//}
