package com.example.project12;



import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

public class HospitalList extends AppCompatActivity {
    // Array of strings...
    String[] deviceArray = {"Hospital A","Hospital B","Hospital C","Hospital D","Hospital E","Hospital F","Hospital G","Hospital H","Hospital I",
    };
//    String[] laptopArray = getResources().getStringArray(R.array.laptops);

    ArrayAdapter adapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appoinment);

        adapter = new ArrayAdapter<String>(this, R.layout.list_view_item, deviceArray);

        listView = findViewById(R.id.listViewID);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HospitalList.this,Speciality.class);

                startActivity(intent);
            }
        });


    }
}