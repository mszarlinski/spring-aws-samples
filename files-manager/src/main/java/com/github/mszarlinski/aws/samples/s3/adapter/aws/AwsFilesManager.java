package com.github.mszarlinski.aws.samples.s3.adapter.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.github.mszarlinski.aws.samples.s3.domain.FilesManager;
import com.github.mszarlinski.aws.samples.s3.domain.LoadFileQuery;
import com.github.mszarlinski.aws.samples.s3.domain.SaveFileCommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
class AwsFilesManager implements FilesManager {

    private final AmazonS3 s3;

    AwsFilesManager(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
    public List<String> listBuckets() {
        return s3.listBuckets()
                .stream()
                .map(Bucket::getName)
                .collect(toList());
    }

    @Override
    public List<String> listFiles(String bucketId) {
        return s3.listObjects(bucketId)
                .getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(toList());
    }

    @Override
    public InputStream loadFile(LoadFileQuery loadFileQuery) {
        S3Object object = s3.getObject(new GetObjectRequest(loadFileQuery.getBucketId(), loadFileQuery.getFileName()));
        return object.getObjectContent();
    }

    @Override
    public void saveFile(SaveFileCommand saveFileCommand) {
        s3.putObject(new PutObjectRequest(saveFileCommand.getBucketId(), saveFileCommand.getFileName(),
                new ByteArrayInputStream(saveFileCommand.getContent()), new ObjectMetadata()));
    }
}
