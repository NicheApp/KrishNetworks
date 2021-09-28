package com.nishkarsh.kirishnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nishkarsh.kirishnetwork.model.Data;
import com.nishkarsh.kirishnetwork.model.OtherMandi;
import com.nishkarsh.kirishnetwork.model.Root;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity2 extends AppCompatActivity {
    ListView listView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdatausing_retrofit);
       listView = findViewById(R.id.listview);
        SharedPreferences prefs=getSharedPreferences("MyPref",MODE_PRIVATE);
        //txt=findViewById(R.id.txt);

        getMandi();
    }

    private void getMandi() {
       Call<Root> call= RetrofitClient.getInstance().getMyApi().getMandi("8.44108136","77.0526054","89","hi","10");
       call.enqueue(new Callback<Root>() {
           @Override
           public void onResponse(Call<Root> call, Response<Root> response) {
             // txt.setText( response.body().status.toString());

          List<OtherMandi> othermandi=  response.body().data.other_mandi;
          List<String> ls =new ArrayList<>();
          for(int i=0;i<othermandi.size();i++){
              ls.add(i +". "+" District : "+ othermandi.get(i).getDistrict()+" Cropname :" + othermandi.get(i).getHindi_name()+" km :\n"+ othermandi.get(i).getKm()+
              " last_date : "+ othermandi.get(i).getLast_date() );
          }
               //displaying the string array into listview
               listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, ls));
           }

           @Override
           public void onFailure(Call<Root> call, Throwable t) {

           }
       });
    }
}