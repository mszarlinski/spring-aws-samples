package com.github.mszarlinski.aws.samples.s3.domain;

import java.io.InputStream;
import java.util.List;

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
public interface FilesManager {

    List<String> listBuckets();

    List<String> listFiles(String bucketId);

    InputStream loadFile(LoadFileQuery loadFileQuery);

    void saveFile(SaveFileCommand saveFileCommand);
}
