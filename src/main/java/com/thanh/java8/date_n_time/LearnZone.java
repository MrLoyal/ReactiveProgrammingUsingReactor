package com.thanh.java8.date_n_time;

import java.time.ZoneId;
import java.util.Set;

public class LearnZone {
    public static void main(String[] args) {
        ZoneId myZoneId = ZoneId.systemDefault();
        System.out.println(myZoneId);


        Set<String> zoneIdSet = ZoneId.getAvailableZoneIds();
        System.out.println("Available zone IDs:");
        for (String zoneIdName: zoneIdSet){
            System.out.println("  " + zoneIdName);
        }


        ZoneId tokyo = ZoneId.of("Asia/Tokyo");

    }
}
