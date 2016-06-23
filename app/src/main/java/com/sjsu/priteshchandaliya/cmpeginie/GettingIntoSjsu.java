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

public class GettingIntoSjsu extends AppCompatActivity {
    private ExpandListAdapterFaq ExpAdapter;
    private ArrayList<groupFaq> ExpListItems;
    private ExpandableListView ExpandList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_into_sjsu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapterFaq(GettingIntoSjsu.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String group_name = ExpListItems.get(groupPosition).getName();

                ArrayList<childFaq> ch_list = ExpListItems.get(
                        groupPosition).getItems();

                String child_name = ch_list.get(childPosition).getName();

                //showToastMsg(group_name + "\n" + child_name);

                return false;
            }
        });

        ExpandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                //showToastMsg(group_name + "\n Expanded");

            }
        });

        ExpandList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                String group_name = ExpListItems.get(groupPosition).getName();
                // showToastMsg(group_name + "\n Expanded");

            }
        });

    }

    public ArrayList<groupFaq> SetStandardGroups() {

        ArrayList<groupFaq> group_list = new ArrayList<groupFaq>();
        ArrayList<childFaq> child_list;

        // Setting Group 1
        child_list = new ArrayList<childFaq>();
        groupFaq gru1 = new groupFaq();
        gru1.setName("How to Apply?");

        childFaq ch1_1 = new childFaq();
        ch1_1.setName("1. Apply To SJSU At csumentor.edu\n"+"You will receive an application confirmation number" +
                        "\n"+"2. Look for an email with your SJSU ID" +
                        " \n"+"You will receive an" +
                        " email with your nine-digit SJSU ID included.\n"+" 3. Set the password to access your MYSJSU Account\n"+"" +
                        "Go to the below link \n"+"https://sjsuone.sjsu.edu/SJSUOne/ResetPassword " +
                        "\n"+"4. Sign in to your MYSJSU Student Account at HTTP://MY.SJSU.EDU \n"+"" +
                        "5. <strong>Check your MYSJSU Account\n"+"" +
                        "Check for important and timely notices," +
                        " such as admission, fees, financial aid, enrollment appointment, " +
                        "test, and transcript information and deadlines."+
                        "\n"+"6. Meet all Deadlines\n"+"" +
                        "If you have an extreme hardship or unusual circumstance" +
                        " that may cause you to miss one of our deadlines, " +
                        "contact admissions@sjsu.edu immediately!");
        child_list.add(ch1_1);



        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<childFaq>();
        groupFaq gru2 = new groupFaq();
        gru2.setName("International Admission Requirements");

        childFaq ch2_1 = new childFaq();
        ch2_1.setName("1. You must use the International Application if you belong to the following categories:"+

                        "\n"+"(a)Applicants who are applying for an F-1/J-1 visa and currently reside abroad.\n"+

                        "(b)Applicants who currently hold an F-1/J-1 visa and currently reside in the U.S.\n" +
                        "2. Admissions Eligibility –International Applicants" +
                        "\n"+"(a)The completion of a 4-year bachelor’s degree from a recognized, " +
                        "accredited, and approved institution from a foreign country,\n"+
                        "(b)Hold a GPA of at least 2.5 in the last degree completed\n" +
                        "(c)Satisfactorily meet the minimum test scores for the English\n" +
                        "Language Proficiency Exam" +
                        "3. Submit WES evaluation OR official U.S./Canada Transcripts to SJSU");
        child_list.add(ch2_1);

        gru2.setItems(child_list);

        // Setting Group 3
        child_list = new ArrayList<childFaq>();
        groupFaq gru3 = new groupFaq();
        gru3.setName("My SJSU Account");

        childFaq ch3_1 = new childFaq();
        ch3_1.setName("About a week after applying at CSU Mentor, you will" +
                        " receive an email\n"+" with your nine-digit SJSU ID included.\n" +
                        " This nine-digit number will be your <br>primary university " +
                        "identification throughout your career at SJSU.\n " +
                        "Make sure the spam filters on your email account are set to accept email from @sjsu.edu.");
        child_list.add(ch3_1);

        gru3.setItems(child_list);

        // Setting Group 4
        child_list = new ArrayList<childFaq>();
        groupFaq gru4 = new groupFaq();
        gru4.setName("Admission Deadlines");

        childFaq ch4_1 = new childFaq();
        ch4_1.setName("If you miss an SJSU deadline,\n"+"your application will be withdrawn\n for admission." +
                        " If you have an \n extreme hardship or unusual \n circumstance" +
                        " that may cause you\n"+" to miss one of the deadlines,\n" +
                        " contact admissions@sjsu.edu immediately!");
        child_list.add(ch4_1);

        gru4.setItems(child_list);



        // Setting Group 5
        child_list = new ArrayList<childFaq>();
        groupFaq gru5 = new groupFaq();
        gru5.setName("Application Fee Waiver");

        childFaq ch5_1 = new childFaq();
        ch5_1.setName("There is a $55 application fee. California residents or AB540 applicants who face a financial hardship may be eligible for an application fee waiver. Applicants can indicate they would like a fee waiver during the application process for admission to SJSU.");
        child_list.add(ch5_1);

        gru5.setItems(child_list);



        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);
        group_list.add(gru3);
        group_list.add(gru4);
        group_list.add(gru5);


        return group_list;
    }

    //public void showToastMsg(String Msg) {
    // Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT).show();
    //}

}
