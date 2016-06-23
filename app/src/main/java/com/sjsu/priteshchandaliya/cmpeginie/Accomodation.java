package com.sjsu.priteshchandaliya.cmpeginie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
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

public class Accomodation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public void faq(View view){
        Uri uriUrl = Uri.parse("http://www.housing.sjsu.edu/faqs/faq-at-front-page/index.html");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
      /*  Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.housing.sjsu.edu/faqs/faq-at-front-page/index.html"));
        startActivity(intent);*/
    }
    public void onCampus(View view){
        Uri uriUrl = Uri.parse("https://sjsu.starrezhousing.com/StarRezPortal/Default.aspx?Params=L9ezxPcQnQuRGKTzF%2b4sxeNblvAA%2b26c");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
     /*   Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://sjsu.starrezhousing.com/StarRezPortal/Default.aspx?Params=L9ezxPcQnQuRGKTzF%2b4sxeNblvAA%2b26c"));
        startActivity(intent);*/
    }
    public void offCampus(View view) {
        Uri uriUrl = Uri.parse("http://www.housing.sjsu.edu/housingaz/offcampushousingresources/");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
     /*   Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.housing.sjsu.edu/housingaz/offcampushousingresources/"));
        startActivity(intent);*/
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView text1 = (TextView) findViewById(R.id.text1);
        text1.setTypeface(CmpeGenie.robotoRegular);
        TextView txtView = (TextView) findViewById(R.id.text2);
        txtView.setTypeface(CmpeGenie.robotoThin);

        String detail = " <br>University Housing Services strives to create a residential community that supports and enhances academic success, fosters the learning and development of our students, and promotes student involvement and civic engagement.  " +
                "As a department, our practices promote efficiency, operational effectiveness and" +
                " fiscal responsibility.";
        txtView.setText(Html.fromHtml(detail));

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
        getMenuInflater().inflate(R.menu.accomodation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)  //plan your schedule
        {
            Intent intent = new Intent(Accomodation.this, PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum) {
            Intent intent = new Intent(Accomodation.this, main_discussion_forum_list.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(Accomodation.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(Accomodation.this, GettingIntoSjsu.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_course){
            Intent intent = new Intent(Accomodation.this, CourseStructure.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share) {

            String sharingMessage = "Welcome to SJSU Genie! Share the word among all the students of San Jose State University and download the apk file from here";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sharingMessage);
            sendIntent.setType("text/plain");

            //String shareTitle = Accomodation.this.getResources().getString(R.string.share_title) + " " + allTiles.get(pos).getGroupName();
            String shareTitle = "CMPE 220";
            Accomodation.this.startActivity(Intent.createChooser(sendIntent, shareTitle));

        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(Accomodation.this, ContactUs.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_accomodation){
            Intent intent = new Intent(Accomodation.this, Accomodation.class);
            startActivity(intent);
        }    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
