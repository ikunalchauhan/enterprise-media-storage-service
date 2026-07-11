package com.app.statistics.service;

import com.app.statistics.dto.BucketStatisticsResponse;
import com.app.statistics.dto.FileTypeStatisticsResponse;
import com.app.statistics.dto.MetadataStatisticsResponse;
import com.app.statistics.dto.StorageOverviewResponse;
import com.app.statistics.dto.UserStatisticsResponse;
import com.app.statistics.repository.StorageStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageStatisticsServiceImpl implements StorageStatisticsService {

    private final StorageStatisticsRepository statisticsRepository;

    public StorageStatisticsServiceImpl(StorageStatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public StorageOverviewResponse getOverview() {
        return statisticsRepository.getOverview();
    }

    @Override
    public List<BucketStatisticsResponse> getBucketStatistics() {
        return statisticsRepository.getBucketStatistics();
    }

    @Override
    public List<UserStatisticsResponse> getUserStatistics() {
        return statisticsRepository.getUserStatistics();
    }

    @Override
    public List<FileTypeStatisticsResponse> getFileTypeStatistics() {
        return statisticsRepository.getFileTypeStatistics();
    }

    @Override
    public MetadataStatisticsResponse getMetadataStatistics() {
        return statisticsRepository.getMetadataStatistics();
    }
}