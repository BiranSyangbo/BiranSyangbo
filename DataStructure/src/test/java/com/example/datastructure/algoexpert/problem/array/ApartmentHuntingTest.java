package com.example.datastructure.algoexpert.problem.array;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class ApartmentHuntingTest {
    @Test
    public void TestCase1() {
        List<Map<String, Boolean>> blocks = new ArrayList<>();

        blocks.add(0, new HashMap<>());
        blocks.get(0).put("gym", false);
        blocks.get(0).put("school", true);
        blocks.get(0).put("store", false);

        blocks.add(1, new HashMap<>());
        blocks.get(1).put("gym", true);
        blocks.get(1).put("school", false);
        blocks.get(1).put("store", false);

        blocks.add(2, new HashMap<>());
        blocks.get(2).put("gym", true);
        blocks.get(2).put("school", true);
        blocks.get(2).put("store", false);

        blocks.add(3, new HashMap<>());
        blocks.get(3).put("gym", false);
        blocks.get(3).put("school", true);
        blocks.get(3).put("store", false);

        blocks.add(4, new HashMap<>());
        blocks.get(4).put("gym", false);
        blocks.get(4).put("school", true);
        blocks.get(4).put("store", true);

        String[] reqs = new String[]{"gym", "school", "store"};
        assertEquals(3, ApartmentHunting.apartmentHunting(blocks, reqs));
    }

    @Test
    void testCase2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List> apartment = objectMapper.readValue(testCase2, new TypeReference<>() {
        });

        List get = apartment.get("reqs");
        String[] str = new String[get.size()];
        for (int i = 0, getSize = get.size(); i < getSize; i++) {
            str[i] = String.valueOf(get.get(i));
        }

        final List<Map<String, Boolean>> bocks = apartment.get("blocks");
        List<Map<String, Boolean>> blocks = bocks.stream()
                .map(bock -> bock.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b)))
                .collect(Collectors.toList());

        assertEquals(2, ApartmentHunting.apartmentHunting(blocks, str));
    }

    static String testCase2 = """
            {
              "blocks": [
                {
                  "gym": false,
                  "office": true,
                  "school": true,
                  "store": false
                },
                {
                  "gym": true,
                  "office": false,
                  "school": false,
                  "store": false
                },
                {
                  "gym": true,
                  "office": false,
                  "school": true,
                  "store": false
                },
                {
                  "gym": false,
                  "office": false,
                  "school": true,
                  "store": false
                },
                {
                  "gym": false,
                  "office": false,
                  "school": true,
                  "store": true
                }
              ],
              "reqs": ["gym", "office", "school", "store"]
            }
            """;
}