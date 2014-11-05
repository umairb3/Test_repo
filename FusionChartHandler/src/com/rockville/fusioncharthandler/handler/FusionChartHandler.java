/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockville.fusioncharthandler.handler;

import java.util.List;
import java.util.Map;

/**
 * @author Umair Baig
 * @email umair.baig@rockvillegroup.com
 * @version 1.0
 * @since 02 OCT, 2013
 */
public class FusionChartHandler {

    /**
     * @see Load chart settings
     * @param String chartCaption
     * @param String xAxisLabel
     * @param String yAxisLabel
     * @param String numberPrefix
     * @return String chartSetting
     */
    private String loadChartSetting(String chartCaption, String xAxisLabel, String yAxisLabel, String numberPrefix) {
        StringBuffer chartSetting = new StringBuffer();
        chartSetting.append("{");
        chartSetting.append("\"chart\": {");
        chartSetting.append("\"showvalues\"").append(":").append("\"0\"").append(",");
        chartSetting.append("\"caption\"").append(":").append("\"" + chartCaption + "\"").append(",");
        chartSetting.append("\"useRoundEdges\"").append(":").append("\"1\"").append(",");
        chartSetting.append("\"theme\"").append(":").append("\"fint\"").append(",");
        chartSetting.append("\"numberPrefix\"").append(":").append("\"" + numberPrefix + "\"").append(",");
        chartSetting.append("\"formatNumberScale \"").append(":").append("\"0\",");
        chartSetting.append("\"yAxisName \"").append(":").append("\"" + yAxisLabel + "\"").append(",");
        chartSetting.append("\"xAxisName \"").append(":").append("\"" + xAxisLabel + "\"");
        chartSetting.append("},");

        return chartSetting.toString();
    }

    private String categoriesSettings(List<String> categories) {
        String category = "\"categories\":[{";
        category += "\"category\":[";
        if (categories.size() > 0) {
            for (String categoryName : categories) {
                category += "{\"label\":\"" + categoryName + "\"},";
            }
            category = category.substring(0, category.length() - 1) + "]}],";
            return category;
        } else {
            return "N/A";
        }
    }

    private String seriesDatasetSetttings(Map<String, List<Integer>> seriesDataset) {
        String series = "\"dataset\":[";
        String datasetSeries = "";

        for (Map.Entry<String, List<Integer>> entry : seriesDataset.entrySet()) {
            datasetSeries += "{\"seriesname\":\"" + entry.getKey() + "\",\"data\":[";
            List<Integer> datasetList = entry.getValue();
            for (Integer dataset : datasetList) {
                datasetSeries += "{\"value\":\"" + dataset + "\"},";
            }
            datasetSeries = datasetSeries.substring(0, datasetSeries.length() - 1) + "]},";
        }
        datasetSeries = datasetSeries.substring(0, datasetSeries.length() - 1);
        return series + datasetSeries;
    }

    public String buildChartJson(String chartCaption, 
            String xAxisLabel, String yAxisLabel, 
            String numberPrefix, List<String> categories, 
            Map<String, List<Integer>> seriesDataset) {
        String chartSetting = loadChartSetting(chartCaption, xAxisLabel, yAxisLabel, numberPrefix);
        String category = categoriesSettings(categories);
        String seriesAndDataSet = seriesDatasetSetttings(seriesDataset);
        return chartSetting + category + seriesAndDataSet + "]}";
    }
}
