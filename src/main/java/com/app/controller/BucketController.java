package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.dto.BucketRequest;
import com.app.service.BucketService;

@RestController
@RequestMapping("/api/buckets")
@Validated
public class BucketController {

	private final BucketService bucketService;

	public BucketController(BucketService bucketService) {
		this.bucketService = bucketService;
	}

	@PostMapping
	public ResponseEntity<String> createBucket(@RequestBody BucketRequest request) {

		bucketService.createBucket(request.getBucketName());

		return ResponseEntity.ok("Bucket created successfully");
	}

	@DeleteMapping("/{bucketName}")
	public ResponseEntity<String> deleteBucket(@PathVariable String bucketName) {

		bucketService.deleteBucket(bucketName);

		return ResponseEntity.ok("Bucket deleted successfully");
	}

	@GetMapping
	public ResponseEntity<List<String>> getBuckets() {

		return ResponseEntity.ok(bucketService.getAllBuckets());
	}
}