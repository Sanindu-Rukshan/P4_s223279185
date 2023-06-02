package com.example.lostandfound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lostandfound.Adapters.AdvertAdapter;
import com.example.lostandfound.DataClasses.Advert;
import com.example.lostandfound.database.AdvertDatabaseHelper;

import java.util.List;

public class CreateAdvert extends AppCompatActivity {

    private EditText etPostType;
    private EditText etName;
    private EditText etPhoneNumber;
    private EditText etDescription;
    private EditText etDate;
    private EditText etLocation;

    private AdvertDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        dbHelper = new AdvertDatabaseHelper(this);
//        etPostType = findViewById(R.id.etPostType);
        etName = findViewById(R.id.etName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etDescription = findViewById(R.id.etDescription);
        etDate = findViewById(R.id.etDate);
        etLocation = findViewById(R.id.etLocation);

        // Initialize your EditText fields

        Button btnSave = findViewById(R.id.btnSave);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioGroup.clearCheck();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postType;
                // Save advert data to the SQLite database here
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.rbLost) {
                    postType = "Lost";
                } else if (selectedId == R.id.rbFound) {
                    postType = "Found";
                } else {
                    // No post type selected
                    Toast.makeText(CreateAdvert.this, "Please select a post type", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = etName.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                String description = etDescription.getText().toString();
                String date = etDate.getText().toString();
                String location = etLocation.getText().toString();

                // Create an Advert object with the entered data and the ID as 0 (placeholder)
                Advert advert = new Advert(0, postType, name, phoneNumber, description, date, location);

                // Save the advert object to the database and get the generated ID
                long id = dbHelper.saveAdvert(advert);

                // Update the ID of the advert object
                advert.setId((int) id);

                Toast.makeText(CreateAdvert.this, "Advert saved successfully ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

}

