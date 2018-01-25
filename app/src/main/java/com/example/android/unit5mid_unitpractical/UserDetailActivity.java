package com.example.android.unit5mid_unitpractical;

/**
 * Created by C4Q on 1/24/18.
 */
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserDetailActivity extends AppCompatActivity{

    ImageView imageView;
    TextView name;
    TextView email;
    TextView cell;
    TextView dob;
    TextView address;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail_activity);
        setViews();

    }

    public void setViews(){
        imageView = findViewById(R.id.detail_image);
        name = findViewById(R.id.detail_name);
        email = findViewById(R.id.detail_email);
        cell = findViewById(R.id.detail_cell);
        dob = findViewById(R.id.detail_dob);
        address = findViewById(R.id.detail_address);
        populateViews();
    }

    public void populateViews(){
        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("fullname");
        String email = bundle.getString("email");
        String dob = bundle.getString("dob");
        String cell = bundle.getString("cell");

        StringBuilder addressBuilder = new StringBuilder();
        addressBuilder.append(bundle.getString("street"));
        addressBuilder.append(" ");
        addressBuilder.append(bundle.getString("city"));
        addressBuilder.append(" ");
        addressBuilder.append(bundle.getString("state"));
        addressBuilder.append(" ");
        addressBuilder.append(bundle.getLong("postcode"));
        String address = addressBuilder.toString();

        this.name.setText(name);
        this.email.setText(email);
        this.dob.setText(dob);
        this.cell.setText(cell);
        this.address.setText(address);

        String image = bundle.getString("image");
        Picasso.with(getApplicationContext()).load(image).into(imageView);


    }
}