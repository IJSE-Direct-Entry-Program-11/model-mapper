package lk.ijse.dep11.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    private String id;
    private String memberId;
    private String name;
    private LocalDate date;
}
