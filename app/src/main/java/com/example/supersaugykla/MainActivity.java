package com.example.supersaugykla;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.responseTextView = (TextView) this.findViewById(R.id.responseTextView);

        new GetAllWorkerTask().execute(new ApiConnector());
    }

    public void setTextToTextView(JSONArray jsonArray) {
        String s  = "";
        for(int i=0; i<jsonArray.length();i++){

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);
                s = s +
                        "ID : "+json.getString("ID")+"\n"+
                        "Name : "+json.getString("First Name")+" "+json.getString("Last Name")+"\n"+
                        "Last time started : "+json.getInt("Last time started")+"\n"+
                        "Last time ended : "+json.getInt("Last time ended")+"\n"+
                        "Total hours : "+json.getInt("Total hours")+"\n\n";
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        this.responseTextView.setText(s);
    }


    private class GetAllWorkerTask extends AsyncTask<ApiConnector, Long, JSONArray> {


        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            return params[0].GetAllWorkers();
        }


        @Override
        protected void onPostExecute(JSONArray jsonArray) {
           setTextToTextView(jsonArray);
        }


    }
}
