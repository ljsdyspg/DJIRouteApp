package com.test.spg.djirouteapp;

import java.util.ArrayList;

public class WaypointCoord {
    static int size = 100;
    static float altitude = 3.0f;
    static float speed = 1.0f;
    static double[] coord= new double[size];
    static ArrayList coords = new ArrayList();


    public static void initWayPoint() {
        double[] temp;
        coords.clear();
        coords.add(new double[]{30.5303652900,114.3555823600});
        coords.add(new double[]{30.5303602900,114.3559153600});
        coords.add(new double[]{30.5301992900,114.3559583600});
        coords.add(new double[]{30.5302032900,114.3556093600});
    }
}
