package com.app.statistics.controller;

import com.app.statistics.dto.BucketStatisticsResponse;
import com.app.statistics.dto.FileTypeStatisticsResponse;
import com.app.statistics.dto.MetadataStatisticsResponse;
import com.app.statistics.dto.StorageOverviewResponse;
import com.app.statistics.dto.UserStatisticsResponse;
import com.app.statistics.service.StorageStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StorageStatisticsController {

    private final StorageStatisticsService statisticsService;

    public StorageStatisticsController(StorageStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    /**
     * Overall Storage Statistics
     */
    @GetMapping("/overview")
    public StorageOverviewResponse getOverview() {
        return statisticsService.getOverview();
    }

    /**
     * Bucket Statistics
     */
    @GetMapping("/buckets")
    public List<BucketStatisticsResponse> getBucketStatistics() {
        return statisticsService.getBucketStatistics();
    }

    /**
     * User Statistics
     */
    @GetMapping("/users")
    public List<UserStatisticsResponse> getUserStatistics() {
        return statisticsService.getUserStatistics();
    }

    /**
     * File Type Statistics
     */
    @GetMapping("/file-types")
    public List<FileTypeStatisticsResponse> getFileTypeStatistics() {
        return statisticsService.getFileTypeStatistics();
    }

    /**
     * Metadata Statistics
     */
    @GetMapping("/metadata")
    public MetadataStatisticsResponse getMetadataStatistics() {
        return statisticsService.getMetadataStatistics();
    }

}