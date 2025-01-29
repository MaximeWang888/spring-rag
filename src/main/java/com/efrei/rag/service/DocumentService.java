package com.efrei.rag.service;

import com.efrei.rag.domain.Document;
import com.efrei.rag.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private static final Logger log = LoggerFactory.getLogger(DocumentService.class);

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document buildAndSave(Document document) {
        log.debug("Request to save document: {}", document);
        return documentRepository.save(document);
    }

    public Optional<List<Document>> findAll() throws Exception {
        log.debug("Request to find all documents");
        return Optional.of(documentRepository.findAll());
    }

    public void deleteById(Long id) {
        log.debug("Request to delete document: {}", id);
        documentRepository.deleteById(id);
    }

    public Optional<Document> findById(Long id) {
        log.debug("Request to find document: {}", id);
        return documentRepository.findById(id);
    }
}
