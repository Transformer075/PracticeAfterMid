package com.example.practiceapp02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add, update, delete, showData;
    EditText name, age;
    Switch active;
    ListView listViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.addButton);
        update = findViewById(R.id.updateButton);
        delete = findViewById(R.id.deleteButton);
        showData = findViewById(R.id.showButton);
        name = findViewById(R.id.nameField);
        age = findViewById(R.id.ageField);
        active = findViewById(R.id.isActiveField);
        listViewStudent = findViewById(R.id.listField);

        add.setOnClickListener(new View.OnClickListener() {
            StudentData studentData;
            @Override
            public void onClick(View v) {
                try{
                    studentData = new StudentData(name.getText().toString(), Integer.parseInt(age.getText().toString()), active.isChecked());
                    Toast.makeText(MainActivity.this, studentData.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                dbHelper.addStudent(studentData);
            }
        });


    }
}