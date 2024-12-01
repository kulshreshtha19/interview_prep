package com.systemdesign.filesystem;

public class Main {

    public static void main(String[] args) {
        File file = new File("Avengers");
        Directory movieDirectory = new Directory("Movies");
        movieDirectory.addFileSystem(file);

        Directory actionMovieDirectory = new Directory("Action Movies");
        File pathanMovie = new File("Pathan");
        actionMovieDirectory.addFileSystem(pathanMovie);
        movieDirectory.addFileSystem(actionMovieDirectory);

        movieDirectory.ls();
    }
}
