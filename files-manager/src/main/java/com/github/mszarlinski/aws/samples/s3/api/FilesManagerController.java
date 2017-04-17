package com.github.mszarlinski.aws.samples.s3.api;

import com.amazonaws.util.IOUtils;
import com.github.mszarlinski.aws.samples.s3.domain.FilesManager;
import com.github.mszarlinski.aws.samples.s3.domain.LoadFileQuery;
import com.github.mszarlinski.aws.samples.s3.domain.SaveFileCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author mszarlinski@gmail.com on 17/04/2017.
 */
@RestController
class FilesManagerController {

    private final FilesManager filesManager;

    FilesManagerController(FilesManager filesManager) {
        this.filesManager = filesManager;
    }

    @GetMapping("/buckets")
    List<String> listBuckets() {
        return filesManager.listBuckets();
    }


    @GetMapping("/buckets/{bucketId}/files")
    List<String> listFiles(@PathVariable String bucketId) {
        return filesManager.listFiles(bucketId);
    }

    @PostMapping("/buckets/{bucketId}/files")
    void saveFile(MultipartFile file, @PathVariable String bucketId) throws IOException {
        filesManager.saveFile(new SaveFileCommand(file.getOriginalFilename(), file.getBytes(), bucketId));
    }

    @GetMapping("/buckets/{bucketId}/files/{fileName}")
    void downloadFile(HttpServletResponse response, @PathVariable String bucketId, @PathVariable String fileName)
            throws IOException {
        IOUtils.copy(filesManager.loadFile(new LoadFileQuery(fileName, bucketId)), response.getOutputStream());
    }

}
