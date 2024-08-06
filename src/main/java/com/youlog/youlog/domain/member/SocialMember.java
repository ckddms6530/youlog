package com.youlog.youlog.domain.member;

public class SocialMember extends Member{

    private Long socialProviderId;
    private String socialClientId;

    public static class SocialProvider {
        private Long id;
        private String name;
    }
    private SocialMember(Long socialProviderId, String socialClientId, String nickname) {
        super(nickname);
        this.socialProviderId = socialProviderId;
        this.socialClientId = socialClientId;
    }

}
