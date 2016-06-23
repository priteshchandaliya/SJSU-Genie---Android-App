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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class FutureStudent extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
public String Msg = "Please check appropriate options";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_student2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView text1 = (TextView) findViewById(R.id.textView3);
        text1.setTypeface(CmpeGenie.robotoRegular);

        CheckBox text2 = (CheckBox) findViewById(R.id.networking);
        text2.setTypeface(CmpeGenie.robotoMedium);

        CheckBox text3 = (CheckBox) findViewById(R.id.embedded);
        text3.setTypeface(CmpeGenie.robotoMedium);


        TextView text4 = (TextView) findViewById(R.id.textView4);
        text4.setTypeface(CmpeGenie.robotoRegular);

        CheckBox text5 = (CheckBox) findViewById(R.id.prereq1);
        text5.setTypeface(CmpeGenie.robotoMedium);

        CheckBox text6 = (CheckBox) findViewById(R.id.prereq2);
        text6.setTypeface(CmpeGenie.robotoMedium);

        CheckBox text7 = (CheckBox) findViewById(R.id.prereq3);
        text7.setTypeface(CmpeGenie.robotoMedium);

        TextView text8 = (TextView) findViewById(R.id.textView6);
        text8.setTypeface(CmpeGenie.robotoRegular);

        TextView text9 = (TextView) findViewById(R.id.textView7);
        text9.setTypeface(CmpeGenie.robotoRegular);

        CheckBox text10 = (CheckBox) findViewById(R.id.no3);
        text10.setTypeface(CmpeGenie.robotoMedium);

        CheckBox text11 = (CheckBox) findViewById(R.id.no4);
        text11.setTypeface(CmpeGenie.robotoMedium);

    }
    public void planNetwork(View view) {
        final CheckBox checkBox = (CheckBox) findViewById(R.id.networking);
        final CheckBox checkBox7 = (CheckBox) findViewById(R.id.embedded);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.prereq1); //DD
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.prereq2); //oops
        final CheckBox checkBox4 = (CheckBox) findViewById(R.id.prereq3); //OS
        final CheckBox checkBox5 = (CheckBox) findViewById(R.id.no3);
        final CheckBox checkBox6 = (CheckBox) findViewById(R.id.no4);


        //With all three pre reqs and 3 courses each semester
        if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            setOfPlans1();
            checkBox.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
        }
        //Without DD, with 2 pre reqs and 3 courses each semester
        else if (checkBox.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            setOfPlans2();
            checkBox.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
        }
        //With DD and 3 courses
        else if (checkBox.isChecked() && checkBox2.isChecked() && checkBox5.isChecked()) {
            setOfPlans3();
            checkBox.setChecked(false);
            checkBox2.setChecked(false);
            checkBox5.setChecked(false);

        }
        //With DD and OS and 3 courses
        else if (checkBox.isChecked() && checkBox2.isChecked() && checkBox4.isChecked() && checkBox5.isChecked()) {
            setOfPlans4();
            checkBox.setChecked(false);
            checkBox2.setChecked(false);
            checkBox5.setChecked(false);

        }
        //With DD and oops and 3 courses
        else if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox5.isChecked()) {
            setOfPlans5();
            checkBox.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox5.setChecked(false);


        }  //With all three pre reqs and 3 courses each semester
        if (checkBox7.isChecked()  && checkBox2.isChecked()  && checkBox3.isChecked()  && checkBox4.isChecked() && checkBox5.isChecked() ) {
            setOfPlans01();
            checkBox7.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
        }
        //Without DD, with 2 pre reqs and 3 courses each semester
        else if(checkBox7.isChecked()   && checkBox3.isChecked()  && checkBox4.isChecked() && checkBox5.isChecked()){
            setOfPlans02();
            checkBox7.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);
        }
        //With DD and 3 courses
        else if(checkBox7.isChecked()   && checkBox2.isChecked()   && checkBox5.isChecked())
        {
            setOfPlans03();
            checkBox7.setChecked(false);
            checkBox2.setChecked(false);
            checkBox5.setChecked(false);

        }
        //With DD and OS and 3 courses
        else if(checkBox7.isChecked()   && checkBox2.isChecked()   && checkBox4.isChecked() && checkBox5.isChecked())
        {
            setOfPlans04();
            checkBox7.setChecked(false);
            checkBox2.setChecked(false);
            checkBox5.setChecked(false);

        }
        //With DD and oops and 3 courses
        else if(checkBox7.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox5.isChecked() )
        {
            setOfPlans05();
            checkBox7.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox5.setChecked(false);


        }
        else{
            // public void showToastMsg(String Msg) {
            Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_LONG).show();
        }

    }
      //  if (checkBox2.isChecked()) {
           // currentstudent();
           //

    public void setOfPlans1(){
      //  checkBox1.setChecked(false);
        Intent intent = new Intent(FutureStudent.this, Plan1.class);
        startActivity(intent);
    }
    public void setOfPlans2(){
        Intent intent = new Intent(FutureStudent.this, Plan2.class);
        startActivity(intent);
    }
    public void setOfPlans3(){
        Intent intent = new Intent(FutureStudent.this, Plan3.class);
        startActivity(intent);
    }
    public void setOfPlans4(){
        Intent intent = new Intent(FutureStudent.this, Plan4.class);
        startActivity(intent);
    }
    public void setOfPlans5() {
        Intent intent = new Intent(FutureStudent.this, Plan5.class);
        startActivity(intent);
    }



    //  if (checkBox2.isChecked()) {
    // currentstudent();
    //

    public void setOfPlans01(){
        //  checkBox1.setChecked(false);
        Intent intent = new Intent(FutureStudent.this, Plan01.class);
        startActivity(intent);
    }
    public void setOfPlans02(){
        Intent intent = new Intent(FutureStudent.this, Plan02.class);
        startActivity(intent);
    }
    public void setOfPlans03(){
        Intent intent = new Intent(FutureStudent.this, Plan3.class);
        startActivity(intent);
    }
    public void setOfPlans04(){
        Intent intent = new Intent(FutureStudent.this, Plan4.class);
        startActivity(intent);
    }
    public void setOfPlans05(){
        Intent intent = new Intent(FutureStudent.this, Plan5.class);
        startActivity(intent);
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
        getMenuInflater().inflate(R.menu.future_student, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
