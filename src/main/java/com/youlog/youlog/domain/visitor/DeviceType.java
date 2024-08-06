package com.youlog.youlog.domain.visitor;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "device_type")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeviceType extends BaseEntity {

    @Column(name = "name")
    private String name;
}
