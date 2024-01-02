package lk.ijse.dep11.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueTO {
    private Integer issueId;
    private String memberId;
    private String memberName;
    private LocalDate issueDate;
}
