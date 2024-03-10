package com.example.java_room_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
//orm- object relational mapping->database data to objects without long queries
//abstract layer on top of sqlite database
//entity-create table
//dao-database access object- provides methods to interact with data in table

public class MainActivity extends AppCompatActivity {

    EditText person_name,person_age;
    Button save,load;
    TextView person_result;
   PersonDatabase personDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person_name=findViewById(R.id.person_name);
        person_age=findViewById(R.id.person_age);
        person_result=findViewById(R.id.person_result);
        save=findViewById(R.id.button);
        load=findViewById(R.id.button2);
        personDatabase= Room.databaseBuilder(this,PersonDatabase.class,"john")
                        .allowMainThreadQueries()
                                .build();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=person_name.getText().toString();
                int age= Integer.parseInt(person_age.getText().toString());
                  personDatabase.getDao().insertData(new Person(name,age));
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            person_name.getText().clear();
            person_age.getText().clear();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Person> personList=personDatabase.getDao().getData();
                for(Person person:personList){
                    person_result.append(person.getId()+" "+person.getName()+" "+person.getAge()+"\n");
                }
            }
        });
    }
}