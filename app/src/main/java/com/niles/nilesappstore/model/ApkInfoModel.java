package com.niles.nilesappstore.model;

import java.util.Arrays;

/**
 * Created by Niles
 * Date 2018/6/28 18:03
 * Email niulinguo@163.com
 */
public final class ApkInfoModel {

    private String buildKey;
    private String buildType;
    private String buildIsFirst;
    private String buildIsLastest;
    private String buildFileKey;
    private String buildFileName;
    private String buildFileSize;
    private String buildName;
    private String buildVersion;
    private String buildVersionNo;
    private String buildBuildVersion;
    private String buildIdentifier;
    private String buildIcon;
    private String buildPassword;
    private String buildDescription;
    private String buildUpdateDescription;
    private String buildLauncherActivity;
    private String buildScreenshots;
    private String buildShortcutUrl;
    private String buildCreated;
    private String buildUpdated;
    private String buildQRCodeURL;
    private String appKey;

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public static int hash(Object... values) {
        return Arrays.hashCode(values);
    }

    public String getBuildUpdated() {
        return buildUpdated;
    }

    public String getBuildCreated() {
        return buildCreated;
    }

    public String getBuildName() {
        return buildName;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public String getBuildVersionNo() {
        return buildVersionNo;
    }

    public String getBuildIdentifier() {
        return buildIdentifier;
    }

    public String getBuildBuildVersion() {
        return buildBuildVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApkInfoModel that = (ApkInfoModel) o;
        return equals(buildKey, that.buildKey) &&
                equals(buildType, that.buildType) &&
                equals(buildIsFirst, that.buildIsFirst) &&
                equals(buildIsLastest, that.buildIsLastest) &&
                equals(buildFileKey, that.buildFileKey) &&
                equals(buildFileName, that.buildFileName) &&
                equals(buildFileSize, that.buildFileSize) &&
                equals(buildName, that.buildName) &&
                equals(buildVersion, that.buildVersion) &&
                equals(buildVersionNo, that.buildVersionNo) &&
                equals(buildBuildVersion, that.buildBuildVersion) &&
                equals(buildIdentifier, that.buildIdentifier) &&
                equals(buildIcon, that.buildIcon) &&
                equals(buildPassword, that.buildPassword) &&
                equals(buildDescription, that.buildDescription) &&
                equals(buildUpdateDescription, that.buildUpdateDescription) &&
                equals(buildLauncherActivity, that.buildLauncherActivity) &&
                equals(buildScreenshots, that.buildScreenshots) &&
                equals(buildShortcutUrl, that.buildShortcutUrl) &&
                equals(buildCreated, that.buildCreated) &&
                equals(buildUpdated, that.buildUpdated) &&
                equals(buildQRCodeURL, that.buildQRCodeURL) &&
                equals(appKey, that.appKey);
    }

    @Override
    public int hashCode() {
        return hash(buildKey, buildType, buildIsFirst, buildIsLastest, buildFileKey, buildFileName, buildFileSize, buildName, buildVersion, buildVersionNo, buildBuildVersion, buildIdentifier, buildIcon, buildPassword, buildDescription, buildUpdateDescription, buildLauncherActivity, buildScreenshots, buildShortcutUrl, buildCreated, buildUpdated, buildQRCodeURL, appKey);
    }
}
