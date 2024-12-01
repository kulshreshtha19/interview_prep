package com.systemdesign.filesystem;

public class File implements FileSystem{
    String name;

    File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println(this.name);
    }
}
