package lk.ijse.dep11;

import lk.ijse.dep11.entity.Issue;
import lk.ijse.dep11.to.IssueTO;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class Transformer3 {

    public static void main(String[] args) {
        IssueTO issueTO = new IssueTO(1, "M001", "Thisara", LocalDate.now());
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(IssueTO.class, Issue.class)
                .addMapping(IssueTO::getIssueId, Issue::setId);

        Issue issue = mapper.map(issueTO, Issue.class);
        System.out.println(issue);
    }
}
