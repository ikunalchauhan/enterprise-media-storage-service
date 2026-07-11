package com.app.statistics.projection;

public interface BucketStatisticsProjection {

    String getId();

    long getTotalFiles();

    long getTotalSize();

}