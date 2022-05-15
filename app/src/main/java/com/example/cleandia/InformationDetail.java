package com.example.cleandia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InformationDetail extends AppCompatActivity {
    //creating a variable for our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    //creating a variable for our Database Reference for Firebase.
    DatabaseReference databaseReference;

    TextView wasteType, title1, content1, title2, content2;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_detail);

        wasteType = findViewById(R.id.wasteType);
        image = findViewById(R.id.waste_image_detail);
        title1 = findViewById(R.id.title1);
        content1 = findViewById(R.id.content1);
        title2 = findViewById(R.id.title2);
        content2 = findViewById(R.id.content2);

        //get the instance of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        //get reference for our database.
        databaseReference = firebaseDatabase.getReference("Data");

//        // initializing our object class variable.
//        retrieveTV = findViewById(R.id.idTVRetrieveData);
//
//        // calling method
//        // for getting data.
//        getdata();

        if(getIntent().getIntExtra("type",0) == 1) {

            final String waste_type = getIntent().getStringExtra("waste type");
            final int waste_image = getIntent().getIntExtra("image",0);
            wasteType.setText(waste_type);
            image.setImageResource(waste_image);
            getData();

//            String para = "Disposal of agricultural waste, is, in many cases similar to regular waste disposal methods. As in, solid materials are often sent to landfills or incinerators. However, this can obviously have a negative effect on the planet – something which those who work within agriculture are likely to be particularly passionate about. In fact, the future of farming relies on taking care of the planet. Fortunately, there are other methods of agricultural waste disposal, such as composting and recycling which can be implemented to help protect the environment.\n" +
//                    "\n" +
//                    "For example, organic fertilizers can be used again and again, and animal waste (faeces) can be used in composting. Both of which will allow agricultural land to thrive.";
//
//            switch (waste_type){
//                case "Agricultural":
//                    content.setText(para);


            //}
        }

    }

    private void getData() {

        // calling add value event listener method for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime updates in the data.
                // this method is called when the data is changed in our Firebase console.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting our value to our text view in below line.
                content2.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(InformationDetail.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}