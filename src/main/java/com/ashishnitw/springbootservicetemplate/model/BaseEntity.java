package com.ashishnitw.springbootservicetemplate.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseEntity implements Serializable {

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
    }

    @PostPersist
    public void postPersist() {
    }
}
