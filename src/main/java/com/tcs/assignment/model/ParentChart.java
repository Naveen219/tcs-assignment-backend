package com.tcs.assignment.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class ParentChart {
    public List<String> labels;
    public List<DataSet> dataSet;


    public ParentChart(List<String> labels, List<DataSet> dataSet) {
        this.labels = labels;
        this.dataSet = dataSet;
    }

    public ParentChart() {

    }


    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<DataSet> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<DataSet> dataSet) {
        this.dataSet = dataSet;
    }
    @Override
    public String toString() {
        return "PieChart{" +
                "labels=" + labels +
                ", dataSet=" + dataSet +
                '}';
    }

}
