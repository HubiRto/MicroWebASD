package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.TraverseConverterInput;
import pl.pomoku.algorithmservice.dto.output.TraverseConverterOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class TraverseConverterEntity {
    @Id
    private String id;
    private int hash;
    private TraverseConverterInput input;
    private TraverseConverterOutput output;

    public TraverseConverterEntity(int hash, TraverseConverterInput input, TraverseConverterOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

