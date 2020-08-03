package com.example.input;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    RiskFactors riskFactors;
    String stringGender;
    String stringHypertension;
    String stringHeartDisease;
    String stringDm;
    String stringSmoking;
    Button btnSave;
    private DatabaseReference databaseReference;
    private EditText editTextName;
    private EditText editTextAge;
    private RadioGroup rgGender;
    private RadioGroup rgHypertension;
    private RadioGroup rgHeartDisease;
    private RadioGroup rgDm;
    private RadioGroup rgSmoking;
    private RadioButton genderOption;
    private RadioButton hypertensionOption;
    private RadioButton hdOption;
    private RadioButton dmOption;
    private RadioButton smokingOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        riskFactors = new RiskFactors();

        editTextName = findViewById(R.id.edt_name);
        editTextAge = findViewById(R.id.edt_age);
        rgGender = findViewById(R.id.radioGroup_gender);
        rgHypertension = findViewById(R.id.radioGroup_hyper);
        rgHeartDisease = findViewById(R.id.radioGroup_hd);
        rgDm = findViewById(R.id.radioGroup_dm);
        rgSmoking = findViewById(R.id.radioGroup_smoking);
        btnSave = findViewById(R.id.button_save);
        ImageView imageViewVitalSign = findViewById(R.id.imageView_vitalSign);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAndGetData()) {
                    saveData();
                } else {
                    Toast.makeText(MainActivity.this, "invalid data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageViewVitalSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.imageView_vitalSign) {
                    Intent moveIntent = new Intent(MainActivity.this, VitalSingsActivity.class);
                    startActivity(moveIntent);
                } else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveData() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        long millis = calendar.getTimeInMillis();

        databaseReference.child("riskFactors").child(year + "-" + month + "-" + date + "-" + millis).setValue(riskFactors)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data saved successfully ", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Data failed to save", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private boolean checkAndGetData() {
        boolean valid = true;
        riskFactors.name = editTextName.getText().toString().trim();
        riskFactors.age = editTextAge.getText().toString().trim();



        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                genderOption = rgGender.findViewById(checkedId);
                stringGender = genderOption.getText().toString().trim();
                riskFactors.gender = stringGender.equals("Man");
            }
        });

        rgHypertension.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                hypertensionOption = rgHypertension.findViewById(checkedId);
                stringHypertension = hypertensionOption.getText().toString().trim();
                riskFactors.hypertension = stringHypertension.equals("Yes");
            }
        });

        rgHeartDisease.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                hdOption = rgHeartDisease.findViewById(checkedId);
                stringHeartDisease = hdOption.getText().toString().trim();
                riskFactors.heartDisease = stringHeartDisease.equals("Yes");
            }
        });

        rgDm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                dmOption = rgDm.findViewById(checkedId);
                stringDm = dmOption.getText().toString().trim();
                riskFactors.dm = stringDm.equals("Yes");

            }
        });

        rgSmoking.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                smokingOption = rgSmoking.findViewById(checkedId);
                stringSmoking = smokingOption.getText().toString().trim();
                riskFactors.smoking = stringSmoking.equals("Yes");

            }
        });

        if (isEmpty(riskFactors.name)) {
            valid = false;
            editTextName.setError("Tidak boleh kosong");
        } else {
            editTextName.setError(null);
        }
        if (isEmpty(riskFactors.age)) {
            valid = false;
            editTextAge.setError("Tidak boleh kosong");
        } else {
            editTextAge.setError(null);
        }

        return valid;
    }

}

