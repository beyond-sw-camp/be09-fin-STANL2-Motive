package stanl_2.final_backend.domain.center.command.application.dto.response;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CenterRegistResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Integer memberCount;
    private String operatingAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Boolean active;
}
