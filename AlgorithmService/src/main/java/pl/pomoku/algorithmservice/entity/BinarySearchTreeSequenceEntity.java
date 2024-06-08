package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.BinarySearchTreeSequenceInput;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeSequenceOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class BinarySearchTreeSequenceEntity {
    @Id
    private String id;
    private int hash;
    private BinarySearchTreeSequenceInput input;
    private BinarySearchTreeSequenceOutput output;

    public BinarySearchTreeSequenceEntity(int hash, BinarySearchTreeSequenceInput input, BinarySearchTreeSequenceOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

