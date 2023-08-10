package com.bs.java.playground;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class InputSentize {

    public static void main(String[] args) {
        Map<String, Object> request = new HashMap<>();
        request.put("requestId", "abc'");
        request.put("serviceId", 123);
        request.put("array", Arrays.asList("test111''", "brain", 123));

        Map<String, Object> subChild = new HashMap<>();
        subChild.put("child`", "abc'");
        subChild.put("child2", 123);
        subChild.put("child3", Arrays.asList("test111''", "brain", 123));
        subChild.put("mapChild", new HashMap<>(){{
            put("mapSubChild", Arrays.asList("test111''", "brain", 123));
            put("mapSubChild1", "lskdfj23423''");
        }});
        request.put("map", subChild);
        Map<String, Object> process = process(request);
        System.out.println(request);
        System.out.println(process);


    }

    private static Map<String, Object> process(Map<String, Object> map) {
        map.forEach((k, v) -> {
            if (v instanceof List) {
                List<Object> list = (List<Object>) v;
                List<Object> result = new ArrayList<>();
                list.forEach(l -> {
                    Object re;
                    if (l instanceof String) {
                        re = escapeSql((String) l);
                    } else if (l instanceof Map) {
                        re = process((Map<String, Object>) l);
                    } else {
                        re = l;
                    }
                    result.add(re);
                });
                map.put(k, result);
            } else if (v instanceof String) {
                map.put(k, escapeSql((String) v));
            } else if (v instanceof Map) {
                var result = process((Map<String, Object>) v);
                map.put(k, result);
            }
        });
        return map;
    }

    public static String escapeSql(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.replace(str, "'", "''");
    }


}
