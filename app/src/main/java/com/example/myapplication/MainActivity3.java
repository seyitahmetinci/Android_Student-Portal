package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        EditText et_no = (EditText) findViewById(R.id.et_stdno);
        EditText et_name = (EditText) findViewById(R.id.stdname);
        EditText et_surname = (EditText) findViewById(R.id.et_stdsurname);
        RadioGroup radioGroup = findViewById(R.id.radiogroup22);
        RadioButton cmpeButton2 = (RadioButton) findViewById(R.id.radioButton4cmpe);
        RadioButton cmseButton2 = (RadioButton) findViewById(R.id.radioButton5cmse);
        RadioButton blgmButton2 = (RadioButton) findViewById(R.id.radioButton6blgm);


        ArrayList<Student> studentList = (ArrayList<Student>) getIntent().getSerializableExtra("Students");

        Button searchButton = (Button) findViewById(R.id.button9search);
        Button update_button = (Button) findViewById(R.id.button10update);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(et_no.getText().toString());

                for (Student student : studentList){
                    if (student.getId() == id){

                        et_name.setText(student.getName());
                        et_surname.setText(student.getSurname());

                        if (student.getProgram().equals("CMPE")) {
                            cmpeButton2.setChecked(true);
                        } else if (student.getProgram().equals("CMSE")) {
                            cmseButton2.setChecked(true);
                        } else if (student.getProgram().equals("BLGM")) {
                            blgmButton2.setChecked(true);
                        }

                        update_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                student.setName(et_name.getText().toString());
                                student.setSurname(et_surname.getText().toString());
                                if (cmpeButton2.isChecked()) {
                                    student.setProgram("CMPE");
                                } else if (cmseButton2.isChecked()) {
                                    student.setProgram("CMSE");
                                } else if (blgmButton2.isChecked()) {
                                    student.setProgram("BLGM");
                                }

                                Toast.makeText(MainActivity3.this, "Student info updated", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                }

            }
        });

        Button list_button = (Button) findViewById(R.id.button11list);
        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity1.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Students", studentList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }
}