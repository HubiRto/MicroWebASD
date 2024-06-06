package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.TreeCheckerInput;
import pl.pomoku.algorithmservice.dto.output.TreeCheckerOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class TreeCheckerEntity {
    @Id
    private String id;
    private int hash;
    private TreeCheckerInput input;
    private TreeCheckerOutput output;

    public TreeCheckerEntity(int hash, TreeCheckerInput input, TreeCheckerOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

