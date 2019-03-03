package com.howmuch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import com.google.firebase.ml.vision.text.RecognizedLanguage;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class TextRecogn {

    private final int TEXT_RECO_REQ_CODE = 100;
    private FirebaseVisionImage image;
    Bitmap bitmap = BitmapFactory.decodeFile("/Users/koennbecker/Code/Mobile/HowMuch/app/libs/www_google_com-url.bmp");
    FirebaseVisionTextRecognizer detector;
    private final String TAG = "TextRec-Log";

    public TextRecogn() {
        Log.d(TAG, "Bitmap is null: " +  (bitmap == null));
        image = FirebaseVisionImage.fromBitmap(bitmap);
        detector = FirebaseVision.getInstance()
                .getCloudTextRecognizer();
        processImage();
    }

    public void processImage() {
        Task<FirebaseVisionText> result =
                detector.processImage(image)
                        .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                            @Override
                            public void onSuccess(FirebaseVisionText firebaseVisionText) {
                                Log.d(TAG, "Success!!");
                                success(firebaseVisionText);
                            }
                        })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Task failed with an exception
                                        // ...
                                    }
                                });
    }

    public void success(FirebaseVisionText result) {
        for (FirebaseVisionText.TextBlock block: result.getTextBlocks()) {
            for (FirebaseVisionText.Line line: block.getLines()) {
                for (FirebaseVisionText.Element element: line.getElements()) {
                    String elementText = element.getText();
                    Log.d(TAG, elementText);
                }
            }
        }
    }

    private ArrayList<String> parseIntsAndFloats(String raw) {

        ArrayList<String> listBuffer = new ArrayList<String>();

        Pattern pattern = Pattern.compile("[+-]?[0-9]*[.]?[0-9]+");

        Matcher m = p.matcher(raw);

        while (m.find()) {
            listBuffer.add(m.group());
        }

        return listBuffer;
    }


//    public void textRecog(View view) {
//
//        Task<FirebaseVisionDocumentText> firebaseVisionDocumentTextTask = detector.processImage(image)
//                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionDocumentText>() {
//                    @Override
//                    public void onSuccess(FirebaseVisionDocumentText result) {
//                        String resultText = result.getText();
//                        for (FirebaseVisionDocumentText.Block block: result.getBlocks()) {
//                            String blockText = block.getText();
//                            Float blockConfidence = block.getConfidence();
//                            List<RecognizedLanguage> blockRecognizedLanguages = block.getRecognizedLanguages();
//                            Rect blockFrame = block.getBoundingBox();
//                            for (FirebaseVisionDocumentText.Paragraph paragraph: block.getParagraphs()) {
//                                String paragraphText = paragraph.getText();
//                                Float paragraphConfidence = paragraph.getConfidence();
//                                List<RecognizedLanguage> paragraphRecognizedLanguages = paragraph.getRecognizedLanguages();
//                                Rect paragraphFrame = paragraph.getBoundingBox();
//                                for (FirebaseVisionDocumentText.Word word: paragraph.getWords()) {
//                                    String wordText = word.getText();
//                                    Float wordConfidence = word.getConfidence();
//                                    List<RecognizedLanguage> wordRecognizedLanguages = word.getRecognizedLanguages();
//                                    Rect wordFrame = word.getBoundingBox();
//                                }
//                            }
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        // Task failed with an exception
//                        // ...
//                    }
//                });
//
//
//    }
//
//    protected string findTotal (string word) {
//
//        return "";
//    }



}
