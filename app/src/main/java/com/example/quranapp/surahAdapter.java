package com.example.quranapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class surahAdapter extends ArrayAdapter {
    private final android.app.Activity Context;
    private ArrayList<surahModel> surahs;

    public surahAdapter(Activity context, ArrayList<surahModel> s) {
        super(context,R.layout.surahlistitem,s);
        Context = context;
        this.surahs = s;
    }

    public surahAdapter(@NonNull android.content.Context context, int resource, Activity context1) {
        super(context, resource);
        Context = context1;
    }

    public surahAdapter(@NonNull android.content.Context context, int resource, int textViewResourceId, Activity context1) {
        super(context, resource, textViewResourceId);
        Context = context1;
    }

    public surahAdapter(@NonNull android.content.Context context, int resource, @NonNull Object[] objects, Activity context1) {
        super(context, resource, objects);
        Context = context1;
    }

    public surahAdapter(@NonNull android.content.Context context, int resource, int textViewResourceId, @NonNull Object[] objects, Activity context1) {
        super(context, resource, textViewResourceId, objects);
        Context = context1;
    }

    public surahAdapter(@NonNull android.content.Context context, int resource, @NonNull List objects, Activity context1) {
        super(context, resource, objects);
        Context = context1;
    }

    public surahAdapter(@NonNull android.content.Context context, int resource, int textViewResourceId, @NonNull List objects, Activity context1) {
        super(context, resource, textViewResourceId, objects);
        Context = context1;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflator = Context.getLayoutInflater();
        View Single = inflator.inflate(R.layout.surahlistitem,null,true);
        TextView sE = Single.findViewById(R.id.surahE);
        TextView sU = Single.findViewById(R.id.surahU);
        TextView sNo = Single.findViewById(R.id.surahV);
        TextView sNazool = Single.findViewById(R.id.nazoolV);
        TextView sIntro = Single.findViewById(R.id.surahIntro);
        sE.setText(surahs.get(position).SurahNameE);
        sU.setText(surahs.get(position).SurahNameU);
        sNo.setText(surahs.get(position).SurahID);
        sNazool.setText(surahs.get(position).Nazool);
        sIntro.setText(surahs.get(position).SurahIntro);

        return Single;
    }


}
