package com.example.project12;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.Calendar;
        import java.util.Date;

public class DoctorsList extends AppCompatActivity {
    // Array of strings...
    String[] deviceArray = {"Doctor A","Doctor B","Doctor C","Doctor D","Doctor E",
    };
//    String[] laptopArray = getResources().getStringArray(R.array.laptops);

    ArrayAdapter adapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, deviceArray);

        listView = findViewById(R.id.listViewID);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(DoctorsList.this,ApoinmentDetails.class);

                startActivity(intent);
            }
        });


    }
}