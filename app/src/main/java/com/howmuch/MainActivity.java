package com.howmuch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionCloudDocumentRecognizerOptions;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;

public class MainActivity extends AppCompatActivity {

    Manager manager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = Manager.getManager();
        User u = manager.getUser();
        manager.saveUser(u);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==TEXT_RECO_REQ_CODE)
        {
            if(resultCode==RESULT_OK)
            {
                Bitmap photo= (Bitmap)data.getExtras().get("data");
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "Failed to Capture", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void text


}

