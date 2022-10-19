package com.example.timertable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> numbers;
    int Count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView nubmerlist = findViewById(R.id.numberList);
        SeekBar seekBar = findViewById(R.id.seekBar);
        numbers = new ArrayList<>();
        Count = nubmerlist.getCount();
        for (int i = seekBar.getMin(); i < Count; i++){
            numbers.add(seekBar.getProgress() * i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(getApplication(),
                android.R.layout.simple_list_item_1, numbers);

        nubmerlist.setAdapter(adapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

               // textView.setText(String.valueOf(progress));
                numbers.clear();
                for (int i = seekBar.getMin(); i < Count; i++){
                    numbers.add(seekBar.getProgress() * i);
                }
                adapter.notifyDataSetChanged();
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