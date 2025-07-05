package _02_Batch3_BankProject01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project_02_Exercise_Without_Dummy {

    public static void main(String[] args) {

        // Scanner Class tanimlayin...
        Scanner scan = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);

        // Banka Islemleri Listesi tanimlayin..."Para_Yatir", "Para_Cek", "Transfer", "Hesap_Ac"...
        List<String> actions = new ArrayList<>(Arrays.asList("Para_Yatir", "Para_Cek", "Transfer", "Cikis"));

        // Banka musterileri kullanici adi listesi tanimlayin..."User1", "User2", "User3"...
        List<String> users = new ArrayList<>(Arrays.asList("User1", "User2", "User3"));

        // Banka musterileri sifreleri listesi tanimlayin..."password1", "password2", "password3"...
        List<String> passwords = new ArrayList<>(Arrays.asList("password1", "password2", "password3"));

        // Banka musterilerine ait banka hesap numaralari listesi tanimlayin.."1234", "5678", "9999"
        List<String> accounts = new ArrayList<>(Arrays.asList("1234", "5678", "9999"));

        // Banka musterilerine ait banka hesaplarinda bulunan para miktarlarini tanimlayin...200, 1000, 5000
        List<Integer> funds = new ArrayList<>(Arrays.asList(200, 1000, 5000));


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

        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.print("Kullanici adinizi giriniz : ");
            String username = scanStr.nextLine();
            System.out.print("Sifrenizi giriniz : ");
            String password = scanStr.nextLine();

            isCorrect = confirmUsernameAndPassword(users, passwords, username, password);

            if (!isCorrect) {
                System.out.println("Sistemde kayitli boyle bir kullanici bulunamadi.. Lütfen tekrar deneyin.. ");
            } else {
                System.out.println("Basarili bir sekilde giris yaptiniz.");
            }

        }

        //String password;
        //String username;
        //do {
        //    System.out.print("Kullanici adinizi giriniz : ");
        //    username = scan.nextLine();
        //    System.out.print("Sifrenizi giriniz : ");
        //    password = scan.nextLine();
        //    isCorrect = confirmUsernameAndPassword(users, passwords, username, password);
        //    if (!isCorrect) {
        //        System.out.println("Sistemde kayitli boyle bir kullanici bulunamadi.. Lütfen tekrar deneyin.. ");
        //    }
        //} while (!isCorrect);
        //System.out.println("Basarili bir sekilde giris yaptiniz.");

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

        while (true) {
            System.out.println("Yapmak istediginiz islemi seciniz..:");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i) + " - " + (i + 1));
            }

            int userChoice = scan.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz");
                    break;
                case 2:
                    System.out.println("accounts = " + accounts);
                    System.out.print("Hangi hesaptan para cekmek istiyorsunuz?\nPara cekmek istediginiz hesap numarasını tuslayiniz : ");
                    String choosenAccount = scanStr.nextLine();
                    System.out.println("Cekmek istediginiz miktari giriniz : ");
                    int amountToWithdraw = scan.nextInt();
                    withdraw(accounts, funds, choosenAccount, amountToWithdraw);
                    break;
                case 3:
                    System.out.println("Bu islemi su an gerceklestiremiyoruz...");
                    break;
                case 4:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Basarili bir secim yapmadiniz...");
            }
        }

    }

    private static void withdraw(List<String> accounts, List<Integer> funds, String chosenAccount, int amountToWithdraw) {

        boolean flag = false;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).equals(chosenAccount) && funds.get(i) >= amountToWithdraw) {
                flag = true;
                funds.set(i, funds.get(i) - amountToWithdraw);
                System.out.println("Isleminiz gerceklestirilmistir. Mevcut bakiyeniz = " + funds.get(i));
                break;
            }
        }

        if (!flag) {
            System.out.println("Beklenmedik bir hata olustu...Iyi gunler dileriz...");
        }

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

        boolean isCorrect = false;

        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i)) && password.equals(passwords.get(i))) {
                isCorrect = true;
                break;
            }
        }
        return isCorrect;

        /*
        Kullanici yukarida olusturdugumuz kullanici adi ve password lerden birini girmez ise bu method FALSE dondurmelidir..
        Buna gore verile parametreleri kullanarak kullanici teyitini yapiniz..
         */
    }
}