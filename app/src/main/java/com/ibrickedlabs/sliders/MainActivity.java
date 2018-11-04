package com.ibrickedlabs.sliders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {
    //For inBuilt AppCompatSeekbar
    private AppCompatSeekBar appCompatSeekBar;
    private TextView seekbarValue;

    //For External seekbar
    private RangeBar mRangeBar;
    private TextView rangebarTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Appcompat Intz
        appCompatSeekBar = (AppCompatSeekBar) findViewById(R.id.seekBar);
        seekbarValue = (TextView) findViewById(R.id.seekbar_value);
        //Rangebar Intz
        mRangeBar = (RangeBar) findViewById(R.id.customSeekBar);
        rangebarTv = (TextView) findViewById(R.id.rangebarValue);


        //Set seekbar default value
        appCompatSeekBar.setProgress(0);

        //Set the step value for the seekbar iee.. we are setting it to 1
        appCompatSeekBar.setKeyProgressIncrement(1);

        appCompatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //it will be called when u seeked it and stopped that means the progress value changes
                //so we need to set the progess value
                seekbarValue.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //when you touch the seekbar

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //when you stop seeking it out

            }
        });


        mRangeBar.setSeekPinByIndex(0);//Inital progress value

        //For the text inside the Pin(Bubble)
        mRangeBar.setPinTextColor(getResources().getColor(R.color.colorPrimary));

        //For the selector of Rangebar
        mRangeBar.setSelectorColor(getResources().getColor(R.color.colorAccent));
        //For the small pins of Rangebar
        mRangeBar.setTickColor(getResources().getColor(R.color.colorAccent));

        //Color of the line after seeking
        mRangeBar.setConnectingLineColor(getResources().getColor(R.color.colorAccent));

        //Color of the pin(Bubble)
        mRangeBar.setPinColor(getResources().getColor(R.color.colorAccent));

        //When you change the progress of Rangebar
        mRangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                rangebarTv.setText(rightPinValue);
            }
        });
    }
}
