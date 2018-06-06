package com.example.thu.hayda.activity;

import android.content.Intent;
import android.media.AsyncPlayer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.thu.hayda.R;
import com.example.thu.hayda.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";


    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<Integer> mImageUrls1 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls2 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls3 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls4 = new ArrayList<>();
    private ArrayList<Integer> mImageUrls5 = new ArrayList<>();

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mNames1 = new ArrayList<>();
    private ArrayList<String> mNames2 = new ArrayList<>();
    private ArrayList<String> mNames3 = new ArrayList<>();
    private ArrayList<String> mNames4 = new ArrayList<>();
    private ArrayList<String> mNames5 = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Log.d(TAG, "onCreate: started.");

//đổ arraylist vô adapter
        getImages();
    }

    @Override
    public void onBackPressed() {
//        mở đống DrawerLayout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // bài tập từng phần và bài tập tổng hợp.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            Intent intent=new Intent(MainActivity.this,Exercise_Detail.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent1=new Intent(MainActivity.this,Exercise_Sum.class);
            startActivity(intent1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getImages() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add(R.drawable.amkhac);
        mNames.add("1");
        mImageUrls.add(R.drawable.imagesugar);
        mNames.add("2");
        mImageUrls.add(R.drawable.imagemattroi);
        mNames.add("3");
        mImageUrls.add(R.drawable.imagedognau);
        mNames.add("4");
        mImageUrls.add(R.drawable.imagebanane);
        mNames.add("5");
        mImageUrls.add(R.drawable.imageeggs);
        mNames.add("6");
        mImageUrls.add(R.drawable.imagecat);
        mNames.add("7");


        mImageUrls1.add(R.drawable.imagecuu);
        mImageUrls1.add(R.drawable.imagefood);
        mImageUrls1.add(R.drawable.imageheart);
        mImageUrls1.add(R.drawable.imagebongchuyen);
        mImageUrls1.add(R.drawable.imagechim);

        mNames1.add("8");
        mNames1.add("9");
        mNames1.add("10");
        mNames1.add("11");
        mNames1.add("12");


        mImageUrls2.add(R.drawable.imagebia);
        mImageUrls2.add(R.drawable.imagepaper);
        mImageUrls2.add(R.drawable.imagenine);
        mImageUrls2.add(R.drawable.imageboyhatblue);
        mImageUrls2.add(R.drawable.imageclam);
        mImageUrls2.add(R.drawable.imagechairs);
        mImageUrls2.add(R.drawable.imagecrow);
        mImageUrls2.add(R.drawable.imagepeople);

        mNames2.add("13");
        mNames2.add("14");
        mNames2.add("15");
        mNames2.add("16");
        mNames2.add("17");
        mNames2.add("18");
        mNames2.add("19");
        mNames2.add("20");

        mImageUrls3.add(R.drawable.imagebook);
        mImageUrls3.add(R.drawable.imagedog);
        mImageUrls3.add(R.drawable.imagesky);
        mImageUrls3.add(R.drawable.imagegirl);
        mImageUrls3.add(R.drawable.imagedan);
        mImageUrls3.add(R.drawable.imageboy);
        mImageUrls3.add(R.drawable.imagengua);
        mImageUrls3.add(R.drawable.imagekhotien);


        mNames3.add("21");
        mNames3.add("22");
        mNames3.add("23");
        mNames3.add("24");
        mNames3.add("25");
        mNames3.add("26");
        mNames3.add("27");
        mNames3.add("28");

        mImageUrls4.add(R.drawable.imagepen);
        mImageUrls4.add(R.drawable.imagepotato);
        mImageUrls4.add(R.drawable.ga);
        mImageUrls4.add(R.drawable.imagekey);
        mImageUrls4.add(R.drawable.amv);
        mImageUrls4.add(R.drawable.amdaunguoi);
        mImageUrls4.add(R.drawable.amz);
        mImageUrls4.add(R.drawable.amba);


        mNames4.add("29");
        mNames4.add("30");
        mNames4.add("31");
        mNames4.add("32");
        mNames4.add("33");
        mNames4.add("34");
        mNames4.add("35");
        mNames4.add("36");

        mImageUrls5.add(R.drawable.imagedollars);
        mImageUrls5.add(R.drawable.imagedoctors);
        mImageUrls5.add(R.drawable.imagenhan);
        mImageUrls5.add(R.drawable.imagehouse);
        mImageUrls5.add(R.drawable.amw);
        mImageUrls5.add(R.drawable.amj);

        mNames5.add("37");
        mNames5.add("38");
        mNames5.add("39");
        mNames5.add("40");
        mNames5.add("41");
        mNames5.add("42");

        initRecyclerView();


    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageUrls, mNames);
        recyclerView.setAdapter(adapter);


        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(layoutManager1);
        RecyclerViewAdapter adapter1 = new RecyclerViewAdapter(this, mImageUrls1, mNames1);
        recyclerView1.setAdapter(adapter1);


        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(this, mImageUrls2, mNames2);
        recyclerView2.setAdapter(adapter2);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);
        recyclerView3.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(this, mImageUrls3, mNames3);
        recyclerView3.setAdapter(adapter3);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView4 = findViewById(R.id.recyclerView4);
        recyclerView4.setLayoutManager(layoutManager4);
        RecyclerViewAdapter adapter4 = new RecyclerViewAdapter(this, mImageUrls4, mNames4);
        recyclerView4.setAdapter(adapter4);

        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView5 = findViewById(R.id.recyclerView5);
        recyclerView5.setLayoutManager(layoutManager5);
        RecyclerViewAdapter adapter5 = new RecyclerViewAdapter(this, mImageUrls5, mNames5);
        recyclerView5.setAdapter(adapter5);
    }



}
