package _29_Batch5_BankProject;

import java.util.*;

public class BankSimulation {

     /*
     NOT
     * Aşağıdaki üç field'ın (customers,accounts,scanner) final olması ilk bakışta
     * "bu listeler değiştirilemez olursa, bunlara nasıl müşteri veya hesap ekleriz?"
     * gibi bir soru akla getirebilir.
     * Ancak burada değiştirilemeyecek olan, değerlerin içi değil, referansıdır...
     * `BankSimulation` sınıfı içindeki `accounts` ve `customers` dizi-değişkenlerinin
     * `final` olmasının nedeni, bu değişkenlere atanan referansların sonradan değiştirilmesini engellemek
     * ve programın daha güvenli ve kontrol edilebilir olmasını sağlamaktır.
     * `final` anahtar kelimesiyle tanımlanan bir değişkenin değeri sadece bir kez atanabilir
     * ve sonradan değiştirilemez.
     * Bu tanımlama, `customers` değişkeninin referansının değiştirilemeyeceği anlamına gelir.
     * Ancak, `customers` değişkenine atanan `HashMap` nesnesinin içeriği yine de değiştirilebilir.
     * Yani, `customers` değişkeninin referansı aynı kalacak şekilde müşteri bilgileri eklenebilir,
     * güncellenebilir veya silinebilir.
     */

    // FIELDS
    private final Map<Integer, Customer> customers;
    private final List<Account> accounts;
    private final Scanner scanner;

    // CONSTRUCTORS
    // public BankSimulation() metodu bir constructor'dır.
    // Constructor, bir sınıfın nesnesi oluşturulduğunda otomatik olarak çağrılan bir metottur
    // ve nesnenin başlatılması için kullanılır.
    // BankSimulation sınıfındaki bu constructor,
    // sınıfın nesnesi oluşturulduğunda müşteri ve hesapları saklamak için
    // customers ve accounts değişkenlerini uygun şekilde başlatır.
    // Aynı zamanda kullanıcıdan girdiler almak için scanner değişkenini de başlatır.
    // Bu constructor sayesinde, BankSimulation sınıfından bir nesne oluşturduğunuzda,
    // müşteri ve hesap verilerini saklamak ve kullanıcıdan girdiler almak için gerekli olan
    // başlangıç durumu hazırlanmış olur.

    public BankSimulation() {
        customers = new HashMap<>();
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BankSimulation bankSimulation = new BankSimulation();
        bankSimulation.run();
    }

    // public void run() METODU, ÇIKIŞ YAPILANA KADAR ÇALIŞACAK OLAN ANA METOD
    public void run() {
        int choice;
        do {
            System.out.println("\n----- BANKA İŞLEMLERİ -----");
            System.out.println("1. Müşteri Listele");
            System.out.println("2. Yeni Müşteri Ekle");
            System.out.println("3. Müşteri İşlemleri");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listCustomers();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    customerOperationsMenu();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        } while (choice != 0);
    }


    // MÜŞTERİLERİ LİSTELEYECEK OLAN METHOD
    public void listCustomers() {
        System.out.println("\n----- MÜŞTERİLER -----");
        for (Customer customer : customers.values()) {
            System.out.println(customer.getCustomerId() + " - " + customer.getFirstName() + " " + customer.getLastName() + " (" + customer.getCity() + ")");
            listCustomerAccounts(customer); // Müşteri Listelenirken, yanında hesapları da gösteriliyor...
        }
    }

    // MÜŞTERİLER LİSTELENİRKEN HESAP BİLGİSİ DE LİSTELENMESİ İÇİN GEREKLİ METOD.
    public void listCustomerAccounts(Customer customer) {
        System.out.println("----- " + customer.getCustomerId() + " " + customer.getFirstName() + " " + customer.getLastName() + " HESAPLARI -----");
        boolean hasAccounts = false;
        for (Account account : accounts) {
            if (account.getCustomerId() == customer.getCustomerId()) {
                System.out.println(account.getAccountId() + " - " + account.getAccountType() + " - " + account.getBalance() + " TL");
                hasAccounts = true;
            }
        }
        System.out.println("===============================================");

        if (!hasAccounts) {
            System.out.println("Müşterinin açılmış hesabı bulunmamaktadır.\n" + "===============================================");
        }
    }

    // KONSOLDAN İSİM, SOYİSİM VE ŞEHİR BİLGİSİ ALARAK MÜŞTERİ EKLEME METODU.
    public void addCustomer() {
        System.out.println("\n----- YENİ MÜŞTERİ EKLE -----");
        System.out.print("Müşteri Adı: ");
        String firstName = scanner.nextLine();
        System.out.print("Müşteri Soyadı: ");
        String lastName = scanner.nextLine();
        System.out.print("Şehir: ");
        String city = scanner.nextLine();

        Customer newCustomer = new Customer(firstName, lastName, city);
        customers.put(newCustomer.getCustomerId(), newCustomer);

        System.out.println("Müşteri başarıyla eklendi. Müşteri ID: " + newCustomer.getCustomerId());
    }

