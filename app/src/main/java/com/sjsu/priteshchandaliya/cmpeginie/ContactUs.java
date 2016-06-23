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
import android.widget.TextView;

public class ContactUs extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView text1 = (TextView) findViewById(R.id.priteshtext);
        text1.setTypeface(CmpeGenie.robotoRegular);
        text1.setText("Pritesh Chandaliya\n"+"pritesh.chandaliya@sjsu.edu\n"+"+1-669-245-8477");

        TextView text2 = (TextView) findViewById(R.id.meghatext);
        text2.setTypeface(CmpeGenie.robotoRegular);
        text2.setText("Megha Sobhani\n"+"megha.sobhani@sjsu.edu\n"+"+1-669-247-9609");

        TextView text3 = (TextView) findViewById(R.id.anikettext);
        text3.setTypeface(CmpeGenie.robotoRegular);
        text3.setText("Aniket Kumar\n"+"aniket.kumar@sjsu.edu\n"+"+1-408-717-3733");

        TextView text4 = (TextView) findViewById(R.id.nirmittext);
        text4.setTypeface(CmpeGenie.robotoRegular);
        text4.setText("Nirmit Patel\n"+"nirmit.patel@sjsu.edu\n"+"+1-510-600-9736");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.contact_us, menu);
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
            Intent intent = new Intent(ContactUs.this, PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum) {
            Intent intent = new Intent(ContactUs.this, main_discussion_forum_list.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(ContactUs.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(ContactUs.this, GettingIntoSjsu.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_course){
            Intent intent = new Intent(ContactUs.this, CourseStructure.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_accomodation){
            Intent intent = new Intent(ContactUs.this, Accomodation.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share) {

            String sharingMessage = "Welcome to SJSU Genie! Share the word among all the students of San Jose State University and download the apk file from here";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sharingMessage);
            sendIntent.setType("text/plain");

            //String shareTitle = ContactUs.this.getResources().getString(R.string.share_title) + " " + allTiles.get(pos).getGroupName();
            String shareTitle = "CMPE 220";
            ContactUs.this.startActivity(Intent.createChooser(sendIntent, shareTitle));

        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(ContactUs.this, ContactUs.class);
            startActivity(intent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

