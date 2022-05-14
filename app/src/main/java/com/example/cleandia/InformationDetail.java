package com.example.cleandia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InformationDetail extends AppCompatActivity {
    TextView wasteType, content;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_detail);

        wasteType = findViewById(R.id.wasteType);
        image = findViewById(R.id.waste_image_detail);
        content = findViewById(R.id.content);

        if(getIntent().getIntExtra("type",0) == 1) {

            final String waste_type = getIntent().getStringExtra("waste type");
            final int waste_image = getIntent().getIntExtra("image",0);
            wasteType.setText(waste_type);
            image.setImageResource(waste_image);

            String para = "Disposal of agricultural waste, is, in many cases similar to regular waste disposal methods. As in, solid materials are often sent to landfills or incinerators. However, this can obviously have a negative effect on the planet – something which those who work within agriculture are likely to be particularly passionate about. In fact, the future of farming relies on taking care of the planet. Fortunately, there are other methods of agricultural waste disposal, such as composting and recycling which can be implemented to help protect the environment.\n" +
                    "\n" +
                    "For example, organic fertilizers can be used again and again, and animal waste (faeces) can be used in composting. Both of which will allow agricultural land to thrive.";

            switch (waste_type){
                case "Agricultural":
                    content.setText(para);


            }
        }

    }
}