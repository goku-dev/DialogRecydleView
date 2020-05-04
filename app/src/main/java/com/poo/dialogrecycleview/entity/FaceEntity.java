package com.poo.dialogrecycleview.entity;

public class FaceEntity {
    private int idImage;
    private String name;

    public FaceEntity(int idImage, String name) {
        this.idImage = idImage;
        this.name = name;
    }

    public int getIdImage() {
        return idImage;
    }

    public String getName() {
        return name;
    }
    //BƯỚC 1: tạo ra Entity(data)
    //BƯỚC 2: Tạo item view để hiển thị trong list (xml)
}
