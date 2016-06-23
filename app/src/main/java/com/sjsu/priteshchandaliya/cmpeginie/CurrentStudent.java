package com.sjsu.priteshchandaliya.cmpeginie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentStudent extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView, listView1;
    // listView = null;
    Button button;
    TextView txtview;
    CheckBox checkBox1;
    CheckBox checkBox2, checkBox3, checkBox4;
    ArrayAdapter adapter, adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_student2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] courses = getResources().getStringArray(R.array.networkCourses);
        String[] courses1 = getResources().getStringArray(R.array.embeddedCourses);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, courses);
        listView = (ListView) findViewById(R.id.courselist);
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, courses1);
        checkBox1 = (CheckBox) findViewById(R.id.networking);
        checkBox2 = (CheckBox) findViewById(R.id.embedded);
        checkBox3 = (CheckBox) findViewById(R.id.sem1);
        checkBox4 = (CheckBox) findViewById(R.id.sem2);

        checkBox1.setTypeface(CmpeGenie.robotoMedium);
        checkBox2.setTypeface(CmpeGenie.robotoMedium);
        checkBox3.setTypeface(CmpeGenie.robotoMedium);
        checkBox4.setTypeface(CmpeGenie.robotoMedium);

        TextView text1 = (TextView) findViewById(R.id.textView3);
        text1.setTypeface(CmpeGenie.robotoRegular);
        TextView text2 = (TextView) findViewById(R.id.textView3);
        text2.setTypeface(CmpeGenie.robotoRegular);

        txtview = (TextView) findViewById(R.id.cours);
        txtview.setTypeface(CmpeGenie.robotoRegular);
        txtview.setVisibility(View.GONE);
        button = (Button) findViewById(R.id.buttonStart);
        button.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {
                int size = listView.getCheckedItemPositions().size();
                String Msg = "You cannot select more then four courses if you are in 1st semester";
                String Msg1 = "You cannot select more then eight courses if you are in 1st semester";
         /*       if(checkBox3.isChecked()){
                   // Toast.makeText(getApplicationContext(),""+size,Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(CurrentStudent.this, PlanSem2.class);
                    startActivity(intent);
                }*/
                if (checkBox3.isChecked() && size > 4) {

                        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
                    }
                     if (checkBox4.isChecked() && size > 8) {

                            Toast.makeText(getApplicationContext(), Msg1, Toast.LENGTH_SHORT).show();
                        }
                     if (size <= 4 && checkBox3.isChecked()) {
                        Intent intent = new Intent(CurrentStudent.this, PlanSem2.class);
                        startActivity(intent);

                    }
                }
                // Toast.makeText(getApplicationContext(),""+size,Toast.LENGTH_SHORT).show();

        });
        button.setVisibility(View.GONE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //semester(position);
            }
        });
    }

    public void course(View view) {

        // ArrayAdapter<String> adapter=null;
        boolean a[];

        if (checkBox1.isChecked()) {
            checkBox2.setChecked(false);
            listView.setAdapter(adapter);
            listView.setVisibility(View.VISIBLE);
            //  int size = listView.getCheckedItemPositions().size();
            // Toast.makeText(getApplicationContext(),""+size,Toast.LENGTH_SHORT).show();
          /*   String[] courses = getResources().getStringArray(R.array.networkCourses);
             adapter = new ArrayAdapter<String>(this,
                     android.R.layout.simple_list_item_multiple_choice, courses);
             listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
             listView.setAdapter(adapter);*/
            //listView.setVisibility(View.VISIBLE);
            txtview.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            checkBox1.setChecked(false);

        }
        if (checkBox2.isChecked()) {

            checkBox1.setChecked(false);
            txtview.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            listView.setAdapter(adapter1);
            listView.setVisibility(View.VISIBLE);
            checkBox2.setChecked(false);


        }

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.current_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)  //plan your schedule
        {
            Intent intent = new Intent(CurrentStudent.this, PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum) {
            Intent intent = new Intent(CurrentStudent.this, main_discussion_forum_list.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(CurrentStudent.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(CurrentStudent.this, GettingIntoSjsu.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_course){
            Intent intent = new Intent(CurrentStudent.this, CourseStructure.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share) {

            String sharingMessage = "Welcome to SJSU Genie! Share the word among all the students of San Jose State University and download the apk file from here";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sharingMessage);
            sendIntent.setType("text/plain");

            //String shareTitle = CurrentStudent.this.getResources().getString(R.string.share_title) + " " + allTiles.get(pos).getGroupName();
            String shareTitle = "CMPE 220";
            CurrentStudent.this.startActivity(Intent.createChooser(sendIntent, shareTitle));

        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(CurrentStudent.this, ContactUs.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_accomodation){
            Intent intent = new Intent(CurrentStudent.this, Accomodation.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
