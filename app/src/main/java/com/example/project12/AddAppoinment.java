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
import android.widget.EditText;
import android.widget.Toast;

public class AddAppoinment extends AppCompatActivity {

    private EditText hospitalname1,doctorsname1,speciality1,date1,time1;
    private Button doctorSubmit;
    DBHelper DB1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appoinment);
        hospitalname1=findViewById(R.id.hospitalName);
        doctorsname1=findViewById(R.id.doctorsName);
        speciality1=findViewById(R.id.speciality);
        date1=findViewById(R.id.date);
        time1=findViewById(R.id.doctorsTime);
        doctorSubmit=findViewById(R.id.addDoctor);

        DB1= new DBHelper(this);



        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){

            NotificationChannel channel=new NotificationChannel("MyNotification","MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        doctorSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hospitalname = hospitalname1.getText().toString();
                String doctorsname = doctorsname1.getText().toString();
                String speciality = speciality1.getText().toString();
                String date = date1.getText().toString();
                String time = time1.getText().toString();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(AddAppoinment.this,"MyNotification");
                builder.setContentTitle("Notification");
                builder.setContentText("Your Appoinment Has Been Added,\n Thank you");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat mc = NotificationManagerCompat.from(AddAppoinment.this);
                mc.notify(1,builder.build());






                if(hospitalname.equals("")||doctorsname.equals("")||speciality.equals("")||date.equals("")||time.equals("")) {
                    Toast.makeText(AddAppoinment.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean insert = DB1.insertHospital(hospitalname,doctorsname,speciality,date,time);

                    if(insert==true) {
                        Toast.makeText(AddAppoinment.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(AddAppoinment.this, "Registered unsuccessfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}