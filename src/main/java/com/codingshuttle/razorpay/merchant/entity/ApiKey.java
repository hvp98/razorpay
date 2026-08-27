package com.codingshuttle.razorpay.merchant.entity;
import com.codingshuttle.razorpay.common.enums.Environment;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "api_key")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(unique = true, nullable = false, length = 50)
    private String keyId;

    @Column(nullable = false, length = 50)
    private String keySecretHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Environment environment;

    @Column(nullable = false)
    private boolean enabled = true;


    private java.time.LocalDateTime lastUsedAt;
    private java.time.LocalDateTime rotatedAt;
    private java.time.LocalDateTime gracePeriodExpiresAt;


}
