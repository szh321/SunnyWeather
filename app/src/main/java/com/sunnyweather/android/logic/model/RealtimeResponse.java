package com.sunnyweather.android.logic.model;

import com.google.gson.annotations.SerializedName;

import javax.xml.transform.Result;

public class RealtimeResponse {
    public String status;
    public Result result;
    public static  class Result {
        public  Realtime realtime;

    }

    public static  class AirQuality {
        public AQI aqi;
    }

    public static  class AQI {
        public Float chn;
    }

    public static class Realtime {
        public String skycon;
        public Float temperature;
        @SerializedName("air_quality")
        public AirQuality airQuality;
    }
}
