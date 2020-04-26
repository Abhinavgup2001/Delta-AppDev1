package com.example.defactor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    public static String streak = "Streak";

    public int streakscored = 0;
    public int lonest = 0;
    public int lonest2=0;
    int m, score = 0, red, green, back, backbutton;
    TextView t, t1, t2;
    Button exit, button1;
    RelativeLayout relativeLayout;
    Vibrator vibrator;
    ArrayList<Button> buttons = new ArrayList<Button>();
    private CountDownTimer countdowntimer;
    private CountDownTimer cdtred;
    private CountDownTimer cdtgreen;
    private static final long Countdown = 16000;
    private long timeLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t = (TextView) findViewById(R.id.textview);
        t1 = (TextView) findViewById(R.id.timer);
        t2 = (TextView) findViewById(R.id.texy);

        buttons.add((Button) findViewById(R.id.textview1));
        buttons.add((Button) findViewById(R.id.textview2));
        buttons.add((Button) findViewById(R.id.textview3));
        buttons.add((Button) findViewById(R.id.textview4));
        button1 = (Button) findViewById(R.id.start);
        exit = (Button) findViewById(R.id.exit);
        relativeLayout = (RelativeLayout) findViewById(R.id.mfm);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        red = Color.parseColor("#ff4221");
        green = Color.parseColor("#40cc1d");

        back = Color.parseColor("#7bdbdb");
        backbutton=Color.parseColor("#faf8f2");


        t2.setText(score + "");

        updateques();


        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(buttons.get(0).getText() + "");

                if ((m % a) == 0) {

                    score = score + 1;
                    streakscored++;
                    t2.setText(score + "");

                    countdowntimer.cancel();
                    bgcolorgreen();

                } else {
                    for(int i=0;i<4;i++){
                        int c=Integer.parseInt(buttons.get(i).getText() + "");
                        if((m%c)==0){
                            buttons.get(i).setBackgroundColor(green);
                            break;
                        }
                    }

                    vibrator.vibrate(400);
                    countdowntimer.cancel();
                    lonest = streakscored;
                    if(lonest>lonest2){
                        lonest2=lonest;
                    }
                    streakscored = 0;
                    bgcolorred();
                }
            }
        });
        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(buttons.get(1).getText() + "");

                if ((m % a) == 0) {

                    score = score + 1;
                    streakscored++;
                    t2.setText(score + "");

                    countdowntimer.cancel();
                    bgcolorgreen();

                } else {
                    for(int i=0;i<4;i++){
                        int c=Integer.parseInt(buttons.get(i).getText() + "");
                        if((m%c)==0){
                            buttons.get(i).setBackgroundColor(green);
                            break;
                        }
                    }

                    vibrator.vibrate(400);
                    countdowntimer.cancel();
                    lonest = streakscored;
                    if(lonest>lonest2){
                        lonest2=lonest;
                    }
                    streakscored = 0;
                    bgcolorred();

                }
            }
        });
        buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(buttons.get(2).getText() + "");

                if ((m % a) == 0) {

                    score = score + 1;
                    streakscored++;
                    t2.setText(score + "");

                    countdowntimer.cancel();
                    bgcolorgreen();

                }
                else {
for(int i=0;i<4;i++){
    int c=Integer.parseInt(buttons.get(i).getText() + "");
    if((m%c)==0){
        buttons.get(i).setBackgroundColor(green);
        break;
    }
}


                    vibrator.vibrate(400);
                    countdowntimer.cancel();
                    lonest = streakscored;
                    if(lonest>lonest2){
                        lonest2=lonest;
                    }
                    streakscored = 0;
                    bgcolorred();

                }
            }
        });
        buttons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(buttons.get(3).getText() + "");

                if ((m % a) == 0) {

                    score = score + 1;
                    streakscored++;
                    t2.setText(score + "");

                    countdowntimer.cancel();
                    bgcolorgreen();


                } else {
                    for(int i=0;i<4;i++){
                        int c=Integer.parseInt(buttons.get(i).getText() + "");
                        if((m%c)==0){
                            buttons.get(i).setBackgroundColor(green);
                            break;
                        }
                    }
                                        vibrator.vibrate(400);
                    countdowntimer.cancel();

                    lonest = streakscored;
                    if(lonest>lonest2){
                        lonest2=lonest;
                    }
                    streakscored = 0;
                    bgcolorred();

                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rintent = new Intent();
                rintent.putExtra(streak, lonest2);
                setResult(RESULT_OK, rintent);
                finish();
            }
        });
    }


    void updateques() {

        m = (int) ((Math.random() * ((400 - 10) + 1)) + 10);
        ArrayList<Integer> factors = new ArrayList<Integer>();
        ArrayList<Integer> nonfactors = new ArrayList<Integer>();

        for (int i = 2; i <= m; i++) {
            if ((m % i) == 0) {
                factors.add(i);
            } else {
                nonfactors.add(i);
            }
        }
        Collections.shuffle(factors);
        Collections.shuffle(nonfactors);
        int k = factors.get(0);
        int l = nonfactors.get(0);
        int n = nonfactors.get(1);
        int f = nonfactors.get(2);


        int j = (int) (Math.random() * (5 - 0 + 1) + 0);
        ;

        if (j == 0) {
            t.setText(m + "");
            buttons.get(2).setText(k + "");
            buttons.get(1).setText(l + "");
            buttons.get(0).setText(n + "");
            buttons.get(3).setText(f + "");


        } else if (j == 1) {
            t.setText(m + "");
            buttons.get(3).setText(k + "");
            buttons.get(0).setText(l + "");
            buttons.get(1).setText(n + "");
            buttons.get(2).setText(f + "");


        } else if (j == 2) {
            t.setText(m + "");
            buttons.get(1).setText(k + "");
            buttons.get(3).setText(l + "");
            buttons.get(2).setText(n + "");
            buttons.get(0).setText(f + "");


        } else if (j == 3) {
            t.setText(m + "");
            buttons.get(1).setText(k + "");
            buttons.get(2).setText(l + "");
            buttons.get(0).setText(n + "");
            buttons.get(3).setText(f + "");


        } else if (j == 4) {
            t.setText(m + "");
            buttons.get(2).setText(k + "");
            buttons.get(3).setText(l + "");
            buttons.get(0).setText(n + "");
            buttons.get(1).setText(f + "");

        } else if (j == 5) {
            t.setText(m + "");
            buttons.get(3).setText(k + "");
            buttons.get(1).setText(l + "");
            buttons.get(0).setText(n + "");
            buttons.get(2).setText(f + "");


        }
        for(int i=0;i<4;i++){
            buttons.get(i).setBackgroundColor(backbutton);
        }
        timeLeft = Countdown;
        tymer();
    }

    void tymer() {
        countdowntimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;

                updatetext();
            }

            @Override
            public void onFinish() {
                timeLeft = 0;
                updatetext();
                for(int i=0;i<4;i++){
                    int c=Integer.parseInt(buttons.get(i).getText() + "");
                    if((m%c)==0){
                        buttons.get(i).setBackgroundColor(green);
                        break;
                    }
                }

                vibrator.vibrate(400);
                streakscored = 0;
                bgcolorred();

            }
        }.start();
    }

    private void updatetext() {
        int minutes = (int) ((timeLeft / 1000) / 60);
        int seconds = (int) ((timeLeft / 1000) % 60);
        String string = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        t1.setText(string);

    }




    public void bgcolorred() {
        cdtred = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                relativeLayout.setBackgroundColor(red);

            }

            @Override
            public void onFinish() {
updateques();
                relativeLayout.setBackgroundColor(back);
            }
        }.start();
    }

    public void bgcolorgreen() {
        cdtgreen = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                relativeLayout.setBackgroundColor(green);

            }

            @Override
            public void onFinish() {

updateques();
relativeLayout.setBackgroundColor(back);
            }
        }.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        countdowntimer.cancel();
    }
}











