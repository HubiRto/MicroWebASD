package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.StackSequenceInput;
import pl.pomoku.algorithmservice.dto.output.StackSequenceOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class StackSequenceEntity {
    @Id
    private String id;
    private int hash;
    private StackSequenceInput input;
    private StackSequenceOutput output;

    public StackSequenceEntity(int hash, StackSequenceInput input, StackSequenceOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

