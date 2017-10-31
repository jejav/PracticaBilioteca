package com.jejav.jesusjavier.practicabilioteca;

/**
 * Created by Jesus Javier on 31/10/2017.
 */

public class User {
    String name;
    String phone,libro,autor;
    int uid;




    public User(int uid,String libro, String autor,String name, String phone ) {
        this.name = name;
        this.uid = uid;
        this.phone = phone;
        this.libro = libro;
        this.autor = autor;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public User(String name, int uid, String phone) {
        this.name = name;

        this.uid = uid;
        this.phone = phone;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getUid() {
        return uid;
    }

    public String getPhone() {
        return phone;
    }
}
