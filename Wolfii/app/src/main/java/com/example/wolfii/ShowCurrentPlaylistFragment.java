package com.example.wolfii;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class ShowCurrentPlaylistFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<Musique> maMusique;
    private MyMusiqueAdapter monAdapter;


    public void setMaMusique(ArrayList<Musique> musiques) {maMusique = musiques;}

    @SuppressLint("WrongConstant")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_listallsongs, container, false);
        //database.getInstance (getActivity ());
        // creation du recyclerview
        mRecyclerView = (RecyclerView) root.findViewById(R.id.myRecyclerView);

        monAdapter = new MyMusiqueAdapter (maMusique, getActivity ());
        ClickOnMusic clickOnMusic = new ClickOnMusic ();
        clickOnMusic.setMesMusiques (maMusique);
        clickOnMusic.setContext (getActivity ());
        monAdapter.setmMusiqueItemClickListener(clickOnMusic);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayout.VERTICAL, false));
        mRecyclerView.setAdapter(monAdapter);

        return root;
    }
    private void rm(String path) {
        try {
            // delete the original file
            File file = new File(path);
            file.delete();
            Log.d("debug_delete", "ok");
        }
        catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
    }
}