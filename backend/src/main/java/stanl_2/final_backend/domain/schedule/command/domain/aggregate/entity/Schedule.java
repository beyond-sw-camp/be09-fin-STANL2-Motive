package stanl_2.final_backend.domain.schedule.command.domain.aggregate.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import stanl_2.final_backend.global.config.PrefixGeneratorConfig;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(name="SCHEDULE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Schedule {

    @Id
    @GeneratedValue(generator = "PrefixGeneratorConfig")
    @GenericGenerator(name = "PrefixGeneratorConfig",
                      type = PrefixGeneratorConfig.class,
                      parameters = @Parameter(name = "prefix", value = "SCH")
    )
    @Column(name = "SCH_ID", nullable = false)
    private String id;

    @Column(name = "SCH_NAME", nullable = false)
    private String name;

    @Column(name = "SCH_CONT", nullable = false)
    private String content;

    @Column(name = "SCH_RES", nullable = false)
    private String reservationTime;

    @Column(name = "CREATED_AT", nullable = false)
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "DELETED_AT")
    private Timestamp deletedAt;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active = true;

    @Column(name = "MEM_ID", nullable = false)
    private String memberId;

    /* 설명. updatedAt 자동화 */
    // Insert 되기 전에 실행
    @PrePersist
    public void prePersist() {
        this.createdAt = getCurrentTimestamp();
        this.updatedAt = this.createdAt;
    }

    // Update 되기 전에 실행
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = getCurrentTimestamp();
    }

    private Timestamp getCurrentTimestamp() {
        ZonedDateTime nowKst = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        return Timestamp.from(nowKst.toInstant());
    }
}
