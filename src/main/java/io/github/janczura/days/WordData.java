package io.github.janczura.days;

public class WordData {
    private String pl;
    private String en;
    private String cn;
    private String explained;

    public WordData(String pl, String en, String cn) {
        this.pl = pl;
        this.en = en;
        this.cn = cn;
    }

    public String getPl() {
        return pl;
    }

    public String getEn() {
        return en;
    }

    public String getCn() {
        return cn;
    }

    public String getExplained() {
        return explained;
    }

    public void setExplained(String explained) {
        this.explained = explained;
    }

    @Override
    public String toString() {
        return "WordData{" +
                "pl='" + pl + '\'' +
                ", en='" + en + '\'' +
                ", cn='" + cn + '\'' +
                '}';
    }
}
