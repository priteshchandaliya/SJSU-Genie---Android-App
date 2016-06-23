package com.sjsu.priteshchandaliya.cmpeginie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class planNetworking extends AppCompatActivity {
    private ExpandListAdapterPlan ExpAdapter;
    private ArrayList<groupFaq> ExpListItems;
    private ExpandableListView ExpandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapterPlan(planNetworking.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<childFaq> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                showToastMsg(group_name + "\n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "\n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                showToastMsg(group_name + "\n Expanded");

            }
        });

    }

    public ArrayList<groupFaq> SetStandardGroups() {

        ArrayList<groupFaq> group_list = new ArrayList<groupFaq>();
        ArrayList<childFaq> child_list;

        // Setting Group 1
        child_list = new ArrayList<childFaq>();
        groupFaq gru1 = new groupFaq();
        gru1.setName("What is the minimum number of courses I should take per semester?");

        childFaq ch1_1 = new childFaq();
        ch1_1.setName("You must enroll in at least one class in order to retain your student status. If you are on F1 visa, you must enroll in at least 9 units (3 courses) such as CMPE 180-92, CMPE 180-94, and CMPE 200.");
        child_list.add(ch1_1);



        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<childFaq>();
        groupFaq gru2 = new groupFaq();
        gru2.setName("Can I take a class without completing all prerequisites?");

        childFaq ch2_1 = new childFaq();
        ch2_1.setName("Except CMPE 200 and 220, the instructor, not graduate advisor, makes decisions. If you believe you have sufficient background to take the class, you can enroll in the class and then request the instructor's consent. If the instructor denies your request, you must drop the class during the first two weeks of the semester. Graduate advisor enforces the prerequisites of CMPE 200 and 220 without exceptions.");
        child_list.add(ch2_1);

        gru2.setItems(child_list);

        // Setting Group 3
        child_list = new ArrayList<childFaq>();
        groupFaq gru3 = new groupFaq();
        gru3.setName("What are the differences between a master project and master thesis?");

        childFaq ch3_1 = new childFaq();
        ch3_1.setName("A thesis has a more rigid requirements of contents and reporting style. A project-track student must enroll in CMPE 295A and CMPE 295B in two consecutive semesters A thesis-track student must enroll in CMPE 299A and CMPE 299B in two consecuive semesters. Summer enrollments are optional.");
        child_list.add(ch3_1);

        gru3.setItems(child_list);

        // Setting Group 4
        child_list = new ArrayList<childFaq>();
        groupFaq gru4 = new groupFaq();
        gru4.setName("When shall I remove my admission conditions?");

        childFaq ch4_1 = new childFaq();
        ch4_1.setName("You should complete all admission conditions as soon as possible to avoid the delay of your graduation. However, it is not mandatory for you to satisfy the admission conditions during a specific semester. Some courses have the prerequisites of satisfying these conditions. You can’t take CMPE 200 or 240 without satisfying the Digital Design condition. Likewise, you can’t take CMPE 220 without satisfying both Object-Oriented Programming and Operating Systems Design conditions. In addition, a student can't take CMPE 295A before satisfying all admission conditions.");
        child_list.add(ch4_1);

        gru4.setItems(child_list);



        // Setting Group 5
        child_list = new ArrayList<childFaq>();
        groupFaq gru5 = new groupFaq();
        gru5.setName("The time overlap of two courses prevents me to enroll into either one. What shall I do?");

        childFaq ch5_1 = new childFaq();
        ch5_1.setName("You can only enroll into one of them. The Graduate Advisor is not assigned to schedule the classes of the department. The department will post additional sections, if any, on the the schedule section of mySJSU. If the overlap time is less than 15 minutes, you might be able to enroll into both classes by filing a course overlap form to the department office.");
        child_list.add(ch5_1);

        gru5.setItems(child_list);

        // Setting Group 6
        child_list = new ArrayList<childFaq>();
        groupFaq gru6 = new groupFaq();
        gru6.setName("How late can I add or drop a class without penalty?");

        childFaq ch6_1 = new childFaq();
        ch6_1.setName("Courses may be added or dropped without penalty during the first fourteen days of classes. See the Calendar section of www.sjsu.edu/registrar for exact dates and deadlines.Courses dropped during this initial period will not appear on the student's transcript.");
        child_list.add(ch6_1);

        gru6.setItems(child_list);

        // Setting Group 7
        child_list = new ArrayList<childFaq>();
        groupFaq gru7 = new groupFaq();
        gru7.setName("What is the maximum course load?");

        childFaq ch7_1 = new childFaq();
        ch7_1.setName("There is no maximum load limit. In general, a student should not take more than 9 units of graduate courses.");
        child_list.add(ch7_1);

        gru7.setItems(child_list);

        // Setting Group 8
        child_list = new ArrayList<childFaq>();
        groupFaq gru8 = new groupFaq();
        gru8.setName("What is the minimum load for an international students?");

        childFaq ch8_1 = new childFaq();
        ch8_1.setName("Full load (9 units) per semester is required. If a student takes less than 9 units of a semester, the student must file a Reduced Load Request during the first week of the semester. The approval of a request is based on the student’s specific situation such as “the last semester”, etc. The student must go to the department office to submit a Reduced Course Load” request.");
        child_list.add(ch8_1);

        gru8.setItems(child_list);

        // Setting Group 9
        child_list = new ArrayList<childFaq>();
        groupFaq gru9 = new groupFaq();
        gru9.setName("Can I transfer graduate credits from other graduate schools and/or SJSU Open University?");

        childFaq ch9_1 = new childFaq();
        ch9_1.setName("You can transfer up to 9 semester units. Transfer credit work can be courses taken at another university (in graduate standing only), SJSU Open University courses, or courses that were taken during the last semester as an SJSU senior. A course can't be transferred if is counted as part of the study program of another degree.\n" +
                "Transfer work must be from institutions that were listed on your initial application to SJSU and must be from an accredited institution. Other restrictions are indicated in the university catalog.\n" +
                "Requests to transfer Open University courses to the MS in Computer Engineering degree program will be denied if an application to the MS in Computer Engineering program was submitted while the course was in progress.\n" +
                "After the first week of each semester, a student can submit a package for each transferring course to the department office per the instructions listed on “Transfer non-SJSU or Open University course request form” (http://cmpe.sjsu.edu/content/request-forms)");
        child_list.add(ch9_1);

        gru9.setItems(child_list);

        // Setting Group 10
        child_list = new ArrayList<childFaq>();
        groupFaq gru10 = new groupFaq();
        gru10.setName("What paperwork should I complete before my graduation?");

        childFaq ch10_1 = new childFaq();
        ch10_1.setName("You should submit the following:\n" +
                "1. A petition for Advancement to Candidacy by filing the Departmental Request for Candidacy and Graduate Degree Program Form (Candidacy form in short).\n" +
                "2. An application for award of MS degree by filing the Application for Award of Master’s Degree Form (Degree form in short).\n" +
                "3. Your thesis or project final report.");
        child_list.add(ch10_1);

        gru10.setItems(child_list);

        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);
        group_list.add(gru3);
        group_list.add(gru4);
        group_list.add(gru5);
        group_list.add(gru6);
        group_list.add(gru7);
        group_list.add(gru8);
        group_list.add(gru9);
        group_list.add(gru10);

        return group_list;
    }

    public void showToastMsg(String Msg) {
        Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    }

}
