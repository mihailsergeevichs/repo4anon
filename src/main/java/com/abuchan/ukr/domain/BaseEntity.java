package com.abuchan.ukr.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by ********* on 17.02.2016.
 */
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @Column(name = "creation_time", nullable = false)
    private ZonedDateTime creationTime;

    @Column(name = "modification_time", nullable = false)
    private ZonedDateTime modificationTime;

    @Version
    private long version;

    public abstract ID getId();

    public ZonedDateTime getCreationTime() {
        return creationTime;
    }

    public ZonedDateTime getModificationTime() {
        return modificationTime;
    }

    public long getVersion() {
        return version;
    }

    @PrePersist
    public void prePersist() {
        ZonedDateTime now = ZonedDateTime.now();
        this.creationTime = now;
        this.modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = ZonedDateTime.now();
    }
}
