package com.test.pixabaydemo;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.test.pixabaydemo.adapter.ImageAdapter;
import com.test.pixabaydemo.model.Hit;
import com.test.pixabaydemo.model.Images;
import com.test.pixabaydemo.network.PixabayAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getSimpleName();
    EditText editText;
    private RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    List<Images> imagesList;
    private String searchQuery = null;
    private int total = 0 ;
    private int totalHits = 0;
    ArrayList<Hit> hits = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText) findViewById(R.id.search_edit_text);
        recyclerView = findViewById(R.id.recycler_view);

        imageAdapter = new ImageAdapter(this, hits);

        final StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        recyclerView.setAdapter(imageAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchQuery = editText.getText().toString();
                    System.out.println("editText.getText() = " + editText.getText());
                    getData();
                }
                return false;
            }
        });

    }

    private void getData() {

        final Call<Images> imagesCall;
        imagesCall = PixabayAPI.getPixabayService().getImages(BuildConfig.PIXABAY_KEY, searchQuery);


        imagesCall.enqueue(new Callback<Images>() {
            @Override
            public void onResponse(Call<Images> call, Response<Images> response) {
                Images imagesList = response.body();
                total = imagesList.getTotal();
                totalHits = imagesList.getTotalHits();
                hits.addAll(imagesList.getHits());
                imageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Images> call, Throwable t) {
                if (t instanceof IOException) {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.search_linear), "No Network", Snackbar.LENGTH_LONG);
                    mySnackbar.show();
                    Log.e(TAG, "onFailure: " + t.getMessage().toString());
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(SearchActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(SearchActivity.this);
                    }

                    builder.setTitle("Internet Access Required")
                            .setMessage("Unable to Continue. Please Check Internet and try again\"")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setCancelable(false)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                } else {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.search_linear), "Error Occurred", Snackbar.LENGTH_LONG);
                    mySnackbar.show();
                    Log.e(TAG, "onFailure: " + t.getMessage());
                    AlertDialog.Builder builder;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(SearchActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(SearchActivity.this);
                    }
                    builder.setTitle("Internet Access Required")
                            .setMessage("Unable to Continue. Please Check Internet and try again\"")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setCancelable(false)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

    }


}
