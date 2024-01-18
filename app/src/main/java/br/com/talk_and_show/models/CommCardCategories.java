package com.example.myapplication.models;


import com.example.myapplication.R;

public enum CommCardCategories {
    SUJEITO(R.color.sujeitos),
    VERBO(R.color.verbos),
    OBJETO(R.color.objetos),
    ADJETIVO(R.color.adjetivos),
    ADVERBIO(R.color.adverbios),
    PROPRIO(R.color.proprios);

    private int color;

    CommCardCategories(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
}
