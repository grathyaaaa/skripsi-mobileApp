package com.example.input;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VitalSingsActivity extends AppCompatActivity {

    private static final String TAG = "VitalSign";
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
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String heartRate = dataSnapshot.child("heartRate").getValue().toString();
                    textHeartRate.setText(heartRate);
                    String respiratoryRate = dataSnapshot.child("respiratoryRate").getValue(String.class);
                    textRespiratoryRate.setText(respiratoryRate);
                    String temperature = dataSnapshot.child("temperature").getValue(String.class);
                    textTemperature.setText(temperature);
                }

//                if (vitalSign == null) {
//                    Log.e(TAG, "User data is null!");
//                    return;
//                }

//                VitalSigns vitalSigns = snapshot.getValue(VitalSigns.class);
//
//                vitalSigns = snapshot.getValue(VitalSigns.class);
//                assert vitalSigns != null;
//                String heartRate = snapshot.child("heartRate").getValue(String.class);
//                textHeartRate.setText(heartRate);
//                textHeartRate.setText(vitalSigns.getHeartRate());
//                textRespiratoryRate.setText(vitalSigns.getRespiratoryRate());
//                textTemperature.setText(vitalSigns.getTemperature());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "VitalSignActivity:onCancelled", error.toException());
            }
        });

    }

}