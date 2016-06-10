package com.example.rohith.pollutionmonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Rohith on 6/10/16.
 */
public class GraphActivity extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
    }

    public void backToMainActivity(View view){
        Intent intent = new Intent(GraphActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
