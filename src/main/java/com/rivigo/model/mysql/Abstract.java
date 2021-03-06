package com.rivigo.model.mysql;
/*
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OptimisticLock;
import org.joda.time.DateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Setter
@Getter
@MappedSuperclass
@Slf4j
 abstract class AbstractEntity  {

    @Column(nullable = false, name = "created_at")
    protected DateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    @OptimisticLock(excluded = true)
    protected DateTime UpdatedAt;

    @Column(nullable = false, name = "is_active")
    protected Boolean isActive;

    @PrePersist
    protected void onCreate() {
        this.UpdatedAt = this.createdAt = DateTime.now();
        this.isActive = true;

    }

    @PreUpdate
    protected void onUpdate() {
        this.UpdatedAt = DateTime.now();
    }
}
*/