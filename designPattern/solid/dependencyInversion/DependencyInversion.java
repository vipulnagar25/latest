package designPattern.solid.dependencyInversion;

/**
 * Definition: High-level modules should not depend on low-level modules.
 * Both should depend on abstractions (interfaces or abstract classes).
 * Abstractions should not depend on details;
 * details should depend on abstractions.
 */

/*public class MySQLDatabase {
    public void save(String data) {
        // MySQL save logic
    }
}

public class UserService {
    private MySQLDatabase db = new MySQLDatabase(); // Tight coupling

    public void saveUser(String data) {
        db.save(data);
    }
}
The high-level UserService module depends directly on the low-level MySQLDatabase concrete implementation.
*/
interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        // MySQL save logic
    }
}

class UserService {
    private final Database db; // Depends on abstraction

    public UserService(Database db) {
        this.db = db;
    }

    public void saveUser(String data) {
        db.save(data);
    }
}

public class DependencyInversion {
}
