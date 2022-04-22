package com.skcc.tes.mypage.vo;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipcode;
}
