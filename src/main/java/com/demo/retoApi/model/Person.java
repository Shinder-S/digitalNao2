package com.demo.retoApi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String id;
    private String url;
    private Integer results;
    private String affiliationName;
    private String affiliationCity;
    private String affiliationCountry;

}
