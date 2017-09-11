package com.mostafaabdel_fatah.volleydemo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView name,email,password;
    String jsonObject = "http://10.0.2.2/MyWebSites/getObject.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.nameTextView);
        email = (TextView) findViewById(R.id.emailTextView);
        password = (TextView) findViewById(R.id.passTextView);
    }

    public void getObject_btnClicked(View view) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    name.setText(response.get("name").toString());
                    email.setText(response.get("email").toString());
                    password.setText(response.get("password").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        SingleTon.getsInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }
}
