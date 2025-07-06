package io.github.hachanghyun.Javaanalyzer.common.dto;

import lombok.Setter;

@Setter
public class GitCloneRequest {
    private String gitUrl;

    public String getGitUrl() {
        return gitUrl;
    }
}
