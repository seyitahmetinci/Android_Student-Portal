package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button alllist = (Button) findViewById(R.id.alllist);
        Button cmpelist = (Button) findViewById(R.id.cmpelist);
        Button cmselist = (Button) findViewById(R.id.cmselist);
        Button blgmlist = (Button) findViewById(R.id.blgmlist);

        ArrayList<Student> studentsList = (ArrayList<Student>) getIntent().getSerializableExtra("Students");
        ArrayList<Student> cmpeList = new ArrayList<>();
        ArrayList<Student> cmseList = new ArrayList<>();
        ArrayList<Student> blgmList = new ArrayList<>();

        for (Student student : studentsList) {
            if (student.getProgram().equals("CMPE")) {
                cmpeList.add(student);
            } else if (student.getProgram().equals("CMSE")) {
                cmseList.add(student);
            } else if (student.getProgram().equals("BLGM")) {
                blgmList.add(student);
            }
        }

        alllist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Students", studentsList);
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        cmpelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Students", cmpeList);
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        cmselist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Students", cmseList);
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        blgmlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Students", blgmList);
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}