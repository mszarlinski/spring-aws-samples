package com.github.mszarlinski.aws.samples.s3.domain;

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
public class LoadFileQuery {
    private final String fileName;
    private final String bucketId;

    public LoadFileQuery(String fileName, String bucketId) {
        this.fileName = fileName;
        this.bucketId = bucketId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getBucketId() {
        return bucketId;
    }
}
