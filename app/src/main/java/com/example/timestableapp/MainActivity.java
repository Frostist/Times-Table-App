package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Listing my variables and uses
    ListView myListView;
    SeekBar mySeekBar;
    String TAG = "Project";
    int num;


    public void generateTimesTable(int timesTableNumber){
        //Creating a new arraylist
        ArrayList<String> numbers = new ArrayList<String>();
        //saying that if the num(1) is less than or equal to 100 then take those numbers and go to the next step
        for (int num = 1; num <= 100; num++) {
            //Add those numbers to the array but first take them all and multiply them by the sliders postion
            numbers.add(Integer.toString(num * timesTableNumber));
        }
        //This is the array adapter to make sure the list view is gettting the correcet infomation
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
        //this is settignt he list view to use the correct array
        myListView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Initiating the seek bar and list view
        mySeekBar = findViewById(R.id.mySeekBar);
        myListView = findViewById(R.id.myListView);
//Setting up my max and starting postion ints
        int maxValue = 20;
        int startingPos = 10;
//seeting the max and opening postion of the slider
        mySeekBar.setMax(maxValue);
        mySeekBar.setProgress(startingPos);
//this starts the method above and gets the numbers on the screen when the app is opened
        generateTimesTable(startingPos);
//this is the code for the seek bar
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //this is setting the starting value for the times table
                int min = 1;
                int timesTableNumber;
                //this is setting the value of the slider to be less than the minimimum of 1
                if (progress < min) {
                    timesTableNumber = min;
                    mySeekBar.setProgress(min);

                } else {
                    //settignt he number to the value where the sldier is at
                    timesTableNumber = progress;

                }
                Log.w(TAG, "SeekBar Value: "+ progress + " Times Number: " + Integer.toString(timesTableNumber));
                //updates the table so when you change the slider it updates the view
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
