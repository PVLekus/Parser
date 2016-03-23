package org.leks.impl;

import org.leks.interfaces.CargoFilter;

/**
 * Created by lekus on 23.03.16.
 */
public class CargoFilterImpl implements CargoFilter {
    //поле ниже проверить на необходимость
    private String hiddenField = ";;AjaxControlToolkit, Version=3.5.40412.0, Culture=neutral, PublicKeyToken=28f01b0e84b6d53e:ru-RU:1547e793-5b7e-48fe-8490-03a375b13a33:e4031945:475a4ef5:effe2a26:3ac3e789";
    private String state="";
    private String eventTarget="";
    private String eventArgument="";


    private String fromGeo="";
    private String fromGeoRadius="";
    private String toGeo="";
    private String toGeoRadius="";

    private int weightFrom=0;
    private int weightTo=0;
    private int volumeFrom=0;
    private int volumeTo=0;

    private int carTypes=0;
    private int loadTypes=0;

    private int firstDateDay=0;
    private int firstDateMonth=0; //0-6
    private int lastDateDay=0;
    private int lastDateMonth=0; //0-6

    private int sortingTypes=1;
    private int changeDate=3;

    public String getFromGeo() {
        return fromGeo;
    }

    public void setFromGeo(String fromGeo) {
        this.fromGeo = fromGeo;
    }

    //do to String from int like weight
    public String getFromGeoRadius() {
        return fromGeoRadius;
    }

    public void setFromGeoRadius(String fromGeoRadius) {
        this.fromGeoRadius = fromGeoRadius;
    }

    public String getToGeo() {
        return toGeo;
    }

    public void setToGeo(String toGeo) {
        this.toGeo = toGeo;
    }

    public String getToGeoRadius() {
        return toGeoRadius;
    }

    public void setToGeoRadius(String toGeoRadius) {
        this.toGeoRadius = toGeoRadius;
    }

    //Сделать тест
    public String getWeightFrom() {
        String weight="";
        if (weightFrom == 0) weight = "";
        else weight+=weightFrom;
        return weight;
    }

    public void setWeightFrom(int weightFrom) {
        try {
            if (weightFrom<0) this.weightFrom = 0;
            else this.weightFrom = weightFrom;
        } catch (Exception e) {
            this.weightFrom = 0;
        }
    }

    //Сделать тест
    public String getWeightTo() {
        String weight="";
        if (weightTo == 0) weight = "";
        else weight+=weightTo;
        return weight;
    }

    public void setWeightTo(int weightTo) {
        this.weightTo = weightTo;
    }

    //do test
    public String getVolumeFrom() {
        String value="";
        if (volumeFrom == 0) value="";
        else value+= volumeFrom;
        return value;
    }

    public void setVolumeFrom(int volumeFrom) {
        this.volumeFrom = volumeFrom;
    }

    //do test
    public String getVolumeTo() {
        String value="";
        if (volumeTo == 0) value="";
        else value+= volumeTo;
        return value;
    }

    public void setVolumeTo(int volumeTo) {
        this.volumeTo = volumeTo;
    }

    //do test
    public String getCarTypes() {
        return String.valueOf(carTypes);
    }

    public void setCarTypes(int carTypes) {
        this.carTypes = carTypes;
    }

    //do test
    public String getLoadTypes() {
        return String.valueOf(loadTypes);
    }

    public void setLoadTypes(int loadTypes) {
        this.loadTypes = loadTypes;
    }

    //do test
    public String getFirstDateDay() {
        String day="";
        if (firstDateDay == 0) day="";
        else day+=firstDateDay;
        return day;
    }

    public void setFirstDateDay(int firstDateDay) {
        this.firstDateDay = firstDateDay;
    }

    //do test
    public String getFirstDateMonth() {
        return String.valueOf(firstDateMonth);
    }

    public void setFirstDateMonth(int firstDateMonth) {
        this.firstDateMonth = firstDateMonth;
    }

    //do test
    public String getLastDateDay() {
        String day="";
        if (lastDateDay == 0) day="";
        else day+=lastDateDay;
        return day;
    }

    public void setLastDateDay(int lastDateDay) {
        this.lastDateDay = lastDateDay;
    }

    //do test
    public String getLastDateMonth() {
        return String.valueOf(lastDateMonth);
    }

    public void setLastDateMonth(int lastDateMonth) {
        this.lastDateMonth = lastDateMonth;
    }

    //do test
    public String getSortingTypes() {
        return String.valueOf(sortingTypes);
    }

    public void setSortingTypes(int sortingTypes) {
        this.sortingTypes = sortingTypes;
    }

    //do test
    public String getChangeDate() {
        return String.valueOf(changeDate);
    }

    public void setChangeDate(int changeDate) {
        this.changeDate = changeDate;
    }

    public String getHiddenField() {
        return hiddenField;
    }

    public String getState() {
        return state;
    }

    public String getEventTarget() {
        return eventTarget;
    }

    public String getEventArgument() {
        return eventArgument;
    }

    public void setState(String state) {
        this.state = state;
    }
}
