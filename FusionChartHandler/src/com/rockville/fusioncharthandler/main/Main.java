/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockville.fusioncharthandler.main;

import com.rockville.fusioncharthandler.handler.FusionChartHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Umair
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        List<String> categories = new ArrayList<String>();
        
        categories.add("A1 Label");
        categories.add("A2 Label");
        categories.add("A3 Label");
        
        
        List<Integer> firstDataset = new ArrayList<Integer>();
        List<Integer> secondDataset = new ArrayList<Integer>();
        
        firstDataset.add(100);
        firstDataset.add(200);
        firstDataset.add(500);
        firstDataset.add(400);
        
        
        
        secondDataset.add(50);
        secondDataset.add(250);
        secondDataset.add(350);
        secondDataset.add(800);
        
        
        Map<String, List<Integer>> seriesDataset = new LinkedHashMap<String, List<Integer>>();
        
        
        seriesDataset.put("seriesOne", firstDataset);
        seriesDataset.put("SeriesTwo", secondDataset);
        
        String chartCaption = "Sample Chart Caption";
        String xAxisLabel = "Sample x-axis Label";
        String yAxisLabel = "Sample y-axis Label";
        String numberPrefix = "$ ";
        
        
        String chartJSON = new FusionChartHandler().buildChartJson(chartCaption, xAxisLabel, yAxisLabel, numberPrefix, categories, seriesDataset);
        System.err.println(chartJSON);
    }
}
