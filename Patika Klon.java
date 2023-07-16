//Klon için ilk önce HTML kaynağı Java koda değiştirmeyi denedim, bir hayli de ilerledim. 
//Fakat <body> gibi html'e özgü girişlerin altından kalkamadım. Bundan vazgeçince daha önce yapılmış sistem kodlarına baktım. 
//Sql kullanımı yoğun olduğu için seviyemi aşan bir durum oldu. Bende elimden geldiğince ve yapay zekanın da desteğiyle... 
//Sadece Java kullanarak çok dinamik bir hale büründürememiş olsam da Patika klonu yapmayı denemiş oldum. Teşekkür ederim :)

//*Author*/
//BERAT ARSLAN//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Kullanıcı sınıfları oluşturma
    static abstract class Kullanıcı {
        private String kullanıcıAdı;
        private String şifre;

        public Kullanıcı(String kullanıcıAdı, String şifre) {
            this.kullanıcıAdı = kullanıcıAdı;
            this.şifre = şifre;
        }

        public String getKullanıcıAdı() {
            return kullanıcıAdı;
        }

        public String getŞifre() {
            return şifre;
        }

        public abstract String getRol();
    }

    static class Operator extends Kullanıcı {
        public Operator(String kullanıcıAdı, String şifre) {
            super(kullanıcıAdı, şifre);
        }

        @Override
        public String getRol() {
            return "OPERATOR";
        }
    }

    static class Eğitmen extends Kullanıcı {
        public Eğitmen(String kullanıcıAdı, String şifre) {
            super(kullanıcıAdı, şifre);
        }

        @Override
        public String getRol() {
            return "Eğitmen";
        }
    }

    static class Öğrenci extends Kullanıcı {
        public Öğrenci(String kullanıcıAdı, String şifre) {
            super(kullanıcıAdı, şifre);
        }

        @Override
        public String getRol() {
            return "Öğrenci";
        }
    }

    // Patika, Eğitim, İçerik ve Quiz sınıflarını tanımlama
    static class Patika {
        private String ad;

        public Patika(String ad) {
            this.ad = ad;
        }

        public String getAd() {
            return ad;
        }
    }

    static class Eğitim {
        private String ad;

        public Eğitim(String ad) {
            this.ad = ad;
        }

        public String getAd() {
            return ad;
        }
    }

    static class İçerik {
        private String başlık;
        private String açıklama;
        private String youtubeLinki;
        private String quizSoruları;
        private Egitim ders;

        public Icerik(String başlık, String açıklama, String youtubeLinki, String quizSoruları, Eğitim ders) {
            this.başlık = başlık;
            this.açıklama = açıklama;
            this.youtubeLinki = youtubeLinki;
            this.quizSoruları = quizSoruları;
            this.ders = ders;
        }

        public String getBaşlık() {
            return başlık;
        }

        public String getAçıklama() {
            return açıklama;
        }

        public String getYoutubeLinki() {
            return youtubeLinki;
        }

        public String getQuizSoruları() {
            return quizSoruları;
        }

        public Egitim getDers() {
            return ders;
        }
    }

    static class Quiz {
        private String ad;
        private String sorular;

        public Quiz(String ad, String sorular) {
            this.ad = ad;
            this.sorular = sorular;
        }

        public String getAd() {
            return ad;
        }

        public String getSorular() {
            return sorular;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Operatör ekleyelim
        List<Operator> operatorler = new ArrayList<>();
        Operator operator = new Operator("operator", "212121");
        operatorler.add(operator);

        // Eğitmen ekleyelim
        List<Eğitmen> eğitmenler = new ArrayList<>();
        Eğitmen eğitmen = new Egitmen("eğitmen", "212121");
        eğitmenler.add(eğitmen);

        // Sistemdeki patikalar, eğitimler, içerikler ve quizleri tutalım
        List<Patika> patikalar = new ArrayList<>();
        List<Eğitim> eğitimler = new ArrayList<>();
        List<İçerik> içerikler = new ArrayList<>();
        List<Quiz> quizler = new ArrayList<>();

        // Giriş ekranı
        System.out.println("Hoş geldiniz!");
        System.out.println("Giriş yapmak için kullanıcı adı ve şifrenizi girin:");

        System.out.print("Kullanıcı Adı: ");
        String kullanıcıAdı = scanner.nextLine();

        System.out.print("Şifre: ");
        String sifre = scanner.nextLine();

        Kullanici girişyapanKullanıcı = null;

        // Kullanıcı tipini belirleme
        for (Operator op : operatorler) {
            if (op.getKullanıcıAdı().equals(kullanıcıAdı) && op.getŞifre().equals(şifre)) {
                girişYapanKullanıcı = op;
                break;
            }
        }

        if (girişYapanKullanıcı == null) {
            for (Eğitmen eğ : eğitmenelr) {
                if (eğ.getKullanıcıAdı().equals(kullanıcıAdı) && eğ.getŞifre().equals(şifre)) {
                    girişYapanKullanıcı = eğ;
                    break;
                }
            }
        }

        if (girişYapanKullanıcı == null) {
            System.out.println("Kullanıcı adı veya şifre yanlış. Lütfen tekrar deneyin.");
        } else {
            System.out.println("Hoş geldiniz, " + girişYapanKullanıcı.getKullanıcıAdı() + "!");
            System.out.println("Rolünüz: " + girişYapanKullanıcı.getRol());
        }

        scanner.close();
    }
}
