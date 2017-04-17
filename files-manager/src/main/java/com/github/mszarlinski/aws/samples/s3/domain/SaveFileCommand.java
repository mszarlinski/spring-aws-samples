package com.github.mszarlinski.aws.samples.s3.domain;

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
public class SaveFileCommand {

    private final String name;

    private final byte[] content;

    private final String bucketId;

    public SaveFileCommand(String name, byte[] content, String bucketId) {
        this.name = name;
        this.content = content;
        this.bucketId = bucketId;
    }

    public String getFileName() {
        return name;
    }

    public byte[] getContent() {
        return content;
    }

    public String getBucketId() {
        return bucketId;
    }
}
