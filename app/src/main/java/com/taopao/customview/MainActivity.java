package com.taopao.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PieView pieview;
    private ScaleLayoutView scaleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initScaleView();
    }

    private void initScaleView() {
        scaleview.setNormalView(R.layout.da, R.layout.xiao);
    }

    private void initView() {
        pieview = (PieView) findViewById(R.id.pieview);


        pieview.setStartAngle(0);


        ArrayList<PieView.PieData> pieData = new ArrayList<>();


        pieData.add(new PieView.PieData("", 30));
        pieData.add(new PieView.PieData("", 100));
        pieData.add(new PieView.PieData("", 70));
        pieData.add(new PieView.PieData("", 150));

        pieview.setData(pieData);

        scaleview = (ScaleLayoutView) findViewById(R.id.scaleview);
    }
}
