package com.example.rohith.pollutionmonitor;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Date;
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
    String values[] = { "Hourly", "Daily", "Weekly", "Monthly", "Yearly"};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //textView = (TextView) findViewById(R.id.graphActivityTextView);
        database = new Database(this);

        SQLiteDatabase db = database.getWritableDatabase();
       // database.onCreate(db);
        Random random = new Random();
        System.out.println("Finished creating db, now inserting data :");
        //for(int i = 0; i < 1000; i++){
         //   database.insertData(new Date(116,random.nextInt(12),random.nextInt(7),random.nextInt(24),
          //  random.nextInt(60),random.nextInt(60)), i);
       // }
        System.out.println("Finished inserting data");
        printDatabase();


        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinner_options,R.layout.spinner_rows);
        spinner.setAdapter(arrayAdapter);

    }

    public void printDatabase() {
        String dbString = database.databaseToString();
        System.out.println(dbString);

        //textView.setText(dbString);
     }

    public void backToMainActivity(View view){
        Intent intent = new Intent(GraphActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
