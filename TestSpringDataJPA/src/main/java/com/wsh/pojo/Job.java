package com.wsh.pojo;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author huwenshuai
 * @date 2022/6/10 15:01
 */
@Table(name = "t_job")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
public class Job {

    @Id
    @Column(name = "jId")
    private Integer jId;

    @Column(length = 255)
    private String jName;

    @Column(length = 255)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return jId != null && Objects.equals(jId, job.jId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
