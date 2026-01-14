package miniproject1;

import java.io.*;

// Runtime Polymorphism happens here
public class BankService {

    private static final String FILE_NAME = "accounts.dat";

    // Method Overloading
    public void saveAccount(BankAccount acc) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME));
        oos.writeObject(acc);
        oos.close();
    }

    public BankAccount loadAccount() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_NAME));
        BankAccount acc = (BankAccount) ois.readObject();
        ois.close();
        return acc;
    }
}

