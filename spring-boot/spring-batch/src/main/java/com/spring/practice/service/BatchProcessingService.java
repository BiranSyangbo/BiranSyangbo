package com.spring.practice.service;

import org.springframework.batch.core.BatchStatus;

public interface BatchProcessingService {

    BatchStatus loadDataFromCsvToDB();

    BatchStatus transferDBDataToES();
}
