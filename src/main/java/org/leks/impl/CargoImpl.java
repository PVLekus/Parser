package org.leks.impl;

import org.leks.interfaces.Cargo;

/**
 * Created by mb on 28.03.16.
 */
public class CargoImpl implements Cargo {

    private String id;

    private String advDate;
    private String advChangeDate;

    private String way;
    private String allWay;

    private  String lblFrom;
    private  String lblFromRegion;
    private  String lblFromDistance;

    private  String lblTo;
    private  String lblToRegion;
    private  String lblToDistance;

    private String cargoParam;
    private String cargoType;

    private  String wayDate;
    private  String carType;
    private  String carLoading;

    private String loadPrice;
    private String loadPriceWhithNds;
    private String loadPriceWhithoutNds;
    private String lblPrePay;
    private String lblPayDay;
    private String lblDirectDog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvDate() {
        return advDate;
    }

    public void setAdvDate(String advDate) {
        this.advDate = advDate;
    }

    public String getAdvChangeDate() {
        return advChangeDate;
    }

    public void setAdvChangeDate(String advChangeDate) {
        this.advChangeDate = advChangeDate;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getAllWay() {
        return allWay;
    }

    public void setAllWay(String allWay) {
        this.allWay = allWay;
    }

    public String getLblFrom() {
        return lblFrom;
    }

    public void setLblFrom(String lblFrom) {
        this.lblFrom = lblFrom;
    }

    public String getLblFromRegion() {
        return lblFromRegion;
    }

    public void setLblFromRegion(String lblFromRegion) {
        this.lblFromRegion = lblFromRegion;
    }

    public String getLblFromDistance() {
        return lblFromDistance;
    }

    public void setLblFromDistance(String lblFromDistance) {
        this.lblFromDistance = lblFromDistance;
    }

    public String getLblTo() {
        return lblTo;
    }

    public void setLblTo(String lblTo) {
        this.lblTo = lblTo;
    }

    public String getLblToRegion() {
        return lblToRegion;
    }

    public void setLblToRegion(String lblToRegion) {
        this.lblToRegion = lblToRegion;
    }

    public String getLblToDistance() {
        return lblToDistance;
    }

    public void setLblToDistance(String lblToDistance) {
        this.lblToDistance = lblToDistance;
    }

    public String getCargoParam() {
        return cargoParam;
    }

    public void setCargoParam(String cargoParam) {
        this.cargoParam = cargoParam;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getWayDate() {
        return wayDate;
    }

    public void setWayDate(String wayDate) {
        this.wayDate = wayDate;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarLoading() {
        return carLoading;
    }

    public void setCarLoading(String carLoading) {
        this.carLoading = carLoading;
    }

    public String getLoadPrice() {
        return loadPrice;
    }

    public void setLoadPrice(String loadPrice) {
        this.loadPrice = loadPrice;
    }

    public String getLoadPriceWhithNds() {
        return loadPriceWhithNds;
    }

    public void setLoadPriceWhithNds(String loadPriceWhithNds) {
        this.loadPriceWhithNds = loadPriceWhithNds;
    }

    public String getLoadPriceWhithoutNds() {
        return loadPriceWhithoutNds;
    }

    public void setLoadPriceWhithoutNds(String loadPriceWhithoutNds) {
        this.loadPriceWhithoutNds = loadPriceWhithoutNds;
    }

    public String getLblPrePay() {
        return lblPrePay;
    }

    public void setLblPrePay(String lblPrePay) {
        this.lblPrePay = lblPrePay;
    }

    public String getLblPayDay() {
        return lblPayDay;
    }

    public void setLblPayDay(String lblPayDay) {
        this.lblPayDay = lblPayDay;
    }

    public String getLblDirectDog() {
        return lblDirectDog;
    }

    public void setLblDirectDog(String lblDirectDog) {
        this.lblDirectDog = lblDirectDog;
    }
}
