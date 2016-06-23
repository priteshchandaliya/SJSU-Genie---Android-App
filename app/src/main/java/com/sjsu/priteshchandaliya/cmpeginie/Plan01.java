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
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Plan01 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ExpandListAdapterFaq ExpAdapter;
    private ArrayList<groupFaq> ExpListItems;
    private ExpandableListView ExpandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan01);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapterFaq(Plan01.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<childFaq> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                // showToastMsg(group_name + "\n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                // showToastMsg(group_name + "\n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                // showToastMsg(group_name + "\n Expanded");

            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<childFaq> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                //  showToastMsg(group_name + "\n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                // showToastMsg(group_name + "\n Expanded");


            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                //showToastMsg(group_name + "\n Expanded");

            }
        });
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
        getMenuInflater().inflate(R.menu.plan01, menu);
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
            Intent intent = new Intent(Plan01.this,PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum)
        {
            // Intent intent = new Intent(Plan01.this,DiscussionForum.class);
            // startActivity(intent);
            // Intent intent = new Intent(Plan01.this, main_discussion_forum_list.class);
            // startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(Plan01.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(Plan01.this, GettingIntoSjsu.class);
            startActivity(intent);
        } else if (id == R.id.nav_camera) {   //Plan Your Schedule
            Intent intent = new Intent(Plan01.this, PlanYourSchedule.class);
            startActivity(intent);


        } else if (id == R.id.nav_accomodation) {
            Intent intent = new Intent(Plan01.this, Accomodation.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public ArrayList<groupFaq> SetStandardGroups() {

        ArrayList<groupFaq> group_list = new ArrayList<groupFaq>();
        ArrayList<childFaq> child_list;

        // Setting Group 1
        child_list = new ArrayList<childFaq>();
        groupFaq gru1 = new groupFaq();
        gru1.setName("Plan 1");

        childFaq ch1_1 = new childFaq();
        ch1_1.setName("1st Sem:\n" +
                "CMPE 180-90\n" +
                "CMPE 180-92\n" +
                "CMPE 190-94\n" +
                "\n" +
                "2nd Sem:\n" +
                "CMPE 200  (Core 1)\n" +
                "CMPE 294 (Technical writing)\n" +
                "CMPE 242 (Specialization 1)\n" +
                "\n" +
                "3rd Sem:\n" +
                "CMPE 220 (Core 2)\n" +
                "CMPE 243 (Specialization 2)\n" +
                "Elective 1\n" +
                "\n" +
                "4th Sem:\n" +
                "CMPE 240 (Core 3)\n" +
                "CMPE 244 (Specialization 3)\n" +
                "CMPE 295A (Project part-1 or thesis or Comprehensive exam)\n" +
                "\n" +
                "5th Sem:\n" +
                "CMPE 295B\n" +
                "Elective 2");
        child_list.add(ch1_1);



        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<childFaq>();
        groupFaq gru2 = new groupFaq();
        gru2.setName("Plan 2");

        childFaq ch2_1 = new childFaq();
        ch2_1.setName("1st Sem:\n" +
                "CMPE 180-92\n" +
                "CMPE 180-94\n" +
                "CMPE 242 (Specialization 1)\n" +
                "\n" +
                "\n" +
                "2nd Sem:\n" +
                "CMPE 180-90\n" +
                "CMPE 200  (Core 1)\n" +
                "CMPE 243 (Specialization 2)\n" +
                "\n" +
                "\n" +
                "3rd Sem:\n" +
                "CMPE 294 (Technical writing)\n" +
                "CMPE 220 (Core 2)\n" +
                "CMPE 244 (Specialization 3)\n" +
                "\n" +
                "\n" +
                "4th Sem:\n" +
                "CMPE 240 (Core 3)\n" +
                "Elective 1\n" +
                "CMPE 295A (Project part-1 or thesis or Comprehensive exam)\n" +
                "\n" +
                "5th Sem:\n" +
                "CMPE 295B\n" +
                "Elective 2");
        child_list.add(ch2_1);

        gru2.setItems(child_list);

        // Setting Group 3
        child_list = new ArrayList<childFaq>();
        groupFaq gru3 = new groupFaq();
        gru3.setName("Plan 3");

        childFaq ch3_1 = new childFaq();
        ch3_1.setName("1st Sem:\n" +
                "CMPE 180-92\n" +
                "CMPE 180-94\n" +
                "CMPE 243 (Specialization 1)\n" +
                "\n" +
                "\n" +
                "2nd Sem:\n" +
                "CMPE 180-90\n" +
                "CMPE 200  (Core 1)\n" +
                "CMPE 244 (Specialization 2)\n" +
                "\n" +
                "\n" +
                "3rd Sem:\n" +
                "CMPE 294 (Technical writing)\n" +
                "CMPE 220 (Core 2)\n" +
                "CMPE 242 (Specialization 3)\n" +
                "\n" +
                "\n" +
                "4th Sem:\n" +
                "CMPE 240 (Core 3)\n" +
                "Elective 1\n" +
                "CMPE 295A (Project part-1 or thesis or Comprehensive exam)\n" +
                "\n" +
                "5th Sem:\n" +
                "CMPE 295B\n" +
                "Elective 2");
        child_list.add(ch3_1);

        gru3.setItems(child_list);

        // Setting Group 4
        child_list = new ArrayList<childFaq>();
        groupFaq gru4 = new groupFaq();
        gru4.setName("Plan 4");

        childFaq ch4_1 = new childFaq();
        ch4_1.setName(
                "1st Sem:\n" +
                        "CMPE 180-90\n" +
                        "CMPE 180-92\n" +
                        "CMPE 190-94\n" +
                        "\n" +
                        "2nd Sem:\n" +
                        "CMPE 200  (Core 1)\n" +
                        "CMPE 220 (Core 2)\n" +
                        "CMPE 243 (Specialization 1)\n" +
                        "\n" +
                        "3rd Sem:\n" +
                        "CMPE 294 (Technical writing)\n" +
                        "CMPE 244 (Specialization 2)\n" +
                        "CMPE 240 (Core 3)\n" +
                        "\n" +
                        "\n" +
                        "4th Sem:\n" +
                        "Elective 1\n" +
                        "CMPE 242 (Specialization 3)\n" +
                        "CMPE 295A (Project part-1 or thesis or Comprehensive exam)\n" +
                        "\n" +
                        "5th Sem:\n" +
                        "CMPE 295B\n" +
                        "Elective 2"
        );
        child_list.add(ch4_1);

        gru4.setItems(child_list);







        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);
        group_list.add(gru3);
        group_list.add(gru4);


        return group_list;
    }

    public void showToastMsg(String Msg) {
        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    }

}


