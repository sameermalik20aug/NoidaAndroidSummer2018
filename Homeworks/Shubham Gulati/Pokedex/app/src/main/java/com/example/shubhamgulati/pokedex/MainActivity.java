package com.example.shubhamgulati.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button btnNext;
    Button btnPrev;
    Button btnSearch;
    EditText etId;
    ImageView iv;
    String url;
    int PokeId;
    TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        btnSearch = findViewById(R.id.btnSearch);
        etId = findViewById(R.id.etId);
        tvInfo = findViewById(R.id.tvInfo);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        iv = findViewById(R.id.iv);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PokeId = Integer.parseInt(etId.getText().toString());
                if (PokeId > 0 && PokeId < 803) {
                    //String Pokeid= etId.getText().toString();
                    url = "http://pokeapi.co/api/v2/pokemon/" + PokeId + "/";
                    makeNetworkCall(url);
                    etId.setText("");
                    Toast.makeText(MainActivity.this, "Please wait a sec.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Enter Valid ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PokeId > 0 && PokeId <= 801) {
                    PokeId++;
                    url = "http://pokeapi.co/api/v2/pokemon/" + PokeId + "/";
                    makeNetworkCall(url);
                    Toast.makeText(MainActivity.this, "Please wait a sec.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Enter Valid ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PokeId > 1 && PokeId <= 802) {
                    PokeId--;
                    url = "http://pokeapi.co/api/v2/pokemon/" + PokeId + "/";
                    makeNetworkCall(url);
                    Toast.makeText(MainActivity.this, "Please wait a sec.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Enter Valid ID", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void makeNetworkCall(String url) {
        //make the network call here
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                Gson gson = new Gson();
                final APIResponse apiResponse = gson.fromJson(result,APIResponse.class);
                Log.e("TAG",result);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<stats> stats = apiResponse.getStats();
                       // ArrayList<types> types=apiResponse.getTypes();

                        apiResponse.height= apiResponse.getHeight();
                        ArrayList<types> types = apiResponse.getTypes();
                        String toset="";
                        toset = toset + "Name: "+apiResponse.getName()+
                                "\nRank: "+apiResponse.getId()+
                                "\nWeight: "+apiResponse.getWeight()+
                                "\nHeight: "+apiResponse.getHeight()+
                                "\nBase Experience: "+apiResponse.getBase_experience()+
                                "\n\n";
                        for(stats a : apiResponse.getStats()){
                            toset=toset+a.stat.name+":\n Base Stat -> "+a.base_stat+"\nEffort -> "+a.effort+"\n\n";
                        }
                        //tvInfo.setText(toset);

                        toset=toset+"Type:\n";
                        for(types b : apiResponse.getTypes()){
                            toset = toset +b.type.getName()+"\n";
                        }
                        tvInfo.setText(toset+"\n");



                        //A;
                        //Log.e("HEIGHT",""+apiResponse.getHeight());
//                        tvInfo.setText("Name: "+apiResponse.getName()+
//                                        "\nRank: "+apiResponse.getId()+
//                                        "\nWeight: "+apiResponse.getWeight()+
//                                        "\nHeight: "+apiResponse.getHeight()+
//                                        "\nBase Experience: "+apiResponse.getBase_experience()+
//                                        "\nType: "
//                        );
                        Picasso.get().load(apiResponse.sprites.getFront_default()).placeholder(R.drawable.ic_launcher_background).into(iv);
                    }
                });

            }
        });

    }
}
