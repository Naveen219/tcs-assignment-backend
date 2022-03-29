package com.tcs.assignment.controller;

import com.tcs.assignment.model.DataSet;
import com.tcs.assignment.model.ParentChart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ParentChartController {

    @GetMapping("/pie")
    public ResponseEntity<ParentChart> getPieChart() {
        List<String> labels = new ArrayList<>();
        labels.add("Overdue");
        labels.add("Defect");
        labels.add("Damage");
        labels.add("Other");
        List<Double> data = Arrays.asList(31.0, 25.5, 16.9, 26.5);
        List<String> backgroundColors = Arrays.asList("rgb(54, 162, 235)",
                "rgb(3, 255, 5)", "rgb(252, 132, 3)",
                "rgb(252, 3, 48)");
        int hoverOffset = 2;

        List<DataSet> dataSets = new ArrayList<>();
         dataSets.add(new DataSet("pie", data, backgroundColors, null, hoverOffset));

        ParentChart pieChart = new ParentChart(labels, dataSets);
        return ResponseEntity.ok(pieChart);
    }

    @GetMapping("/bar")
    public ResponseEntity<ParentChart> getBarChart() {

        // labels common for both the charts
        List<String> labels = Arrays.asList( "2009FY",
                "2010FY",
                "2011FY",
                "2012FY",
                "2013FY",
                "2014FY",
                "2015FY",
                "2016FY");

        // data pertains to bar chart
        String barLabel = "Turnover";
        List<Double> barData = Arrays.asList(5.2, 5.3, 6.0, 5.0,
                5.5, 6.2, 4.0, 5.2);
        List<String> barBackgroundColors = Arrays.asList(
                "rgba(255, 3, 5, 0.1)",
                "rgba(255, 3, 5, 0.1)",
                "rgba(5, 3, 255, 0.1)",
                "rgba(255, 3, 5, 0.1)",
                "rgba(5, 3, 255, 0.1)",
                "rgba(5, 3, 255, 0.1)",
                "rgba(255, 3, 5, 0.1)",
                "rgba(255, 3, 5, 0.1)"

        );
        List<String> barBorderColors = Arrays.asList(
                "rgba(255, 3, 5, 1)",
                "rgba(255, 3, 5, 1)",
                "rgba(5, 3,  255, 1)",
                "rgba(255, 3, 5, 1)",
                "rgba(5, 3, 255, 1)",
                "rgba(5, 3, 255, 1)",
                "rgba(255, 3, 5, 1)",
                "rgba(255, 3, 5, 1)"

        );
        int barHoverOffset = 0;

        DataSet barDataSet = new DataSet(barLabel, barData, barBackgroundColors, barBorderColors, barHoverOffset);

        // data pertains to line chart
        String lineLabel = "dashed";
        List<Double> lineData = Arrays.asList(
                5.5, 5.5, 5.5, 5.5, 5.5, 5.5, 5.5, 5.5
        );
        List<String> lineBackgroundColors = Arrays.asList("rgb(0, 0, 0)");
        List<String> lineBorderColors = Arrays.asList("rgb(0, 0, 0)");
        int lineHoverOffset = 0;
        DataSet lineDataSet= new DataSet(lineLabel, lineData, lineBackgroundColors, lineBorderColors, lineHoverOffset);


        // add charts to the original chart
        ParentChart parentChart = new ParentChart(labels, Arrays.asList(barDataSet, lineDataSet));

        return ResponseEntity.ok(parentChart);
    }
}
