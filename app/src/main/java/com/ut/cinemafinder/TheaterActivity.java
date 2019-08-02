package com.ut.cinemafinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TheaterActivity extends AppCompatActivity {
    private static final String TAG = "TheaterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Entered Theater Activity from intent");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        ArrayList<Theater> theaters = new ArrayList<Theater>();
//        //int count = getIntent().getIntExtra("cinema_count", 0);
//        Bundle bd = getIntent().getExtras();
//        int count = bd.getInt("cinema_count");
//        for (int i = 0; i < count; i++) {
//            //theaters.add((Theater)getIntent().getSerializableExtra("theater"+i));
//            theaters.add((Theater)bd.getSerializable("theater"+i));
//        }
        CustomAdapter customListAdapter = new CustomAdapter(this, theaters);
        ListView customListView = findViewById(R.id.custom_list_id);
        customListView.setAdapter(customListAdapter);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(view.getTag() == "img") {
                            Toast.makeText(TheaterActivity.this, "Image was clicked!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(TheaterActivity.this, "Text was clicked!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
