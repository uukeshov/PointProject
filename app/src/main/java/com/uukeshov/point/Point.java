package com.uukeshov.point;

/**
 * Created by uukeshov on 3/17/2016.
 */
public class Point {

    int _pointID;
    String _pointName;
    Double _pointLon;
    Double _pointLat;

    public Point() {
    }

    public Point(int pointID, Double pointLat, Double pointLon, String pointName) {
        this._pointID = pointID;
        this._pointLat = pointLat;
        this._pointLon = pointLon;
        this._pointName = pointName;
    }

    public Point(String pointId,String pointName, String pointLat, String pointLon) {
        this._pointID = Integer.parseInt(pointId);
        this._pointLat = Double.parseDouble(pointLat);
        this._pointLon = Double.parseDouble(pointLon);
        this._pointName = pointName;
    }


    public int get_pointID() {
        return _pointID;
    }

    public void set_pointID(int _pointID) {
        this._pointID = _pointID;
    }

    public String get_pointName() {
        return _pointName;
    }

    public void set_pointName(String _pointName) {
        this._pointName = _pointName;
    }

    public Double get_pointLon() {
        return _pointLon;
    }

    public void set_pointLon(Double _pointLon) {
        this._pointLon = _pointLon;
    }

    public Double get_pointLat() {
        return _pointLat;
    }

    public void set_pointLat(Double _pointLat) {
        this._pointLat = _pointLat;
    }


    @Override
    public String toString() {
        return "Point{" +
                "_pointID=" + _pointID +
                ", _pointName='" + _pointName + '\'' +
                ", _pointLon=" + _pointLon +
                ", _pointLat=" + _pointLat +
                '}';
    }
}
