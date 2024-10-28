package Multithreading.publication;


/**
 * UnsafeLazyInitialization: Unsafe lazy initialization
 *
 * @author manish.ranglani
 */
public class UnsafeLazyInitialization {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null)
            resource = new Resource(); // unsafe Multithreading.publication
        return resource;
    }

    static class Resource {
    }
}