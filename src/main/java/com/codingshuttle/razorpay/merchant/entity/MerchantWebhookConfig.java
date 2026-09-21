package com.codingshuttle.razorpay.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantWebhookConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false, length = 255)
    private String targetUrl;  // The URL to which the webhook notifications will be sent. Ex: www.zara.com/webhook/success

    @Column(length = 255)
    private String WebhookSecretHash;  // A secret hash used to verify the authenticity of incoming webhook requests.

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(length = 255)
    private String eventTypes; // Comma-separated list of event types to subscribe to and receive webhooks for notifications.

}
