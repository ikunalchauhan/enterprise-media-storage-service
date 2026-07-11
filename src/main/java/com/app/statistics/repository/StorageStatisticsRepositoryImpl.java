package com.app.statistics.repository;

import com.app.common.util.StorageSizeUtil;
import com.app.statistics.dto.BucketStatisticsResponse;
import com.app.statistics.dto.FileTypeStatisticsResponse;
import com.app.statistics.dto.MetadataStatisticsResponse;
import com.app.statistics.dto.StorageOverviewResponse;
import com.app.statistics.dto.UserStatisticsResponse;
import com.app.statistics.repository.StorageStatisticsRepository;
import com.app.storage.entity.FileMetadata;
import com.app.storage.entity.FileStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StorageStatisticsRepositoryImpl implements StorageStatisticsRepository {

    private final MongoTemplate mongoTemplate;

    public StorageStatisticsRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public StorageOverviewResponse getOverview() {

        long totalFiles = mongoTemplate.count(null, FileMetadata.class);

        long totalBuckets = mongoTemplate
                .query(FileMetadata.class)
                .distinct("bucketName")
                .as(String.class)
                .all()
                .size();

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group().sum("fileSize").as("totalSize")
        );

        AggregationResults<SizeResult> result =
                mongoTemplate.aggregate(
                        aggregation,
                        FileMetadata.class,
                        SizeResult.class);

        long totalSize = 0;

        if (!result.getMappedResults().isEmpty()) {
            totalSize = result.getMappedResults().get(0).getTotalSize();
        }

        return new StorageOverviewResponse(
                totalFiles,
                totalBuckets,
                totalSize,
                StorageSizeUtil.format(totalSize)
        );
    }

    @Override
    public List<BucketStatisticsResponse> getBucketStatistics() {

        Aggregation aggregation = Aggregation.newAggregation(

                Aggregation.group("bucketName")
                        .count().as("totalFiles")
                        .sum("fileSize").as("totalSize"),

                Aggregation.sort(Sort.Direction.ASC, "_id")

        );

        AggregationResults<BucketResult> results =
                mongoTemplate.aggregate(
                        aggregation,
                        FileMetadata.class,
                        BucketResult.class);

        List<BucketStatisticsResponse> response = new ArrayList<>();

        for (BucketResult item : results.getMappedResults()) {

            response.add(new BucketStatisticsResponse(
                    item.getId(),
                    item.getTotalFiles(),
                    item.getTotalSize(),
                    StorageSizeUtil.format(item.getTotalSize())
            ));
        }

        return response;
    }

    @Override
    public List<UserStatisticsResponse> getUserStatistics() {

        Aggregation aggregation = Aggregation.newAggregation(

                Aggregation.group("uploadedBy")
                        .count().as("totalFiles")
                        .sum("fileSize").as("totalSize"),

                Aggregation.sort(Sort.Direction.ASC, "_id")

        );

        AggregationResults<UserResult> results =
                mongoTemplate.aggregate(
                        aggregation,
                        FileMetadata.class,
                        UserResult.class);

        List<UserStatisticsResponse> response = new ArrayList<>();

        for (UserResult item : results.getMappedResults()) {

            response.add(new UserStatisticsResponse(
                    item.getId(),
                    item.getTotalFiles(),
                    item.getTotalSize(),
                    StorageSizeUtil.format(item.getTotalSize())
            ));
        }

        return response;
    }

    @Override
    public List<FileTypeStatisticsResponse> getFileTypeStatistics() {

        Aggregation aggregation = Aggregation.newAggregation(

                Aggregation.group("fileType")
                        .count().as("totalFiles")
                        .sum("fileSize").as("totalSize"),

                Aggregation.sort(Sort.Direction.ASC, "_id")

        );

        AggregationResults<FileTypeResult> results =
                mongoTemplate.aggregate(
                        aggregation,
                        FileMetadata.class,
                        FileTypeResult.class);

        List<FileTypeStatisticsResponse> response = new ArrayList<>();

        for (FileTypeResult item : results.getMappedResults()) {

            response.add(new FileTypeStatisticsResponse(
                    item.getId(),
                    item.getTotalFiles(),
                    item.getTotalSize(),
                    StorageSizeUtil.format(item.getTotalSize())
            ));
        }

        return response;
    }

    @Override
    public MetadataStatisticsResponse getMetadataStatistics() {

        long active = mongoTemplate.count(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("status").is(FileStatus.ACTIVE)
                ),
                FileMetadata.class
        );

        long archived = mongoTemplate.count(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("status").is(FileStatus.ARCHIVED)
                ),
                FileMetadata.class
        );

        long deleted = mongoTemplate.count(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("status").is(FileStatus.DELETED)
                ),
                FileMetadata.class
        );

        return new MetadataStatisticsResponse(
                active,
                archived,
                deleted
        );
    }

    // ---------------- Result Classes ----------------

    private static class SizeResult {

        private long totalSize;

        public long getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(long totalSize) {
            this.totalSize = totalSize;
        }
    }

    private static class BucketResult {

        private String id;
        private long totalFiles;
        private long totalSize;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTotalFiles() {
            return totalFiles;
        }

        public void setTotalFiles(long totalFiles) {
            this.totalFiles = totalFiles;
        }

        public long getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(long totalSize) {
            this.totalSize = totalSize;
        }
    }

    private static class UserResult {

        private String id;
        private long totalFiles;
        private long totalSize;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTotalFiles() {
            return totalFiles;
        }

        public void setTotalFiles(long totalFiles) {
            this.totalFiles = totalFiles;
        }

        public long getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(long totalSize) {
            this.totalSize = totalSize;
        }
    }

    private static class FileTypeResult {

        private String id;
        private long totalFiles;
        private long totalSize;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTotalFiles() {
            return totalFiles;
        }

        public void setTotalFiles(long totalFiles) {
            this.totalFiles = totalFiles;
        }

        public long getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(long totalSize) {
            this.totalSize = totalSize;
        }
    }
}