package br.com.talk_and_show.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.talk_and_show.R;

public enum CommCardCategories {
    SUJEITO("Sujeitos", R.color.sujeitos, R.drawable.icon_sujeitos),
    VERBO("Verbos", R.color.verbos, R.drawable.icon_verbos),
    OBJETO("Objetos", R.color.objetos, R.drawable.icon_objetos),
    ADJETIVO("Adjetivos", R.color.adjetivos, R.drawable.icon_adjetivos),
    ADVERBIO("Adverbios", R.color.adverbios, R.drawable.icon_adverbios),
    PROPRIO("Meus Cards", R.color.proprios, 0),
    FRASE("Frases", R.color.frases, 0);

    private String name;
    private int color;
    private int image;

    CommCardCategories(String name, int color, int image) {
        this.color = color;
        this.name = name;
        this.image = image;
    }

    public int getColor() {
        return this.color;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public static List<CommCardCategories> getValuesList() {
        return Arrays.stream(CommCardCategories.values()).collect(Collectors.toList());
    }
}
