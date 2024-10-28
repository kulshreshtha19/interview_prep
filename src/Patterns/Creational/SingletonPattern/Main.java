package Patterns.Creational.SingletonPattern;


import java.util.Objects;

class DbConnection {

    private DbConnection() {
        // Intentionally empty
    }

    private static DbConnection dbConnection;

    public static DbConnection getConnection() {
        if (dbConnection == null) {
            synchronized (DbConnection.class) {
                if (dbConnection == null)
                    dbConnection = new DbConnection();
            }
        }
        return dbConnection;
    }

    public void doSomething()
    {
        System.out.println("Something is Done.");
    }
}

public class Main {

    public static void main(String[] args) {
        DbConnection.getConnection().doSomething();
    }
}
