package com.example.project12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ApoinmentDetails extends AppCompatActivity {



    private TextView t1,t2,t3;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoinment_details);

        b1=findViewById(R.id.make_done_btn);
        t1=findViewById(R.id.patient_name);
        t2=findViewById(R.id.patient_age);
        t3=findViewById(R.id.contuct);

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){

            NotificationChannel channel=new NotificationChannel("MyNotification","MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        String s1=t1.getText().toString();
        String s2=t2.getText().toString();
        String s3=t3.getText().toString();




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s1=t1.getText().toString();
                String s2=t2.getText().toString();
                String s3=t3.getText().toString();
                if(s1.equals("")|| s2.equals("")||s3.equals("")){
                    Toast.makeText(ApoinmentDetails.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(ApoinmentDetails.this,"MyNotification");
                    builder.setContentTitle("Notification");
                    builder.setContentText("Your Appoinment Has Been Made, Thank You");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat mc = NotificationManagerCompat.from(ApoinmentDetails.this);
                    mc.notify(1,builder.build());

                }
            }
        });
    }
}