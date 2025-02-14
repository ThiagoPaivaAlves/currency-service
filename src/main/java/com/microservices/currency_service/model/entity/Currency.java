package com.microservices.currency_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "currency")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Currency {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="from_currency", nullable = false, length = 3)
    private String from;
    
    @Column(name="to_currency", nullable = false, length = 3 )
    private String to;
    
    @Column(name="conversion_factor", nullable = false)
    private BigDecimal conversionFactor;

}
