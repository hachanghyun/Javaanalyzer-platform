package io.github.hachanghyun.Javaanalyzer.git.controller;

import io.github.hachanghyun.Javaanalyzer.common.dto.GitCloneRequest;
import io.github.hachanghyun.Javaanalyzer.git.service.GitCloneService;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/repository")
public class RepositoryController {

    private final GitCloneService gitCloneService;

    public RepositoryController(GitCloneService gitCloneService) {
        this.gitCloneService = gitCloneService;
    }

    @PostMapping("/clone")
    public ResponseEntity<?> cloneRepository(@RequestBody GitCloneRequest request) {
        try {
            Path clonedPath = gitCloneService.cloneRepository(request.getGitUrl());
            return ResponseEntity.ok().body("✅ 클론 성공: " + clonedPath.toString());
        } catch (GitAPIException | IOException e) {
            return ResponseEntity.badRequest().body("❌ 클론 실패: " + e.getMessage());
        }
    }
}
