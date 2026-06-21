package com.app.util;

public final class FileTypeUtil {

    private FileTypeUtil() {
    }

    public static String determineType(String contentType) {
        if (contentType == null || contentType.isBlank()) {
            return "UNKNOWN";
        }

        // Images
        if (contentType.startsWith("image/")) {
            return "IMAGE";
        }

        // Videos
        if (contentType.startsWith("video/")) {
            return "VIDEO";
        }

        // Audio
        if (contentType.startsWith("audio/")) {
            return "AUDIO";
        }

        // PDF
        if ("application/pdf".equals(contentType)) {
            return "PDF";
        }

        // Word Documents
        if (contentType.equals("application/msword")
                || contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {

            return "WORD";
        }

        // Excel
        if (contentType.equals("application/vnd.ms-excel")
                || contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {

            return "EXCEL";
        }

        // PowerPoint
        if (contentType.equals("application/vnd.ms-powerpoint")
                || contentType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {

            return "POWERPOINT";
        }

        // Text
        if (contentType.startsWith("text/")) {
            return "TEXT";
        }

        // JSON
        if (contentType.equals("application/json")) {
            return "JSON";
        }

        // XML
        if (contentType.equals("application/xml")
                || contentType.equals("text/xml")) {

            return "XML";
        }

        // Archives
        if (contentType.equals("application/zip")
                || contentType.equals("application/x-rar-compressed")
                || contentType.equals("application/x-7z-compressed")
                || contentType.equals("application/gzip")) {

            return "ARCHIVE";
        }

        // Code Files
        if (contentType.contains("javascript")
                || contentType.contains("java")
                || contentType.contains("python")
                || contentType.contains("x-python")) {

            return "SOURCE_CODE";
        }

        return "DOCUMENT";
    }
}