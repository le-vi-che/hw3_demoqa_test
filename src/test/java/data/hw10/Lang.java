package data.hw10;

public enum Lang {
    Рус ("Московский государственный университет имени М.В.Ломоносова"),
    Eng ("Lomonosov Moscow State University"),
    中文 ("罗蒙诺索夫莫斯科国立大学");


    public final String description;

    Lang(String description) {
        this.description = description;
    }
}
