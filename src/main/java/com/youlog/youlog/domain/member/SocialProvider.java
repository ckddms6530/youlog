package com.youlog.youlog.domain.member;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "social_provider")
@Getter
@NoArgsConstructor
public class SocialProvider extends BaseEntity {

        @Column(name = "name")
        private String name;

        private SocialProvider(String name) {
            this.name = name;
        }

        public static SocialProvider createSocialProvider(String name) {
            return new SocialProvider(name);
        }

        public void updateSocialProvider(String name) {
            this.name = name;
        }
}
