# 🚀 Enterprise Storage Service

<div align="center">

# ☁️ Enterprise Object Storage Platform

### Production-Grade Storage Service Built with Spring Boot, MinIO, MongoDB & AWS S3 SDK

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge)
![MongoDB](https://img.shields.io/badge/MongoDB-Latest-green?style=for-the-badge)
![MinIO](https://img.shields.io/badge/MinIO-Object_Storage-red?style=for-the-badge)
![AWS SDK](https://img.shields.io/badge/AWS_S3_SDK-v2-yellow?style=for-the-badge)
![Swagger](https://img.shields.io/badge/OpenAPI-Swagger-success?style=for-the-badge)

### 🎯 Building an Enterprise-Grade Storage Platform Inspired by Amazon S3

</div>

---

# 📖 Overview

Enterprise Storage Service is a production-oriented backend application inspired by Amazon S3 and modern object storage systems.

The project focuses on implementing enterprise-grade storage operations, metadata management, object lifecycle handling, and scalable backend architecture using Spring Boot, MinIO, MongoDB, and AWS S3 SDK.

---

# 🏆 Current Milestone

## Version: v0.4.0

### Object Storage Core Completed

### Infrastructure

✅ Spring Boot Setup  
✅ MongoDB Integration  
✅ MinIO Integration  
✅ AWS S3 SDK v2 Integration  
✅ Swagger/OpenAPI Documentation  
✅ Docker Compose Environment

### Bucket Management

✅ Create Bucket  
✅ Delete Bucket  
✅ List Buckets  
✅ Bucket Existence Validation

### Object Storage

✅ Upload Object API  
✅ Download Object API  
✅ Delete Object API  
✅ List Objects API  
✅ Copy Object API  
✅ Move Object API  
✅ Rename Object API

### Metadata Management

✅ MongoDB Metadata Persistence  
✅ UUID-Based Object Naming  
✅ SHA-256 File Checksum  
✅ ETag Storage  
✅ Upload Timestamp (Instant)  
✅ File Status Tracking

### Engineering

✅ DTO Layer  
✅ Service Layer  
✅ Controller Layer  
✅ Repository Layer  
✅ Global Exception Handling  
✅ Custom Exceptions  
✅ Utility Classes

---

# 🏗️ System Architecture

```text
                    Client
                       │
                       ▼
           Spring Boot REST APIs
                       │
               AWS S3 SDK v2
                       │
         ┌─────────────┴─────────────┐
         ▼                           ▼
      MinIO                      MongoDB
 Object Storage            Metadata Storage
```

---

# 📡 Implemented APIs

## Bucket APIs

| Method | Endpoint |
|----------|----------|
| POST | /api/buckets |
| GET | /api/buckets |
| DELETE | /api/buckets/{bucketName} |

## Object APIs

| Method | Endpoint |
|----------|----------|
| POST | /api/objects/upload |
| GET | /api/objects |
| GET | /api/objects/download/{id} |
| DELETE | /api/objects/{id} |
| POST | /api/objects/copy |
| POST | /api/objects/move |
| POST | /api/objects/rename |

---

# 📈 Progress Dashboard

## Completed

- [x] Spring Boot Setup
- [x] MongoDB Configuration
- [x] MinIO Configuration
- [x] AWS S3 SDK Integration
- [x] Bucket Management APIs
- [x] Object Upload API
- [x] Object Download API
- [x] Object Delete API
- [x] Object Listing API
- [x] Copy Object API
- [x] Move Object API
- [x] Rename Object API
- [x] Metadata Persistence
- [x] SHA-256 Checksum Support
- [x] UUID File Naming
- [x] Swagger/OpenAPI
- [x] Global Exception Handling
- [x] Docker Compose Setup

## In Progress

- [ ] Metadata Search Module
- [ ] Pagination & Sorting
- [ ] File Status Lifecycle Management

---

# 👨‍💻 Author

### Kunal

Backend Developer

Java • Spring Boot • MongoDB • MinIO • AWS S3 • Distributed Storage
