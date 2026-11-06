package com.example.clv_ds7;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ShowStudentsActivity extends AppCompatActivity {
    ArrayList<Student> students;
    RecyclerView rvStudent;
    StudentAdapter adapter;

    FloatingActionButton fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_students);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        fab_add.setOnClickListener((v)->{

            // dialog code
            showAddStudentDialog();

        });
    }

    private void showAddStudentDialog()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Creating New Student....");
        View view = LayoutInflater.from(this).inflate(R.layout.create_student_form_dialog_design, null, false);
        dialogBuilder.setView(view);

        TextInputEditText etid = view.findViewById(R.id.etId);
        TextInputEditText etName = view.findViewById(R.id.etname);
        TextInputEditText etSem = view.findViewById(R.id.etSem);
        TextInputEditText etGender = view.findViewById(R.id.etGender);

        dialogBuilder.setPositiveButton("Save", (a, b)->{
            Student s = new Student();
            s.setId(Integer.parseInt(etid.getText().toString()));
            s.setName(etName.getText().toString());
            s.setSem(Integer.parseInt(etSem.getText().toString()));
            s.setGender(etGender.getText().toString());

            students.add(s);
            //adapter.notifyItemInserted(students.size()-1);

            Toast.makeText(this, "Student added...", Toast.LENGTH_SHORT).show();
        });
        dialogBuilder.setNegativeButton("Cancel", (a, b)->{});

        dialogBuilder.create().show();
    }

    private void init()
    {
        students = new ArrayList<>();


        rvStudent = findViewById(R.id.rvStudents);

        adapter = new StudentAdapter(this, students);

        rvStudent.setHasFixedSize(true);
        rvStudent.setLayoutManager(new LinearLayoutManager(this));
        rvStudent.setAdapter(adapter);

        fab_add = findViewById(R.id.fab_add);
    }
}