 package com.example.asus.turkcell;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

 public class ProjectPhotosView extends AppCompatActivity {

    private DatabaseReference mDatabaseRef;
     private List<ImageUpload> imgList;
     private ListView lv;
     private ImageListAdapter adapter;
     private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_photos_view);
        imgList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listViewImage);

        //show progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait loading list image...");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(Storage.FB_DATABASE_PATH);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                progressDialog.dismiss();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                    ImageUpload img = snapshot.getValue(ImageUpload.class);
                    imgList.add(img);
                }


                adapter = new ImageListAdapter(ProjectPhotosView.this,R.layout.image_item,imgList);

                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });

    }
}
