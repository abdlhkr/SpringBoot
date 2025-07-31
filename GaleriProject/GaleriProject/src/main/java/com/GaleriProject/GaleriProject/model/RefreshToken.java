package com.GaleriProject.GaleriProject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseEntity{

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @ManyToOne // bi kullanıcınıın birden fazla
    // refresh tokeni olabilir
    private User user;
}
