package com.sjsu.priteshchandaliya.cmpeginie;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;



import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;

public class DiscussionForum extends AppCompatActivity   {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private static final String baseUrl = "http://ec2-54-67-97-100.us-west-1.compute.amazonaws.com/";
    Button post;
    public String category_name;
    EditText question;
    String finalUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_forum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), parent.getSelectedItem()+"category selected", Toast.LENGTH_LONG).show();
                category_name = parent.getSelectedItem().toString();

                System.out.println(category_name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        question = (EditText) findViewById(R.id.editText2);
        post = (Button) findViewById(R.id.button2);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    finalUri = baseUrl + "test.php?category="+ URLEncoder.encode(category_name, "utf-8") + "&question=" + URLEncoder.encode(question.getText().toString(), "utf-8");
                    //  finalUri = URLEncoder.encode(uri, "utf-8");
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                new RequestTask().execute(finalUri);

                Toast.makeText(getBaseContext(), "button clicked", Toast.LENGTH_LONG).show();

            }
        });
    }

    class RequestTask extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... uri) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            String responseString = null;
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
            Intent on_main_list = new Intent(DiscussionForum.this, main_discussion_forum_list.class);
            startActivity(on_main_list);

        }
    }
}





