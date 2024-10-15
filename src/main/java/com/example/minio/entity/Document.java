package com.example.minio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue()
    private UUID id;
    private String title;
    private String description;
    private List<String> imageUrls = new ArrayList<>();

    public void addImageUrl(String imageUrl) {
        this.imageUrls.add(imageUrl);
    }
}
