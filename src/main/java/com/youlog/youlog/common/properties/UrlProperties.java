package com.youlog.youlog.common.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "url")
@RequiredArgsConstructor
@Getter
public class UrlProperties {

    private final String index;
    private final String signup;
    private final String login;
    private final String logout;
    private final String createPost;
    private final String viewPost;
    private final String editPost;
    private final String deletePost;
    private final String adminDashboard;
    private final String userManagement;
    private final String viewUser;
    private final String deleteUser;
    private final String manage;

    @NestedConfigurationProperty
    private final UrlProperties.Blog blog;
    @NestedConfigurationProperty
    private final UrlProperties.Post post;

    public record Blog(String home, String create, String manage, String delete, String view) {
    }

    public record Post(String write, String view) {
    }

}

