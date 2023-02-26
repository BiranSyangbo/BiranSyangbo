package com.spring.practice.batch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class CountryData {
    private String name;
    private String webSite;
    private String industry;
    private String range;
    private int noOfEmployee;
    private int estNoOfEmployee;
    private String country;
    private String locality;
    private String region;
    private int year;
    private String url;

    public CountryData(String name,
                       String webSite,
                       String industry,
                       String range,
                       int noOfEmployee,
                       int estNoOfEmployee,
                       String country,
                       String locality,
                       String region,
                       int year,
                       String url) {
        this.name = name;
        this.webSite = webSite;
        this.industry = industry;
        this.range = range;
        this.noOfEmployee = noOfEmployee;
        this.estNoOfEmployee = estNoOfEmployee;
        this.country = country;
        this.locality = locality;
        this.region = region;
        this.year = year;
        this.url = url;
    }
}
