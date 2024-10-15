package com.example.minio.controller;

import com.example.minio.entity.Document;
import com.example.minio.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Document> createBook(@RequestPart("document") Document document,
                                               @RequestPart("files") MultipartFile[] files) {
        Document savedBook = documentService.saveBook(document, files);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllBooks() {
        List<Document> allDocuments = documentService.getAllBooks();
        return new ResponseEntity<>(allDocuments, HttpStatus.OK);
    }
}
