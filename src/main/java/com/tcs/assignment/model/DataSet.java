package com.tcs.assignment.model;

import java.util.List;

public class DataSet {
    private String label;
    private List<Double> data;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private Integer hoverOffset;

    public DataSet(String label, List<Double> data, List<String> backgroundColor, List<String> borderColor, Integer hoverOffset) {
        this.label = label;
        this.data = data;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.hoverOffset = hoverOffset;
    }

    public DataSet() {

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public List<String> getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(List<String> backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    public List<String> getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(List<String> borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getHoverOffset() {
        return hoverOffset;
    }

    public void setHoverOffset(Integer hoverOffset) {
        this.hoverOffset = hoverOffset;
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "label='" + label + '\'' +
                ", data=" + data +
                ", backgroundColor=" + backgroundColor +
                ", borderColor=" + borderColor +
                ", hoverOffset=" + hoverOffset +
                '}';
    }
}
