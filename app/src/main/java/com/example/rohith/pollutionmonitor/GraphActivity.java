package com.example.rohith.pollutionmonitor;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import com.androidplot.Plot;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Rohith on 6/10/16.
 */
public class GraphActivity extends Activity {

    TextView textView;
    Database database;
    Spinner spinner;
    XYPlot plot;
    GraphPlotter graphPlotter;
    String values[] = { "Hourly", "Daily", "Weekly", "Monthly", "Yearly"};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //textView = (TextView) findViewById(R.id.graphActivityTextView);
        database = new Database(this);

        plot = (XYPlot) findViewById(R.id.plot);
        final GraphActivity graphActivity = this;
        SQLiteDatabase db = database.getWritableDatabase();
       // database.onCreate(db);
        Random random = new Random();
        //System.out.println("Finished creating db, now inserting data :");
        //for(int i = 0; i < 1000; i++){
         //   database.insertData(new Date(116,random.nextInt(12),random.nextInt(7),random.nextInt(24),
          //  random.nextInt(60),random.nextInt(60)), i);
       // }
        //System.out.println("Finished inserting data");
        printDatabase("",0,200);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinner_options,R.layout.spinner_rows);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Item selected = " + String.valueOf(spinner.getSelectedItem()));
               // graphPlotter.plotGraph(String.valueOf(spinner.getSelectedItem()), plot, graphActivity);

                if(String.valueOf(spinner.getSelectedItem()).equals("1. HOURLY")){
                    hourlyPlot();
                }
                else if(String.valueOf(spinner.getSelectedItem()).equals("2. DAILY")){
                    dailyPlot();
                }
                else if(String.valueOf(spinner.getSelectedItem()).equals("3. WEEKLY")){
                    weeklyPlot();
                }
                else if(String.valueOf(spinner.getSelectedItem()).equals("4. MONTHLY")){
                    monthlyPlot();
                }
                else if(String.valueOf(spinner.getSelectedItem()).equals("5. YEARLY")){
                    yearlyPlot();
                }
                plot.invalidate();
                plot.redraw();
                plot.refreshDrawableState();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void hourlyPlot() {
        printDatabase("",200,400);
     }
    private void dailyPlot() {
        printDatabase("",400,600);

    }
    private void weeklyPlot() {
        printDatabase("",600,800);
     }
    private void monthlyPlot() {
        printDatabase("",800,1000);
     }
    private void yearlyPlot() {
        printDatabase("",1000,1200);
        onCreate(null);
    }

    public void printDatabase(String arg, int a, int b) {
        int i;
        ArrayList<Number> finalValues = new ArrayList<Number>();
        String dbString[] = database.databaseToString();
        String stringsDates[] = dbString[0].split("\r\n|\r|\n");
        String stringsValues[] = dbString[1].split("\r\n|\r|\n");
        HashMap<String, String> map  = new HashMap<>();
        for( i = 0; i < stringsDates.length; i++){
            map.put(stringsDates[i], stringsValues[i]);
        }

         ArrayList<Date> dates = new ArrayList<Date>();
        ArrayList<Number> values = new ArrayList<Number>();
         System.out.println("strings.length = " +  stringsDates.length);
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE MMM dd HH:mm:ss 'GMT+05:30' yyyy", Locale.ENGLISH);
        for(i = 0;i < stringsDates.length; i++) {
            try {
                dates.add(formatter.parse(stringsDates[i]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(dates,new Comparator<Date>(){

            @Override
            public int compare(Date lhs, Date rhs) {

                return lhs.compareTo(rhs);
            }
        });

        for(Date date : dates){
            values.add(Integer.parseInt(map.get(date.toString())));
        }


        for(i = a; i < b; i++){
            finalValues.add(values.get(i));
        }

        GraphPlotter graphPlotter = new GraphPlotter();
        graphPlotter.plotGraph(dbString,finalValues, plot,this);

        //textView.setText(dbString);
     }

    public void backToMainActivity(View view){
        Intent intent = new Intent(GraphActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