    // ANA MENÜDEN MÜŞTERİ İŞLEMLERİNİ SEÇİNCE KARŞIMIZA ÇIKACAK OLAN METOD
    // HANGİ MÜŞTERİ DEMEK, HANGİ MÜŞTERİ ID'Sİ DEMEK, BU KONTROLÜ YAPMAMIZ GEREK...
    // KONSOLDAN MÜŞTERİ ID Sİ YANLIŞ GİRİLİRSE, GEÇERSİZ MÜŞTERİ MESAJI VE TEKRAR ID İSTEMESİ GEREKECEK...
    public void customerOperationsMenu() {
        int customerId;
        do {
            System.out.println("\n----- MÜŞTERİ İŞLEMLERİ -----");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Müşteri ID girin (0 çıkış yapar): ");
            customerId = scanner.nextInt();
            scanner.nextLine();

            if (customerId != 0) {
                Customer customer = customers.get(customerId); // Konsoldan girilen ID'yi bir müşteri nesnesine atadık...
                if (customer != null) { // Atadığımız nesne (customer) null ise, map içerisinde bu id de bir müşteri yok demektir!!!
                    customerOperations(customer); // null değilse, bu müşterinin işlemlerini göster...
                } else {
                    System.out.println("Geçersiz Müşteri ID. Tekrar deneyin.");
                }
            }
        } while (customerId != 0);
    }

    public void customerOperations(Customer customer) {
        int choice;
        do {
            System.out.println("\n----- " + customer.getFirstName() + " " + customer.getLastName() + " İŞLEMLERİ -----");
            System.out.println("1. Yeni Hesap Aç");
            System.out.println("2. Hesapları Listele");
            System.out.println("3. Para Yatır");
            System.out.println("4. Para Çek");
            System.out.println("5. Bakiye Sorgula");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    openNewAccount(customer);
                    break;
                case 2:
                    listCustomerAccounts(customer);
                    break;
                case 3:
                    depositMoney(customer);
                    break;
                case 4:
                    withdrawMoney(customer);
                    break;
                case 5:
                    checkBalance(customer);
                    break;
                case 0:
                    System.out.println("Ana menüye dönülüyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        } while (choice != 0);
    }


    // HESAP AÇARKEN, AÇILACAK HESAP TÜRÜNÜ SEÇMEK İÇİN BİR MENÜ OLACAK...
    // HESAP TÜRÜNÜ SEÇTİKTEN SONRA DA, ID ATAYARAK accounts LIST İNE YENİ HSABI EKLEYEN METOD
    public void openNewAccount(Customer customer) {
        System.out.println("\n----- YENİ HESAP AÇ -----");
        System.out.println("Hesap Türü Seçin:");
        System.out.println("1. Vadesiz Hesap (Checking)");
        System.out.println("2. Tasarruf Hesabı (Savings)");
        System.out.println("3. Kredi Kartı Hesabı (Credit)");
        System.out.print("Seçiminizi yapın: ");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine();

        if (accountTypeChoice >= 1 && accountTypeChoice <= 3) {
            AccountType accountType = null;
            switch (accountTypeChoice) {
                case 1:
                    accountType = AccountType.CHECKING;
                    break;
                case 2:
                    accountType = AccountType.SAVINGS;
                    break;
                case 3:
                    accountType = AccountType.CREDIT;
                    break;
            }

            Account newAccount = new Account(customer.getCustomerId(), accountType);
            accounts.add(newAccount);

            System.out.println("Hesap başarıyla açıldı. Hesap Numarası: " + newAccount.getAccountId());
        } else {
            System.out.println("Geçersiz seçim! Yeni hesap açma işlemi iptal edildi.");
        }
    }

    // PARA EKLE ( deposit() ) METODU
    public void depositMoney(Customer customer) {
        System.out.println("\n----- PARA YATIR -----");
        System.out.print("Hesap Numarasını Girin: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();

        Account account = getAccountById(accountId);
        if (account != null && account.getCustomerId() == customer.getCustomerId()) {
            System.out.print("Yatırılacak Miktarı Girin: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
        } else {
            System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
        }
    }

    // PARA ÇEK ( withdraw() ) METODU
    public void withdrawMoney(Customer customer) {
        System.out.println("\n----- PARA ÇEK -----");
        System.out.print("Hesap Numarasını Girin: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();

        Account account = getAccountById(accountId);
        if (account != null && account.getCustomerId() == customer.getCustomerId()) {
            System.out.print("Çekilecek Miktarı Girin: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdraw(amount);
        } else {
            System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
        }
    }

    //  BAKİYE SORGULAMA
    public void checkBalance(Customer customer) {
        System.out.println("\n----- BAKİYE SORGULA -----");
        System.out.print("Hesap Numarasını Girin: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();

        Account account = getAccountById(accountId);
        if (account != null && account.getCustomerId() == customer.getCustomerId()) {
            System.out.println("Güncel bakiye: " + account.getBalance() + " TL");
        } else {
            System.out.println("Geçersiz Hesap Numarası veya hesap sizin değil! İşlem iptal edildi.");
        }
    }

    // Bu metot, accounts listesinde belirli bir hesabı aramak için kullanılır.
    // Bu sayede, hesap işlemleri sırasında müşteriye ait doğru hesabın bulunması sağlanır.
    // Örneğin, para çekme ve yatırma işlemlerinde, belirli bir müşteriye ait olan hesap bilgilerine
    // doğru bir şekilde ulaşmak için bu metot kullanılır. Girilen accountId (hesap ID) 'sine
    // sahip bir hesap bulunmazsa, metot null değerini döndürür (return null)
    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}
