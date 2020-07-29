package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieGraphActivity extends AppCompatActivity {
    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_graph);

        pieChart=findViewById(R.id.piechart);

        String s1 = getIntent().getStringExtra("s1");
        String s2 = getIntent().getStringExtra("s2");
        String s3 = getIntent().getStringExtra("s3");
        String s4 = getIntent().getStringExtra("s4");
        String s5 = getIntent().getStringExtra("s5");
        pieEntries=new ArrayList<>();

        pieEntries.add(new PieEntry(Float.parseFloat(s1),"2016"));
        pieEntries.add(new PieEntry(Float.parseFloat(s2),"2017"));
        pieEntries.add(new PieEntry(Float.parseFloat(s3),"2018"));
        pieEntries.add(new PieEntry(Float.parseFloat(s4),"2019"));
        pieEntries.add(new PieEntry(Float.parseFloat(s5),"2020"));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Visitors");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(18f);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("Visitors");
        pieChart.getDescription().setEnabled(false);
        pieChart.animate();

    }

    /*public void generatePie(View view) {

        pieEntries=new ArrayList<>();
        String s1= et1.getText().toString();
        String s2= et2.getText().toString();
        String s3= et3.getText().toString();
        String s4= et4.getText().toString();
        String s5= et5.getText().toString();
        pieEntries.add(new PieEntry(Float.parseFloat(s1),"2016"));
        pieEntries.add(new PieEntry(Float.parseFloat(s2),"2017"));
        pieEntries.add(new PieEntry(Float.parseFloat(s3),"2018"));
        pieEntries.add(new PieEntry(Float.parseFloat(s4),"2019"));
        pieEntries.add(new PieEntry(Float.parseFloat(s5),"2020"));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Visitors");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(18f);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("Visitors");
        pieChart.getDescription().setEnabled(false);
        pieChart.animate();
    }*/
}