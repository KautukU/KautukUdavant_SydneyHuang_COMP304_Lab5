package com.example.KautukUdavant_SydneyHuang_COMP304_Lab5;

import android.content.Context;
import android.view.View;

import com.example.kautukudavant_sydneyhuang_comp304_lab5.R;

public enum LandmarkType {

    Italian(R.color.colorOldBuildings),
    Greek(R.color.colorMuseums),
    Chinese(R.color.colorStadiums),
    Indian(R.color.colorAttractions);

    private final int color;

    LandmarkType(int color) {
        this.color = color;
    }

    public int getColor() { return color; }
    public int getColorFrom(Context c) { return c.getResources().getInteger(color); }
    public int getColorFrom(View v) { return v.getResources().getInteger(color); }

    public String format(boolean plural) {
        String str = toString().replace('_', ' ');
        return plural ? str + "S" : str;
    }

    public String format() {
        return format(true);
    }
}