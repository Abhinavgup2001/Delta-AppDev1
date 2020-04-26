package com.example.defactor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final int code=1;
    public String Shared_Pref= "sharpre";
    public String Key_Streak="keystreak";
    private int highscore;
    private TextView texthighscore;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.open);
        texthighscore=(TextView)findViewById(R.id.highscore);
        gethighscore();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,code);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == code){
            if(resultCode==RESULT_OK){
                int streakscore=data.getIntExtra(Main2Activity.streak,0);
                if(streakscore>highscore)
                    updatescore(streakscore);
            }
        }
    }
    private void gethighscore(){
        SharedPreferences sharedPreferences = getSharedPreferences(Shared_Pref,MODE_PRIVATE);
        highscore=sharedPreferences.getInt(Key_Streak,0);
        texthighscore.setText("LONGEST STREAK : "+ highscore);



    }
    protected void updatescore(int hs){
        highscore=hs;
        texthighscore.setText("LONGEST STREAK : "+ highscore);
        SharedPreferences sp= getSharedPreferences(Shared_Pref,MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(Key_Streak,highscore);
        edit.apply();

    }
}
