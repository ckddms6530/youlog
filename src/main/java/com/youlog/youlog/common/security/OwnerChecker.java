package com.youlog.youlog.common.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Supplier;

@Component
@Slf4j
@RequiredArgsConstructor
public class OwnerChecker implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {

        try {
            Long blogId = Long.valueOf(object.getVariables().get("blogId"));
            Map<Long, String> blogMap = ((CustomUserDetails) authentication.get().getPrincipal()).getBlogMap();
            return new AuthorizationDecision(blogMap.containsKey(blogId));
        } catch (Exception e) {
            log.warn("Failed to check authorization", e);
            return new AuthorizationDecision(false);
        }
    }

}


