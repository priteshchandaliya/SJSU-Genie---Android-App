package com.sjsu.priteshchandaliya.cmpeginie;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main_discussion_forum_list extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public ListView listView;
    public ArrayList<String> listItems = new ArrayList<String>();
    private Map<String, ArrayList<String>> categoriesMap = new HashMap<String, ArrayList<String>>();;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_discussion_forum_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView = (ListView) findViewById(R.id.list_view_ques);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                try {
                    String entry = (String) parent.getAdapter().getItem(position);
                    listItems.clear();
                    listItems.add(entry);
                    ArrayList<String> tempList = categoriesMap.get(entry);
                    for (int i = 0; i < tempList.size(); i++) {
                        listItems.add(Integer.toString(i + 1) + ". " + tempList.get(i));
                    }
                    listView.invalidate();
                    ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();

                }catch (Exception e){

                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        print_questions();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (flag == 0) {
                listItems.clear();
                listItems.addAll(categoriesMap.keySet());
                listView.invalidate();
                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
                flag = 1;
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        FloatingActionButton fab_post = (FloatingActionButton) findViewById(R.id.fab);
        fab_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent migrate_to_dic = new Intent(main_discussion_forum_list.this, DiscussionForum.class);
                startActivity(migrate_to_dic);

            }
        });
        getMenuInflater().inflate(R.menu.main_discussion_forum_list, menu);
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
            Intent intent = new Intent(main_discussion_forum_list.this, PlanYourSchedule.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.discussion_forum) {
            Intent intent = new Intent(main_discussion_forum_list.this, main_discussion_forum_list.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow)    //FAQs
        {
            Intent intent = new Intent(main_discussion_forum_list.this, faq.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage)   //Gettting into SJSU
        {
            Intent intent = new Intent(main_discussion_forum_list.this, GettingIntoSjsu.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void print_questions()
    {

        new RequestTask().execute("http://ec2-54-67-97-100.us-west-1.compute.amazonaws.com/print.php");
        Toast.makeText(getBaseContext(), "button clicked", Toast.LENGTH_LONG).show();
    }

    class RequestTask extends AsyncTask<String, String, String> {

        private String responseString = null;

        @Override
        protected String doInBackground(String... uri) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            //String responseString = null;
            try {
                response = httpclient.execute(new HttpGet(uri[0]));
                StatusLine statusLine = response.getStatusLine();
                if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    responseString = out.toString();
                    out.close();
                } else{
                    //Closes the connection.
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
                //TODO Handle problems..
            } catch (IOException e) {
                //TODO Handle problems..
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            System.out.println(result);
            //parse json data
            try {
                JSONArray jArray = new JSONArray(result);
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json = jArray.getJSONObject(i);
                    String category = json.getString("category");
                    String question = json.getString("question");
                    if (categoriesMap.containsKey(category)){
                        ArrayList<String> tempList = categoriesMap.get(category);
                        if (! tempList.contains(question))
                            categoriesMap.get(category).add(question);
                    }
                    else{
                        ArrayList<String> questions = new ArrayList<String>();
                        questions.add(question);
                        categoriesMap.put(category, questions);
                    }
                    System.out.println(json);
                }
            }catch (Exception e){

            }
            listItems.clear();
            listItems.addAll(categoriesMap.keySet());
            listView.invalidate();
            ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
        }
    }
}


