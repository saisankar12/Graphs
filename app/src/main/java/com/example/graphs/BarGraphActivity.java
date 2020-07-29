package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarGraphActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        barChart=findViewById(R.id.barchart);

        String s1 = getIntent().getStringExtra("s1");
        String s2 = getIntent().getStringExtra("s2");
        String s3 = getIntent().getStringExtra("s3");
        String s4 = getIntent().getStringExtra("s4");
        String s5 = getIntent().getStringExtra("s5");

        barEntries=new ArrayList<>();


        barEntries.add(new BarEntry(2016, Float.parseFloat(s1)));
        barEntries.add(new BarEntry(2017,Float.parseFloat(s2)));
        barEntries.add(new BarEntry(2018,Float.parseFloat(s3)));
        barEntries.add(new BarEntry(2019,Float.parseFloat(s4)));
        barEntries.add(new BarEntry(2020,Float.parseFloat(s5)));

        BarDataSet barDataSet=new BarDataSet(barEntries,"Visitors");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);

        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);
        barChart.animateY(2000);
    }

   /* public void generateBar(View view) {

        barEntries=new ArrayList<>();
        String s1= et1.getText().toString();
        String s2= et2.getText().toString();
        String s3= et3.getText().toString();
        String s4= et4.getText().toString();
        String s5= et5.getText().toString();
        barEntries.add(new BarEntry(2016,Float.parseFloat(s1)));
        barEntries.add(new BarEntry(2017,Float.parseFloat(s2)));
        barEntries.add(new BarEntry(2018,Float.parseFloat(s3)));
        barEntries.add(new BarEntry(2019,Float.parseFloat(s4)));
        barEntries.add(new BarEntry(2020,Float.parseFloat(s5)));

        BarDataSet barDataSet=new BarDataSet(barEntries,"Visitors");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);

        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);
        barChart.animateY(2000);
    }*/
}