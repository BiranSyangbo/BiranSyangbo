package com.spring.practice.es.load.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.practice.batch.CompanyData;

import java.io.Serializable;
import java.util.ArrayList;

public record CompanyEsDto(@JsonProperty("year")int year,@JsonProperty("companyDetails") ArrayList<CompanyData> companyDetails) implements Serializable {
}
