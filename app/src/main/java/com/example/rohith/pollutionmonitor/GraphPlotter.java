package com.example.rohith.pollutionmonitor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;

import com.androidplot.Plot;
import com.androidplot.ui.SizeMetric;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.PointLabeler;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rohith on 6/15/16.
 */
public class GraphPlotter extends Activity{
    public void plotGraph(String args[], ArrayList<Number> values, XYPlot plot, Context context){
        // initialize our XYPlot reference:


        // create a couple arrays of y-values to plot:
        int i;
        Number[] series1Numbers = new Number[100] ;


        for(i = 0; i < 100; i++){
            series1Numbers[i] = values.get(i);
        }

        // turn the above arrays into XYSeries':
        // (Y_VALS_ONLY means use the element index as the x value)
        XYSeries series1 = new SimpleXYSeries(Arrays.asList(series1Numbers),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");


        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(context,
                R.xml.line_point_formatter_with_labels);

        plot.setDomainValueFormat(new DecimalFormat("0"));
        plot.setRangeValueFormat(new DecimalFormat("0"));
       // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
         // reduce the number of range labels
        plot.setTicksPerRangeLabel(2);
        plot.setTicksPerDomainLabel(2);

          Paint paint = new Paint();
        plot.getGraphWidget().getDomainGridLinePaint().setColor(Color.TRANSPARENT);
        plot.getGraphWidget().getRangeGridLinePaint().setColor(Color.TRANSPARENT);

        paint.setColor(ContextCompat.getColor(context,R.color.darkGreen));
        plot.getGraphWidget().setBackgroundPaint(paint);
        plot.getGraphWidget().setGridBackgroundPaint(paint);
        plot.getGraphWidget().getBackgroundPaint().setColor(paint.getColor()); //
        plot.getBorderPaint().setColor(paint.getColor());
        plot.getLayoutManager().remove(plot.getLegendWidget());
        plot.getLayoutManager().remove(plot.getTitleWidget());
        plot.getLayoutManager().remove(plot.getRangeLabelWidget());
        plot.getLayoutManager().remove(plot.getDomainLabelWidget());
        plot.getGraphWidget().getRangeGridLinePaint().setColor(Color.TRANSPARENT);
        plot.getGraphWidget().getDomainGridLinePaint().setColor(Color.TRANSPARENT);
        plot.getGraphWidget().getDomainOriginLinePaint().setColor(Color.BLACK);
        plot.getGraphWidget().getRangeOriginLinePaint().setColor(Color.BLACK);
        plot.getGraphWidget().getDomainTickLabelPaint().setColor(Color.WHITE);
        plot.getGraphWidget().getRangeTickLabelPaint().setColor(Color.WHITE);
        plot.setPlotMargins(0,0,0,0);
        plot.setPlotPadding(0,0,0,0);

        plot.setX(-20);
       //  plot.disableAllMarkup();
         }
}
