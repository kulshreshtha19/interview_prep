package Multithreading.publication;

/**
 * Double-checked-Multithreading.locking antipattern
 *
 * @author manish.ranglani
 */
public class DoubleCheckedLocking {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resource == null)
                    resource = new Resource();
            }
        }
        return resource;
    }

    static class Resource {

    }
}
