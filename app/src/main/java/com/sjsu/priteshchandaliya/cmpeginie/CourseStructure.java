package com.sjsu.priteshchandaliya.cmpeginie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CourseStructure extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_structure);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<GroupItem> items = new ArrayList<GroupItem>();


        GroupItem item1 = new GroupItem();
        item1.title = "CMPE 200: Computer Architecture";
        ChildItem child = new ChildItem();
        child.title = "Computer design overview, processor instruction set architecture and microarchitecture, instruction-level parallelism, memory hierarchy, storage and I/O systems, multicore/multiprocessor and data/thread-level parallelism, introduction to parallel programming. Prerequisite: Classified graduate standing or graduate advisor consent. Computer Engineering or Software Engineering majors only.";
        child.hint = "Professors: Hyeron Jeon, Chang Shu, Michael Robinson";
        item1.items.add(child);
        items.add(item1);

        GroupItem item2 = new GroupItem();
        item2.title = "CMPE 202: Software Systems Engineering";
        ChildItem child2 = new ChildItem();
        child2.title = "Integrated approach to software design and development including requirements elicitation and analysis, system design and construction through studying multiple facets of software development processes, design methodologies, modeling approaches, and implementation techniques. Prerequisite: Classified graduate standing or instructor consent. Computer Engineering and Software Engineering majors only";
        child2.hint ="Professors: Mohamed Fayad, Paul Nguyen";
        item2.items.add(child2);
        items.add(item2);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GroupItem item3 = new GroupItem();
        item3.title = "CMPE 206: Computer Network Design";
        ChildItem child3 = new ChildItem();
        child3.title = "Network topology and queuing theory. The seven layers of the ISO reference model: physical, data link, network, transport, session, presentation and application. Example networks. Network design project. Prerequisite: Classified graduate standing or instructor consent.";
        child3.hint = "Professors: Rod Fatoohi";
        item3.items.add(child3);
        items.add(item3);

        GroupItem item4 = new GroupItem();
        item4.title = "CMPE 207: Network Programming and Application";
        ChildItem child4 = new ChildItem();
        child4.title = "Development and implementation of networking software for building distributed applications. Application Programming Interfaces: BSD Sockets, Winsock, Remote Procedure Call and Middleware. Network programming project. Prerequisite: CMPE 206, or instructor consent.";
        child4.hint = "Professors: Younghee Park, Wei Xu";
        item4.items.add(child4);
        items.add(item4);

        GroupItem item5 = new GroupItem();
        item5.title = "CMPE 208: Network Architecture and Protocols";
        ChildItem child5 = new ChildItem();
        child5.title = "In-depth study of the principles and architecture of Internet protocols in current practice. Analysis of protocols of network, transport, and application layers. Topics will also cover emerging network architecture and protocols. Network analysis project.. Prerequisite: CMPE 206 or instructor consent.";
        child5.hint = "Professors: Shai Silberman";
        item5.items.add(child5);
        items.add(item5);

        GroupItem item6 = new GroupItem();
        item6.title = "CMPE 209: Network Security";
        ChildItem child6 = new ChildItem();
        child6.title = "Network security protocols and applications, cryptography algorithms, authentication systems, intrusion detection, network attacks and defenses, system-level security issues, and how to build secure systems. Prerequisite: CMPE 206 or EE 281.";
        child6.hint = "Professors: Chao-Li Tarng, Jalel Rejeb";
        item6.items.add(child6);
        items.add(item6);

        GroupItem item8 = new GroupItem();
        item8.title = "CMPE 210: Software-defined Networks and Network Functions Virtualization";
        ChildItem child8 = new ChildItem();
        child8.title = "The course covers development and implementation of Software-defined Networks and Network Functions Virtualization for building programmable network applications. It includes their concepts with various use cases. Students conduct a network programming project related to SDN/NFV by using open source projects. Prerequisite: CMPE 206 (or equivalent graduate network courses) or instructor consent.";
        child8.hint = "Professors: Younghee Park";
        item8.items.add(child8);
        items.add(item8);

        GroupItem item9 = new GroupItem();
        item9.title = "CMPE 212: System Verification";
        ChildItem child9 = new ChildItem();
        child9.title = "Introduction to SoC system configuration and integration; on chip protocols; assertion based verification; code and functional coverage metrics; methodologies, tools, and environments for functional verification of special function blocks (IPs) and integrated SoC-based computer systems. Prerequisite: CMPE 200 and CMPE 264 or instructor consent.";
        child9.hint = "Professors: Herve Alexanian";
        item9.items.add(child9);
        items.add(item9);

        GroupItem item10 = new GroupItem();
        item10.title = "CMPE 219: HCI for Cyber Security";
        ChildItem child10 = new ChildItem();
        child10.title = "The course covers HCI in cyber security that include: authentication and access control, trust, user privacy and data protections, cyber security in social networking, data protection and security in healthcare , cyber security in eCommerce, mobile, computing & cloud computing, compliance and regulation, visualization tools and techniques in cyber security and privacy. Prerequisite: Graduate Standing";
        child10.hint = "Professors: Abbas Moallem";
        item10.items.add(child10);
        items.add(item10);

        GroupItem item11 = new GroupItem();
        item11.title = "CMPE 220: System Software";
        ChildItem child11 = new ChildItem();
        child11.title = "System software overview, assemblers, macro-assemblers, loaders and linkers, compilers and operating systems. Design project. Prerequisite: Classified graduate standing or graduate advisor consent. Computer Engineering and Software Engineering Majors only.";
        child11.hint = "Professors: Kaikai Liu, Badari Eswar";
        item11.items.add(child11);
        items.add(item11);

        GroupItem item12 = new GroupItem();
        item12.title = "CMPE 240: Advanced Computer Design ";
        ChildItem child12 = new ChildItem();
        child12.title = "Architecture of a computing system including system bus, memory subsystems and peripherals. Unidirectional and bidirectional bus architectures. SRAM, SDRAM and FLASH memories. Design of DMA, interrupt controller, transmitter/receiver, timer, display adapter, A/D and D/A converters and other system peripherals. Design of memory and peripheral bus interfaces. Prerequisite: CMPE 127 or instructor consent. Computer Engineering and Software Engineering majors only.";
        child12.hint = "Professors: Harry Li";
        item12.items.add(child12);
        items.add(item12);

        GroupItem item13 = new GroupItem();
        item13.title = "CMPE 242:  Embedded Hardware Design";
        ChildItem child13 = new ChildItem();
        child13.title = "Advanced topics dealing with microprocessor and microcontroller hardware and firmware including processor architecture, advanced memory and I/O systems design, multilevel bus architecture, interrupt systems. Design project. Prerequisite: CMPE 200 or EE 275";
        child13.hint = "Professors: Harry Li, Preetpal Kang";
        item13.items.add(child13);
        items.add(item13);

        GroupItem item14 = new GroupItem();
        item14.title = "CMPE 244: Embedded Software ";
        ChildItem child14 = new ChildItem();
        child14.title = "Experiments dealing with advanced embedded software programming concepts, interfacing techniques, hardware organization and software development using an embedded systems. Individual projects. Prerequisite: CMPE 200, CMPE 220 or instructor consent.";
        child14.hint = "Professors: Preetpal Kang";
        item14.items.add(child14);
        items.add(item14);

        GroupItem item15 = new GroupItem();
        item15.title = "CMPE 264: Advanced Digital and Computing System Design  ";
        ChildItem child15 = new ChildItem();
        child15.title = "Advanced topics in register-transfer-level design of complex digital functional blocks, application-specific instruction set processors, and system-level integration/validation using Verilog/VHDL/C-level hardware description languages. Prerequisite: CMPE 200 or instructor consent.";
        child15.hint = "Professors: Donald Hung";
        item15.items.add(child15);
        items.add(item15);


        GroupItem item16 = new GroupItem();
        item16.title = "CMPE 295A: Master's Project";
        ChildItem child16 = new ChildItem();
        child16.title = "It is recommended to take project part A in your third/fourth semester after clearing all of the pre-requisite, Technical writing (CMPE 294), minimum 2 core and minimum 2 specialization courses. Student should have GPA not less than 3.0.";
        child16.hint = "Project Advisor: Donald Hung, Dan Harkey and other Department Advisors";
        item16.items.add(child16);
        items.add(item16);

        GroupItem item17 = new GroupItem();
        item17.title = "CMPE 295B: Master's Project";
        ChildItem child17 = new ChildItem();
        child17.title = "All the criteria mentioned in CMPE 295A are applicable and additionally - student should successfully complete Project part A, all the 3 core and specialization courses with GPA not less than 3.0.\n";
        child17.hint = "Project Advisor: Donald Hung, Dan Harkey and other Department Advisors";
        item17.items.add(child17);
        items.add(item17);

        GroupItem item18 = new GroupItem();
        item18.title = "CMPE 298I: Internship";
        ChildItem child18 = new ChildItem();
        child18.title = "A student must satisfy all the conditions - Complete all admission conditions, overall SJSU GPA 3.0 or better, satisfactory completion of four CMPE graduate courses including two degree core courses and enroll in CMPE 298I. Student is allowed to work part-time (20 hrs/week) in fall/spring semester and full-time (40 hrs/week) in summer semester.";
        child18.hint = "Professors: Donald Hung";
        item18.items.add(child18);
        items.add(item18);



        adapter = new ExampleAdapter(this);
        adapter.setData(items);

        listView = (AnimatedExpandableListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);
                } else {
                    listView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

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
        getMenuInflater().inflate(R.menu.course_structure, menu);
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

    private static class GroupItem {
        String title;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
        String hint;
    }

    private static class ChildHolder {
        TextView title;
        TextView hint;
    }

    private static class GroupHolder {
        TextView title;
    }

    /**
     * Adapter for our list of {@link GroupItem}s.
     */
    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;
            ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(R.layout.list_item, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                holder.hint = (TextView) convertView.findViewById(R.id.textHint);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.hint.setText(item.hint);

            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(R.layout.group_items, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);

            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)  //plan your schedule
        {
            Intent intent = new Intent(CourseStructure.this, PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum) {
            Intent intent = new Intent(CourseStructure.this, main_discussion_forum_list.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(CourseStructure.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(CourseStructure.this, GettingIntoSjsu.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_course){
            Intent intent = new Intent(CourseStructure.this, CourseStructure.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share) {

            String sharingMessage = "Welcome to SJSU Genie! Share the word among all the students of San Jose State University and download the apk file from here";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sharingMessage);
            sendIntent.setType("text/plain");

            //String shareTitle = CourseStructure.this.getResources().getString(R.string.share_title) + " " + allTiles.get(pos).getGroupName();
            String shareTitle = "CMPE 220";
            CourseStructure.this.startActivity(Intent.createChooser(sendIntent, shareTitle));

        } else if (id == R.id.nav_send) {

            Intent intent = new Intent(CourseStructure.this, ContactUs.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_accomodation){
            Intent intent = new Intent(CourseStructure.this, Accomodation.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
