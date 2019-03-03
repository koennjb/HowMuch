package com.howmuch;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;
import com.google.firebase.ml.vision.text.RecognizedLanguage;

import java.util.List;

import androidx.annotation.NonNull;

public class TextRecogn {
    private final int TEXT_RECO_REQ_CODE = 100;


    public void textRecog(View view) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        FirebaseVisionDocumentTextRecognizer detector = FirebaseVision.getInstance()
                .getCloudDocumentTextRecognizer();

        Task<FirebaseVisionDocumentText> firebaseVisionDocumentTextTask = detector.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionDocumentText>() {
                    @Override
                    public void onSuccess(FirebaseVisionDocumentText result) {
                        String resultText = result.getText();
                        for (FirebaseVisionDocumentText.Block block: result.getBlocks()) {
                            String blockText = block.getText();
                            Float blockConfidence = block.getConfidence();
                            List<RecognizedLanguage> blockRecognizedLanguages = block.getRecognizedLanguages();
                            Rect blockFrame = block.getBoundingBox();
                            for (FirebaseVisionDocumentText.Paragraph paragraph: block.getParagraphs()) {
                                String paragraphText = paragraph.getText();
                                Float paragraphConfidence = paragraph.getConfidence();
                                List<RecognizedLanguage> paragraphRecognizedLanguages = paragraph.getRecognizedLanguages();
                                Rect paragraphFrame = paragraph.getBoundingBox();
                                for (FirebaseVisionDocumentText.Word word: paragraph.getWords()) {
                                    String wordText = word.getText();
                                    Float wordConfidence = word.getConfidence();
                                    List<RecognizedLanguage> wordRecognizedLanguages = word.getRecognizedLanguages();
                                    Rect wordFrame = word.getBoundingBox();
                                }
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Task failed with an exception
                        // ...
                    }
                });


    }

    protected string findTotal (string word) {

        return "";
    }



}
