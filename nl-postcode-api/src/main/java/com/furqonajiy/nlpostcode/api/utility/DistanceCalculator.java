package com.furqonajiy.nlpostcode.api.utility;

import org.springframework.stereotype.Component;

@Component
public class DistanceCalculator {
    private final static double EARTH_RADIUS = 6371; // radius in kilometers

    public Double calculateDistance(double latitude, double longitude,
                                     double latitude2, double longitude2
    ) {
        // Using Haversine formula. See Wikipedia.
        double lon1Radians = Math.toRadians(longitude);
        double lon2Radians = Math.toRadians(longitude2);
        double lat1Radians = Math.toRadians(latitude);
        double lat2Radians = Math.toRadians(latitude2);

        double a = haversine(lat1Radians, lat2Radians) + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (EARTH_RADIUS * c);
    }

    private double haversine(double degree1, double degree2) {
        return square(Math.sin((degree1 - degree2) / 2.0));
    }

    private double square(double x) {
        return x * x;
    }
}
