
package com.smartparking.config;

import java.math.BigDecimal;

public final class ParkingRules {

    private ParkingRules() {
        // Prevent object creation.
    }

    public static final BigDecimal CAR_HOURLY_RATE =
            new BigDecimal("40.00");

    public static final BigDecimal BIKE_HOURLY_RATE =
            new BigDecimal("20.00");

    public static final BigDecimal EV_HOURLY_RATE =
            new BigDecimal("50.00");

    public static final BigDecimal CAR_OVERSTAY_RATE =
            new BigDecimal("60.00");

    public static final int MAX_ADVANCE_BOOKING_DAYS = 7;

    public static final int AVAILABILITY_REFRESH_SECONDS = 10;

    public static final int MIN_BOOKING_DURATION_MINUTES = 30;
}
