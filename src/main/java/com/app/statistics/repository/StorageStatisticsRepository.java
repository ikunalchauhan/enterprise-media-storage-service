package com.app.statistics.repository;

import com.app.statistics.dto.BucketStatisticsResponse;
import com.app.statistics.dto.FileTypeStatisticsResponse;
import com.app.statistics.dto.MetadataStatisticsResponse;
import com.app.statistics.dto.StorageOverviewResponse;
import com.app.statistics.dto.UserStatisticsResponse;

import java.util.List;

public interface StorageStatisticsRepository {

    StorageOverviewResponse getOverview();

    List<BucketStatisticsResponse> getBucketStatistics();

    List<UserStatisticsResponse> getUserStatistics();

    List<FileTypeStatisticsResponse> getFileTypeStatistics();

    MetadataStatisticsResponse getMetadataStatistics();

}