package Multithreading.publication;

/**
 * EagerInitialization: Eager initialization
 *
 * @author manish.ranglani
 */
public class EagerInitialization {
    private static Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }
}
