package org.first.parametrized;

public enum Language {
    EN("Dodo has developed into one of the industry’s first truly digital-first concepts..."),
    RU("«Додо» — одна из первых по-настоящему цифровых концепций в нашей индустрии");
    String lang;
    Language(String lang) {
        this.lang = lang;
    }
}
