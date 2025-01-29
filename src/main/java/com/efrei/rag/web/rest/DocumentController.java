package com.efrei.rag.web.rest;

import com.efrei.rag.domain.Document;
import com.efrei.rag.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DocumentController {

    private final DocumentService documentService;
    private static final Logger log = LoggerFactory.getLogger(DocumentService.class);

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> uploadDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to upload document : {}", document);

        Document result = documentService.buildAndSave(document);

        return ResponseEntity.created(new URI("/api/documents/" + result.getId())).body(result);
    }


    @GetMapping("/documents")
    public Optional<List<Document>> getAllDocuments() throws Exception {
        log.debug("REST request to get a page of documents");
        return documentService.findAll();
    }
}
