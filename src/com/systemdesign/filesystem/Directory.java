package com.systemdesign.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    String name;
    List<FileSystem> fileSystems;

    Directory(String name) {
        this.name = name;
        this.fileSystems = new ArrayList<>();
    }

    public void addFileSystem(FileSystem fileSystem) {
        this.fileSystems.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println(this.name);
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.ls();
        }
    }
}
