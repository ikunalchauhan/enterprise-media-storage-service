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

<img src="docs/banner/banner.png" width="100%" alt="Enterprise Storage Service Banner">

### 🎯 Building an Enterprise-Grade Storage Platform Inspired by Amazon S3

</div>

---

# 📖 Overview

Enterprise Storage Service is a production-oriented backend application inspired by modern cloud storage solutions such as Amazon S3, MinIO, Dropbox, and Google Cloud Storage.

The objective of this project is to build a scalable object storage platform while mastering enterprise backend engineering practices.

---

# 🏆 Current Milestone

## Version: v0.5.0

### Metadata Management Completed

### Infrastructure

✅ Spring Boot Setup
✅ MongoDB Integration
✅ MinIO Integration
✅ AWS S3 SDK v2 Integration
✅ Swagger/OpenAPI Documentation
✅ Docker Compose Environment

### Bucket Management

✅ Bucket Creation API
✅ Bucket Deletion API
✅ Bucket Listing API
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
✅ Metadata Search API
✅ Search By Filename
✅ Search By Bucket
✅ Search By Uploaded User
✅ Search By Status
✅ Pagination Support
✅ Sorting Support

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

# 🛠️ Technology Stack

| Layer | Technology |
|---------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Object Storage | MinIO |
| Database | MongoDB |
| Cloud SDK | AWS S3 SDK v2 |
| API Documentation | Swagger/OpenAPI |
| Build Tool | Maven |
| Containerization | Docker |
| Architecture | Layered Architecture |

---

# 📡 Implemented APIs

## Bucket APIs

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | `/api/buckets` | Create Bucket |
| GET | `/api/buckets` | List Buckets |
| DELETE | `/api/buckets/{bucketName}` | Delete Bucket |

## Object APIs

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | `/api/objects/upload` | Upload File |
| GET | `/api/objects` | List Objects |
| GET | `/api/objects/download/{id}` | Download File |
| DELETE | `/api/objects/{id}` | Delete File |
| POST | `/api/objects/copy` | Copy Object |
| POST | `/api/objects/move` | Move Object |
| POST | `/api/objects/rename` | Rename Object |

## Metadata APIs

| Method | Endpoint | Description |
|----------|----------|-------------|
| GET | `/api/metadata` | Get All Metadata |
| GET | `/api/metadata/{id}` | Get Metadata By Id |
| GET | `/api/metadata/search?name=` | Search By Filename |
| GET | `/api/metadata/bucket/{bucketName}` | Search By Bucket |
| GET | `/api/metadata/user/{uploadedBy}` | Search By User |
| GET | `/api/metadata/status/{status}` | Search By Status |

---

# 📂 Project Structure

```text
enterprise-storage-service
├── docs
├── src
├── postman
├── docker
└── README.md
```

---

# 📊 Project Status

Current Progress: ~70%

### Completed Modules

✅ Bucket Management

✅ Object Storage Operations

✅ Metadata Management

### Current Focus

🚧 File Lifecycle Management

- Soft Delete
- Restore
- Archive

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
- [x] Metadata Search APIs
- [x] Pagination
- [x] Sorting
- [x] SHA-256 Checksum Support
- [x] UUID File Naming
- [x] Swagger/OpenAPI
- [x] Global Exception Handling
- [x] Docker Compose Setup

## In Progress

- [ ] File Status Lifecycle Management
- [ ] Soft Delete
- [ ] Restore File
- [ ] Archive File

## Planned

- [ ] Structured Logging
- [ ] Actuator Monitoring
- [ ] JWT Authentication
- [ ] Presigned URLs
- [ ] Range Downloads
- [ ] Streaming Support
- [ ] CI/CD Pipeline
- [ ] Kubernetes Deployment

---

# 🚀 Release History

| Version | Description | Status |
|----------|------------|---------|
| v0.1.0 | Project Initialization | ✅ |
| v0.2.0 | Bucket Management + Swagger Documentation | ✅ |
| v0.3.0 | Metadata Model + Exception Layer | ✅ |
| v0.4.0 | Object Storage Operations | ✅ |
| v0.5.0 | Metadata Management, Search, Pagination & Sorting | ✅ |
| v0.6.0 | File Lifecycle Management | 🚧 |
| v1.0.0 | Production Release | ⏳ |

---

# 👨‍💻 Author

### Kunal

Backend Developer

Java • Spring Boot • MongoDB • MinIO • AWS S3 • Distributed Storage
