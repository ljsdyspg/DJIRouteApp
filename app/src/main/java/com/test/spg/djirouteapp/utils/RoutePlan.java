package com.test.spg.djirouteapp.utils;

import java.util.ArrayList;

public class RoutePlan {


    public static int N = 10000;
    public static double h;
    public static double H;
    public static double width;
    public static double length;
    public static double Width;
    public static double Length;

    public static double SO;
    public static double LO;

    public static ArrayList RoutePlanning(Point[] points, double n, double so, double lo){
        SO = so;
        LO = lo;
        Point[] res_points = new Point[2];

        res_points[0].X = points[0].X;
        res_points[0].Y = points[0].Y;
        res_points[1].X = points[0].X;
        res_points[1].Y = points[0].Y;

        int j,i = 0;
        for ( i = 0; i < n; i++) {
            if (points[i].X < res_points[0].X){
                res_points[0].X = points[i].X;
            }
            if (points[i].Y < res_points[0].Y){
                res_points[0].Y = points[0].Y;
            }
            if (points[i].X > res_points[0].X) {
                res_points[1].X = points[i].X;
            }
            if (points[i].Y > res_points[0].Y) {
                res_points[1].Y = points[i].Y;
            }
        }
        //将相片大小放大到实地
        Width = width*H/h;
        Length = length*H/h;

        //考虑重叠度，计算点间距
        Width = Width*(1-SO);
        Length = Length*(1-LO);

        Point[][] fly_points = new Point[N][N];
        ArrayList RoutePoints = new ArrayList();

        for (j = 0; j < N; j++)
        {
            if (fly_points[j][i].X < res_points[1].X + Width)
            {
                fly_points[j][i].X = res_points[0].X + j * Width;
                for (i = 0; i < N; i++)
                {
                    if (fly_points[j][i].Y < res_points[1].Y + Length)
                    {
                        fly_points[j][i].Y = res_points[0].Y + i * Length;
                    }
                }
            }
            RoutePoints.add(fly_points[j][i]);
        }
        return RoutePoints;
    }
}
