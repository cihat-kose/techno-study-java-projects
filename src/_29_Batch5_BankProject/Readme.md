# Techno Study Banking Project

## Proje Konusu: Banka Uygulaması

### 1. Customer (Müşteri) Sınıfı oluşturun.
- **Fields**: 
```java
 int customerId;
 String firstName;
 String lastName;
 String city;
```

- **Constructors**:
```java
... Customer(){...}; 
... Customer(int customerId, String firstName, String lastName, String city){...}; 
 ```
- **Getter ve Setter metodları**

### 2. AccountType (Hesap Tipi) Enum Sınıfı
- `toString(){...};` **metodu**

- Sabitler: 
  - `CHECKING` (Vadesiz Hesap), 
  - `SAVINGS` (Tasarruf Hesabı), 
  - `CREDIT` (Kredi Hesabı)

### 3. Account (Hesaplar) Sınıfı
- **Fields**:
```java
    int accountId;
    int customerId;
    double balance;
    AccountType accountType;
```
- **Constructors**:
```java
... Account(){...};
... Account(int accountId, int customerId, AccountType accountType){};

```

- **Getter ve Setter metodlarını oluşturun.** <br><br>

 - `deposit(double amount)` **metodu (Para Yatır),**<br><br>

 - `withdraw(double amount)` **metodu (Para Çek) ve**<br><br>

- `toString()` **metodlarını oluşturun**

### 4. BankSimulation Sınıfı
- **Fields**:

```java
  Map<Integer, Customer> customers;
  List<Account> accounts;
  Scanner scanner;
```

- **Constructors**: <br><br>
  `BankSimulation(){};`
```java
  BankSimulation() { 
     customers = new HashMap<>(); 
     accounts = new ArrayList<>(); 
     scanner = new Scanner(System.in); 
 }


```

- **Main method** 
```java 
    public static void main(String[] args){
    ...
}
```
- `run()` metodu
- `listCustomers()` metodu
- `listCustomerAccounts(Customer customer)` metodu
- `addCustomer()` metodu
- `customerOperationsMenu()` metodu
- `customerOperations(Customer customer)` metodu
- `openNewAccount(Customer customer)` metodu
 - `depositMoney(Customer customer)` metodu
 - `withdrawMoney(Customer customer)` metodu
- `checkBalance(Customer customer)` metodu
- `getAccountById(int accountId)` metodu

## Proje Yapısı:

```bash
BankingSystem
├── src
│ ├── Customer.java
│ ├── AccountType.java
│ ├── Account.java
│ └── BankSimulation.java
└── README.txt (Istege Bagli)
```


## Görevler

1. Proje yapısını oluşturun ve verilen sınıfları ilgili dosyalara yerleştirin.
2. "Customer" sınına getter ve setter metodları ekleyin.
3. "Account" sınıfına "deposit()" ve "withdraw()" metodlarını ekleyin.
4. "BankSimulation" sınıfında müşteri ekleme ve listeleme fonksiyonlarını tamamlayın.
5. "BankSimulation" sınıfında yeni hesap açma ve hesap işlemleri fonksiyonlarını tamamlayın.
6. Main metodu içinde uygulamayı başlatın ve kullanıcı arayüzü ile işlemleri gerçekleştirin.

## Notlar

- Proje sırasında hatalı girişlere karşı uygun hata yönetimi isteğe bağlıdır.

## EK BİLGİLER

- `BankSimulation` sınıfı, banka işlemlerini yöneten ve kullanıcı arayüzü sağlayan ana sınıftır. `main` metodu bu sınıfta yer alır ve banka simulasyonunu başlatır. Aynı zamanda `run` metodu ana menüyü oluşturur ve kullanıcıdan girdiler alarak işlemleri yönlendirir. `BankSimulation` sınıfı içinde müşterileri ve hesapları temsil eden maps ve liste şeklinde veri yapıları (`customers` ve `accounts`) kullanılmaktadır.
- `Customer` sınıfı, bankadaki müşterileri temsil eder ve müşterilere ait bilgileri içerir. Daha doğrusu, bir Customer nesnesi oluşturduğumuzda, bu nesne vasıtasıyla Customer sınıfının field'lerini (değişkenlerini) ve metodlarını tutacak ve etkileyecek hale gelmiş oluruz.
- `Account` sınıfı, bankadaki hesapları temsil eder ve hesaplara ait bilgileri içerir. Daha doğrusu Account cinsinden oluşturduğumuz nesne, hesap bilgilerini ve metodlarını tutmamızı ve onları kullanmamızı sağlar. Account sınıfı, `withdraw` (para çek) ve `deposit` (para yatır) gibi işlem metotlarını içerir.
- `AccountType` enum, vadeli-vadesiz ve kredi hesabı türlerini temsil eder.
- `BankSimulation` sınıfı içindeki `accounts` ve `customers` değişkenleri `final` olmasının nedeni, bu değişkenlere atanan referansların sonradan değişrilmesini engellemek ve programın daha güvenli ve kontrol edilebilir olmasını sağlamaktır. `final` anahtar kelimesiyle tanımlanan bir değişkenin değeri sadece bir kez atanabilir ve sonradan değiştirilemez. Örneğin, `customers` değişkeni için: `private final Map<Integer, Customer> customers;` Bu tanımlama, `customers` değişkeninin referansının değiştirilemeyeceği anlamına gelir. Ancak, `customers` değişkenine atanan `HashMap` nesnesinin içeriği yine de değiştirilebilir. Yani, `customers` değişkeninin referansı aynı kalacak şekilde müşteri bilgileri eklenebilir, güncellenebilir veya silinebilir.
