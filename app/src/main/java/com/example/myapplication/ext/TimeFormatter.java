package com.example.myapplication.ext;


import android.text.format.DateUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeFormatter{

    SimpleDateFormat reportTime =new SimpleDateFormat("MMM dd, yyy", Locale.getDefault());

    public String getReportTime(Long millis) {
        return reportTime.format(millis);
    }


}