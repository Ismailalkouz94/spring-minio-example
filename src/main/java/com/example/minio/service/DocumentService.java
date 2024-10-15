package com.example.minio.service;

import com.example.minio.entity.Document;
import com.example.minio.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    private final ImageStorageService imageStorageService;

    public Document saveBook(Document document,  MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                String imageUrl = imageStorageService.uploadImage(file,document.getTitle());
                document.addImageUrl(imageUrl);
            }
            return documentRepository.save(document);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save book.", e);
        }
    }

    public List<Document> getAllBooks() {
        return documentRepository.findAll();
    }

}
