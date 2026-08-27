package com.codingshuttle.razorpay.merchant.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    private String name;

    private String email;

    private String contactNumber;

    private LocalDateTime deletedAt;

}
