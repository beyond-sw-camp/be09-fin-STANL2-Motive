package stanl_2.final_backend.domain.A_sample.command.application.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SampleModifyRequestDTO {
    private String id;
    private String name;
    private Integer num;
}
