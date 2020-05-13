package com.poo.dialogrecycleview.entity;

public class FaceEntity {
    private int idImage;
    private String Name;

    public FaceEntity(int idImage, String name) {
        this.idImage = idImage;
        Name = name;
    }


    public int getIdImage() {
        return idImage;
    }

    public String getName() {
        return Name;
    }
}
