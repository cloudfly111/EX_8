package com.example.ex_8;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listViewCity;
    private List<Map<String, Object>> cityList;
    private String[] cityName;
    private String[] cityIntro;
    private String[] cityContent;
    private TypedArray cityImage;
    private ImageView imageViewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.night_sky,null));

        listViewCity = (ListView) findViewById(R.id.listView_id);
        cityList=new ArrayList<Map<String,Object>>();
        cityName = getResources().getStringArray(R.array.city_name);
        cityIntro = getResources().getStringArray(R.array.city_intro);
//        cityContent = getResources().getStringArray(R.array.city_content);

//        imageViewTest = (ImageView) findViewById(R.id.imageView3);
        cityImage =  getResources().obtainTypedArray(R.array.city_image);
//        Log.d("main","cityImage="+cityImage.getDrawable(0));
//        imageViewTest.setImageDrawable(cityImage.getDrawable(1));
        for(int i =0 ;i<cityName.length;i++){
            Map<String,Object> tempMap = new HashMap<String,Object>();
            tempMap.put("name",cityName[i]);
            tempMap.put("intro",cityIntro[i]);
//            tempMap.put("content",cityContent[i]);
            tempMap.put("image",cityImage.getResourceId(i,0));
            cityList.add(tempMap);
        }

//        SimpleAdapter
//        SimpleAdapter (Context context,
//                List<? extends Map<String, ?>> data,
//        int resource,
//        String[] from,
//        int[] to)
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, cityList, R.layout.list_simple_item,
                new String[]{"name", "intro", "image"}, new int[]{R.id.textView_city_name, R.id.textView_city_intro, R.id.imageView_city});
        listViewCity.setAdapter(adapter);
//      注意 監聽 listView 是用 "setOnItemClickListener"
        listViewCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("main","position="+position);
                Log.d("main","id="+id);
//                按 "臺北市"
//                2022-08-17 10:36:09.378 21618-21618/com.example.ex_8 D/main: position=0
//                2022-08-17 10:36:09.379 21618-21618/com.example.ex_8 D/main: id=0
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                intent.putExtra("name",cityName[position]);
                intent.putExtra("position",position);
                intent.putExtra("image",cityImage.getResourceId(position,0));
                startActivity(intent);

            }
        });
    }
}