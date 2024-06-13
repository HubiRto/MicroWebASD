package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.AVLTreeSequenceInput;
import pl.pomoku.algorithmservice.dto.output.AVLTreeSequenceOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class AVLTreeSequenceEntity {
    @Id
    private String id;
    private int hash;
    private AVLTreeSequenceInput input;
    private AVLTreeSequenceOutput output;

    public AVLTreeSequenceEntity(int hash, AVLTreeSequenceInput input, AVLTreeSequenceOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

