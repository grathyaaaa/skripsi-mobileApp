package com.example.input;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class VitalSignsActivity extends AppCompatActivity {

    VitalSigns vitalSigns;
    TextView textHeartRate;
    TextView textRespiratoryRate;
    TextView textTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs);

        vitalSigns = new VitalSigns();

        textHeartRate = findViewById(R.id.textView_heartRate);
        textRespiratoryRate = findViewById(R.id.textView_respiratoryRate);
        textTemperature = findViewById(R.id.textView_temperature);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("vitalsigns/");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String heartRate = String.valueOf(snapshot.child("heartRate").getValue());
                textHeartRate.setText(heartRate);
                String respiratoryRate = String.valueOf(snapshot.child("respiratoryRate").getValue());
                textRespiratoryRate.setText(respiratoryRate);
                String temperature = String.valueOf(snapshot.child("temperature").getValue());
                textTemperature.setText(temperature);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}