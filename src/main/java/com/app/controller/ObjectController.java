package com.app.controller;

import com.app.dto.CopyRequest;
import com.app.dto.MoveRequest;
import com.app.dto.RenameRequest;
import com.app.entity.FileMetadata;
import com.app.service.ObjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/objects")
public class ObjectController {

    private final ObjectService objectService;

    public ObjectController(ObjectService objectService) {

        this.objectService = objectService;
    }

    @PostMapping("/upload")
    public FileMetadata upload(
            @RequestParam MultipartFile file,
            @RequestParam String bucketName,
            @RequestParam String uploadedBy) {

        return objectService.upload(file, bucketName, uploadedBy);
    }

    @GetMapping
    public List<String> listObjects(@RequestParam String bucketName) {
        return objectService.listObjects(bucketName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        objectService.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PostMapping("/copy")
    public ResponseEntity<String> copy(@RequestBody CopyRequest request) {
        objectService.copy(request);
        return ResponseEntity.ok("Copied Successfully");
    }

    @PostMapping("/move")
    public ResponseEntity<String> move(@RequestBody MoveRequest request) {
        objectService.move(request);
        return ResponseEntity.ok("Moved Successfully");
    }

    @PostMapping("/rename")
    public ResponseEntity<String> rename(@RequestBody RenameRequest request) {
        objectService.rename(request);
        return ResponseEntity.ok("Renamed Successfully");
    }
}