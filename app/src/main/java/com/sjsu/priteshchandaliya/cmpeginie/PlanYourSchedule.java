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
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class PlanYourSchedule extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_your_schedule2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView txtView = (TextView) findViewById(R.id.departmentInfo);
        txtView.setText(Html.fromHtml("<br><h1><strong><font color=#0000FF>Program Scope</font></strong></h1><em>The MS CMPE program currently has three areas of specialization:</em><br>" +
                "<br><ul><font color=#000000> " +
                "<li><font color=#000000>Network Systems</font></li><br>" +
                "<li><font color=#000000>Embedded Systems</font></li><br>" +
                "<li><font color=#000000>Secure Systems</font></li>" +
                "</font></ul>" +
                "    <br><h1><strong><font color=#0000FF>Course-taking Sequence</font></strong></h1><em>The appropriate course-taking sequence is shown below:</em>" +
                "<br><br><ol><li><font color=#000000>1. Condition courses</font></li><br>" +
                "<li><font color=#000000>2. Program Core Courses</font></li><br>" +
                "<li><font color=#000000>3. Specialization Core courses</font></li><br>" +
                "<li><font color=#000000>4. Technical electives</font></li><br>" +
                "<li><font color=#000000>5. Master Projects(CMPE295A, CMPE295B), or Thesis(CMPE 299A, CMPE299B), or Comprehensive exam(CMPE298) and more technical electives.</font></ol></string>\n"));

        TextView textView2 = (TextView) findViewById(R.id.text1);
        textView2.setTypeface(CmpeGenie.robotoRegular);

        TextView textView3 = (TextView) findViewById(R.id.future);
        textView3.setTypeface(CmpeGenie.robotoMedium);

        TextView textView4 = (TextView) findViewById(R.id.current);
        textView4.setTypeface(CmpeGenie.robotoMedium);

        TextView textView5 = (TextView) findViewById(R.id.departmentInfo);
        textView5.setTypeface(CmpeGenie.robotoRegular);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public void plans(View view){
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.future);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.current);
        if (checkBox1.isChecked()) {
            futurestudent();
            checkBox1.setChecked(false);
        }
        if (checkBox2.isChecked()) {
            currentstudent();
            checkBox2.setChecked(false);
        }
    }

    public void futurestudent()
    {
        Intent intent = new Intent(PlanYourSchedule.this, FutureStudent.class);
        startActivity(intent);
    }
    public void currentstudent()
    {

        Intent intent2 = new Intent(PlanYourSchedule.this, CurrentStudent.class);
        startActivity(intent2);
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
        getMenuInflater().inflate(R.menu.plan_your_schedule, menu);
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
            Intent intent = new Intent(PlanYourSchedule.this, PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum) {
            Intent intent = new Intent(PlanYourSchedule.this, main_discussion_forum_list.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(PlanYourSchedule.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(PlanYourSchedule.this, GettingIntoSjsu.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_course){
            Intent intent = new Intent(PlanYourSchedule.this, CourseStructure.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share) {

            String sharingMessage = "Welcome to SJSU Genie! Share the word among all the students of San Jose State University and download the apk file from here";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sharingMessage);
            sendIntent.setType("text/plain");

            //String shareTitle = PlanYourSchedule.this.getResources().getString(R.string.share_title) + " " + allTiles.get(pos).getGroupName();
            String shareTitle = "CMPE 220";
            PlanYourSchedule.this.startActivity(Intent.createChooser(sendIntent, shareTitle));

        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(PlanYourSchedule.this, ContactUs.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_accomodation){
            Intent intent = new Intent(PlanYourSchedule.this, Accomodation.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PlanYourSchedule Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.sjsu.priteshchandaliya.cmpeginie/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PlanYourSchedule Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.sjsu.priteshchandaliya.cmpeginie/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
