package com.zg.hrjob_server.controller;

import com.zg.hrjob_server.common.ApiResponse;
import com.zg.hrjob_server.entity.VersionInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/version")
public class VersionController {

    @GetMapping("/check")
    public ApiResponse<VersionInfo> checkVersion(@RequestParam String currentVersion) {
        // 这里应该从数据库或配置文件中获取最新版本信息
        VersionInfo latestVersion = new VersionInfo();
        latestVersion.setVersion("1.1.0");
        latestVersion.setDownloadUrl("https://example.com/download/app-1.1.0.apk");
        latestVersion.setReleaseNotes("Bug fixes and performance improvements");
        latestVersion.setForceUpdate(false);

        // 比较版本号，这里使用简单的字符串比较，实际应用中应该使用更复杂的版本比较逻辑
        if (currentVersion.compareTo(latestVersion.getVersion()) < 0) {
            return ApiResponse.success(latestVersion);
        } else {
            return ApiResponse.success(null); // 返回成功响应，但data为null表示不需要更新
        }
    }
}