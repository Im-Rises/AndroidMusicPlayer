package com.example.musique_rv;

// plain old java object (POJO)

public class Musique {
    private String name;
    private String path;
    private String author;
    private String duration;

    Musique(String name, String author, String path, String duration) {
        this.name = name;
        this.path = path;
        this.author = author;
        this.duration = duration;
    }


    // GETTER
    public String getName() {return name;}
    public String getPath() {return path;}
    public String getDuration() {return duration;}
    public String getAuthor() {return author;}
}