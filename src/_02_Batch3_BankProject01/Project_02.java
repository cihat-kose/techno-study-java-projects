package _02_Batch3_BankProject01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project_02 {

    public static void main(String[] args) {

        // Scanner Class tanimlayin...
        Scanner scan = new Scanner(System.in);

        // Banka Islemleri Listesi tanimlayin..."Para_Yatir", "Para_Cek", "Transfer", "Hesap_Ac"...
        List<String> actions = new ArrayList<>(Arrays.asList("Para_Yatir", "Para_Cek", "Transfer", "Cikis"));

        // Banka musterileri kullanici adi listesi tanimlayin..."User1", "User2", "User3"...

        // Banka musterileri sifreleri listesi tanimlayin..."password1", "password2", "password3"...

        // Banka musterilerine ait banka hesap numaralari listesi tanimlayin.."1234", "5678", "9999"

        // Banka musterilerine ait banka hesaplarinda bulunan para miktarlarini tanimlayin...200, 1000, 5000

        // ONEMLI NOT : Yukarida gireceginiz listelerdeki veriler index numarasina gore birbirleri ile iliskilidir
        // Mesela -> 'User1' in passwordu 'password1', hesap numarasi '1234' ve hesabiundaki para miktari '200' dur...


    /*
        while (true){

         Sonsuz bir dongu icerisinde kullanicidan username ve password girmesini isteyelim...
         Konsoldan girilen username ve passwordu confirmUsernameAndPassword() methodunu cagirarak teyit edelim...
         Eger dogru username ve password girilmis ise "Basarili bir sekilde giris yaptiniz" mesaji yazdirarak yapmak istedigi islemi soralim ...
         Kayitli olmayan username ve password girilmis ise "Sistemde kayitli boyle bir kullanici bulunamadi.. Tekrar deneyin" mesaji
         gosterip kullaniciyi tekrar username ve password girisine geri dondurelim..

        }
    */

    /*
        while (true){

         Secim hatali ise "Basarili bir secim yapmadiniz..." ikazi vererek tekrar secim yapmasini isteyelim..
         Dogru bir secim yapildiginda kullanici tarafindan secilen islem SWITCH Statements vasitasiyla koda aktarilsin
         Case 1: "Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz" ikazi versin..
         Case 2: "Hangi hesaptan para cekmek istiyorsunuz?" diye kullaniciya sorsun
                  Hesap numaralarini yukaridaki List ten alarak ekrana yazdirin.. Kullanici sectigi hesap numarasini tuslasin..
                 "Ne kadar para cekmek istiyorsunuz?" diye soralim..Kullanici girdisini alalim...
                  asagida bulunan withdraw() methodunu cagirarak hesaptan para cekme islemini tamamlayalim...
                  tekrar islemler dongusune geri donelim...
         Case 3: "Bu islemi su an gerceklestiremiyoruz..." diyerek basa donsun..
         Case 4:  System.exit(1);  buradaki kodu case 4 e aynen kopyalayip yapistirin...
         default:"Basarili bir secim yapmadiniz..." mesaji versin..

    */
        System.out.println("Yapmak istediginiz islemi seciniz...");
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(actions.get(i) + " - " + (i + 1));
        }
        int userChoice = scan.nextInt();

        switch (userChoice) {
            case 1: {


            }
            case 2: {


            }
            case 3: {


            }
            case 4:
                System.exit(1);

            default: {
                System.out.println("Basarili bir secim yapmadiniz...");
            }

        }
       /*
        }
       */
    }

    private static void withdraw(List<String> accounts, List<Integer> funds, String chosenAccount, int amountToWithdraw) {

        /*
        Bu method parametre olarak aldigi accounts (hesaplar) ve funds (hesapta bulunan para miktarlari) listelerinde bulunan degerleri
        kullanici tarafindan girilen degerler ile birlikte kullanabilmek icin olusturulmusutur...
        Mesela : Kullanici 1234 numarali hesaptan para cekmek istemis ise, hangi hesaptan para cekilecegini ve cekilecek para miktarini
        hesap bakiyesinden dusebilmek icin hangi index numarali hesap oldugu bulunmali, ayni index e sahip para miktari funds listesinden
        eksiltilerek kullaniciya hesabinda kalan para miktari belitilmalidir..

        Eger kullanici hesap numarasini yanlis girmisse veya hesabinda bulunan para miktari yeterli degilse
        "Beklenmedik bir hata olustu...Iyi gunler dileriz..." ikazi vermelidir...

         */

    }

    private static boolean confirmUsernameAndPassword(List<String> users, List<String> passwords, String username, String password) {

    /*
        Kullanici yukarida olusturdugumuz kullanici adi ve password lerden birini girmez ise bu method FALSE dondurmelidir..
        Buna gore verile parametreleri kullanarak kullanici teyitini yapiniz..
     */

        return false;
    }
}

