package com.example.ex_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CityActivity extends AppCompatActivity {

    private ImageView imageViewContent;
    private TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.night_sky,null));

        imageViewContent = (ImageView) findViewById(R.id.imageView_content);
        textViewContent = (TextView) findViewById(R.id.textView_content);
        textViewContent.setText("");

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("name");
        int pos = intent.getIntExtra("position", 0);
        int image = intent.getIntExtra("image", R.drawable.hsinchu);

        setTitle(cityName);
        imageViewContent.setImageResource(image);

        String[] content = getResources().getStringArray(R.array.city_content);
        textViewContent.setText(content[pos]);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}