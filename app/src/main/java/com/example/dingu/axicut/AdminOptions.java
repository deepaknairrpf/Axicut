package com.example.dingu.axicut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AdminOptions extends AppCompatActivity {

    ListView adminOptionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        adminOptionsList = (ListView)findViewById(R.id.adminOptionList);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,android.R.id.text2,getResources().getStringArray(R.array.adminOptions));

        adminOptionsList.setAdapter(adapter);
        adminOptionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    case 0:
                        // add a user
                        break;
                    case 1:
                        // remove a user
                        break;
                    case 2:
                        // add a company
                        break;
                    case 3:
                        // remove a company
                        break;
                    case 4:
                        // search workorders
                        break;


                }
            }
        });

    }
}
