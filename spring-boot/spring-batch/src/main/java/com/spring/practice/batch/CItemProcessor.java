package com.spring.practice.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CItemProcessor implements ItemProcessor<CountryData, CountryData> {

    private final Random random;

    public CItemProcessor() {
        this.random = new Random();
    }

    @Override
    public CountryData process(CountryData item) {
        if (item.getRange().contains("+")) {
            int min = Integer.parseInt(item.getRange().substring(0, item.getRange().length() - 1));
            return setEmployee(item, min, 50000);
        } else if (item.getRange().contains("employee")) {
            return setEmployee(item, 0, 1);
        }
        String[] split = item.getRange().split("-");
        int min = Integer.parseInt(split[0].trim());
        int max = Integer.parseInt(split[1].trim());
        return setEmployee(item, min, max);
    }

    CountryData setEmployee(CountryData item, int min, int max) {
        int noOfEmployee = random(max, min);
        int noOfEstEmployee = random(max, min);
        if (item.getNoOfEmployee() == 0)
            item.setNoOfEmployee(noOfEmployee);
        if (item.getEstNoOfEmployee() == 0)
            item.setEstNoOfEmployee(noOfEstEmployee);
        return item;
    }

    int random(int max, int min) {
        return random.nextInt(max - min + 1) + min;
    }

}
