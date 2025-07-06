package io.github.hachanghyun.Javaanalyzer.git.service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class GitCloneService {

    public Path cloneRepository(String gitUrl) throws GitAPIException, IOException {
        Path tempDir = Files.createTempDirectory("cloned-repo-");
        Git.cloneRepository()
                .setURI(gitUrl)
                .setDirectory(tempDir.toFile())
                .call();
        return tempDir;
    }
}
