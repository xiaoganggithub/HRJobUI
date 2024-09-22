package com.zg.hrjob_server.entity;

import lombok.Data;

@Data
public class VersionInfo {
    private String version;
    private String downloadUrl;
    private String releaseNotes;
    private boolean forceUpdate;
}