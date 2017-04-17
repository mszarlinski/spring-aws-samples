package com.github.mszarlinski.aws.samples.s3

import com.github.mszarlinski.aws.samples.s3.domain.FilesManager
import com.github.mszarlinski.aws.samples.s3.domain.LoadFileQuery
import com.github.mszarlinski.aws.samples.s3.domain.SaveFileCommand

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
class TestFilesManager implements FilesManager {

    List<String> buckets = []

    @Override
    List<String> listBuckets() {
        return buckets
    }

    @Override
    List<String> listFiles(String bucketId) {
        return null
    }

    @Override
    InputStream loadFile(LoadFileQuery loadFileQuery) {
        return null
    }

    @Override
    void saveFile(SaveFileCommand saveFileCommand) {

    }
}
