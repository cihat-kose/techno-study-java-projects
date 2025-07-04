package _29_Batch5_BankProject;

public class Account {

    // FIELDS
    private static int nextId =9000;
    private int accountId;
    private int customerId;
    private double balance;
    private AccountType accountType;

    // CONSTRUCTORS
    public Account() {
    }

    public Account(int customerId, AccountType accountType) {
        this.accountId = ++nextId;
        this.customerId = customerId;
        this.accountType = accountType;
    }

    // GETTER METHODS
    public int getAccountId() {
        return accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    // PARA EKLEME İŞLEMİ
    // Yatırılacak tutar sıfırdan büyük olmalıdır. Şart sağlandığında
    // ilgili hesabın bakiyesi belirtilen tutar kadar artar.
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " TL, hesabınıza başarıyla aktarıldı.");
            System.out.println("Güncel Bakiye: " + balance + " TL");
        } else {
            System.out.println("Yatırılacak tutar sıfırdan büyük olmalıdır! Tekrar Deneyiniz...");
        }
    }

    // PARA ÇEKME İŞLEMİ
    // Çekilecek tutar sıfırdan büyük ve bakiyeden az veya eşit olmalıdır.
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(amount + " TL hesabınızdan başarıyla çekildi.");
                System.out.println("Güncel Bakiye: " + balance);
            } else {
                System.out.println(amount + " TL tutarı için, yetersiz bakiye!");
                System.out.println("Güncel Bakiye: " + balance);
            }
        } else {
            System.out.println("Çekilecek tutar sıfırdan büyük olmalıdır! Tekrar Deneyiniz...");
        }
    }

    // TO STRING METODU
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", customerId=" + customerId +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
