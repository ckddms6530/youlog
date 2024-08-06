package com.youlog.youlog.domain.visitor;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "visitor")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visitor extends BaseEntity {

    @Column(name = "token")
    private String token;
    @Column(name = "browser")
    private String browser;
    @JoinColumn(name = "device_type_id")
    @ManyToOne
    private DeviceType deviceType;

    public Visitor(String browser, DeviceType deviceType) {
        this.token = UUID.randomUUID().toString();
        this.browser = browser;
        this.deviceType = deviceType;
    }

}
