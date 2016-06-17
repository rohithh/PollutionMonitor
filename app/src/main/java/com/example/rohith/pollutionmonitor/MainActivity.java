package com.example.rohith.pollutionmonitor;

import com.example.rohith.pollutionmonitor.GraphActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.achartengine.*;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        TextView greenText = new TextView(this);
        greenText.setTextSize(15);
        greenText.setText("---- Low Pollution");
        greenText.setTextColor(Color.GREEN);
        greenText.setTypeface(Typeface.MONOSPACE);
        greenText.setX(250);
         greenText.setY(900);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.chart1);
        relativeLayout.addView(greenText);

        TextView greenText1 = new TextView(this);
        greenText1.setTextSize(15);
        greenText1.setText("---- Medium Pollution");
        greenText1.setTextColor(Color.YELLOW);
        greenText1.setTypeface(Typeface.MONOSPACE);
         greenText1.setX(250);
        greenText1.setY(1000);
        relativeLayout = (RelativeLayout) findViewById(R.id.chart1);
        relativeLayout.addView(greenText1);

        TextView greenText2 = new TextView(this);
        greenText2.setTextSize(15);
        greenText2.setText("---- High Pollution");
        greenText2.setTextColor(Color.RED);
        greenText2.setTypeface(Typeface.DEFAULT_BOLD);
        greenText2.setTypeface(Typeface.MONOSPACE);
        greenText2.setX(250);
        greenText2.setY(1100);
        relativeLayout = (RelativeLayout) findViewById(R.id.chart1);
        relativeLayout.addView(greenText2);

        ImageView mImageView = (ImageView) findViewById(R.id.iv2);

        Bitmap bitmap = Bitmap.createBitmap(
                1500, // Width
                1500, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);

        // Draw a solid color to the canvas background
        canvas.drawColor(findViewById(R.id.chart1).getSolidColor());

        // Initialize a new Paint instance to draw the Rectangle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(255,0,32,9);
        paint.setAntiAlias(true);


       // canvas.drawRect(220,900, 1300, 1400, paint);
        canvas.drawRect(200,500,1300,1000   ,paint);
        // Display the newly created bitmap on app interface
        mImageView.setImageBitmap(bitmap);
*/
    }


    public void onClick(View view) {

        System.out.println("BUTTON CLICKED");
        ImageView mImageView = (ImageView) findViewById(R.id.iv);

        Bitmap bitmap = Bitmap.createBitmap(
                findViewById(R.id.iv).getWidth(), // Width
                findViewById(R.id.iv).getHeight(), // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);
/*
        // Draw a solid color to the canvas background
        canvas.drawColor(findViewById(R.id.chart1).getSolidColor());

        // Initialize a new Paint instance to draw the Rectangle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);

        // Set a pixels value to padding around the rectangle
        int padding = 100;

        // Initialize a new Rect object
      /*  Rect rectangle = new Rect(
                findViewById(R.id.button).getLeft(), // Left
                canvas.getHeight()/2-400, // Top
                findViewById(R.id.button).getRight(), // Right
                canvas.getHeight()/2  + findViewById(R.id.button).getHeight()-400 // Bottom
        );*/
/*
        Rect rectangle = new Rect(findViewById(R.id.button).getLeft(),
                                  500,
                                  findViewById(R.id.button).getRight(),
                                  700);

        // Finally, draw the rectangle on the canvas
        canvas.drawRect(rectangle,paint);

        // Display the newly created bitmap on app interface
        mImageView.setImageBitmap(bitmap);
*/
        int pollutionLevelColor = findViewById(R.id.button).getLeft()+ (int)Math.floor((Math.random()*(findViewById(R.id.iv).getWidth()-findViewById(R.id.button).getLeft())));
    /*    Rect rectangleInside = new Rect(
            findViewById(R.id.button).getLeft(),
            canvas.getHeight()/2-400,
            pollutionLevelColor,
             canvas.getHeight()/2  + findViewById(R.id.button).getHeight()-400
        );*/


        Rect rectangleInside = new Rect(0,
                                        0   ,
                                        pollutionLevelColor,
                                        findViewById(R.id.iv).getTop()+findViewById(R.id.iv).getHeight()
                                        );

        System.out.println("TEST : " + findViewById(R.id.iv).getTop() + " : " + (findViewById(R.id.iv).getTop()+findViewById(R.id.iv).getHeight()));
        Paint paint1 = new Paint();
        System.out.println("pollutionLevelColor = " + pollutionLevelColor);
        System.out.println(" "
                + canvas.getWidth() + "-"
                + findViewById(R.id.button).getLeft() + "-" + findViewById(R.id.button).getLeft() + " = "  +
                (canvas.getWidth()-findViewById(R.id.button).getLeft()-findViewById(R.id.button).getLeft()));

        double colorValue =  (((double)pollutionLevelColor/(double)findViewById(R.id.iv).getWidth()));//Color.GREEN;Color.YELLOW;Color.RED;
        if(colorValue > 0.8){
            paint1.setColor(Color.RED);
        }
        else if(colorValue > 0.5 && colorValue < 0.8){
            paint1.setColor(Color.YELLOW);
        }
        else{
            paint1.setColor(Color.GREEN);
        }
        System.out.println("colorValue = " + colorValue);
         paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);

        canvas.drawRect(rectangleInside,paint1);
        mImageView.setImageBitmap(bitmap);


    }

    public void toGraphActivity(View view){
         Intent intent = new Intent(MainActivity.this, GraphActivity.class);
        startActivity(intent);
    }

}
