package com.example.rohith.pollutionmonitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by Rohith on 6/7/16.
 */
public class LineGraph {
    public Intent getIntent(Context context){
        int x[] = {1,2,3,4,5,6,7,8,9,10};
        int y[] = {10,20,30,40,50,60,70,80,90,100};

        XYSeries series = new XYSeries("Rohiths Example Chart");


        //TimeSeries series = new TimeSeries("Line1");
        for(int i = 0; i < x.length; i++){
            series.add(x[i],y[i]);
        }
        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setLineWidth(2);
        renderer.setColor(Color.RED);

        renderer.setPointStyle(PointStyle.CIRCLE);
        mRenderer.addSeriesRenderer(renderer);

        // We want to avoid black border
        mRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00)); // transparent margins
        // Disable Pan on two axis
        mRenderer.setPanEnabled(false, false);
        mRenderer.setYAxisMax(35);
        mRenderer.setYAxisMin(0);
        mRenderer.setShowGrid(true);


        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);
        GraphicalView chartView = ChartFactory.getLineChartView(context, dataset, mRenderer);


         Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph Title");

        return intent;
    }

}
