package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.MergeSortInput;
import pl.pomoku.algorithmservice.dto.output.MergeSortOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class MergeSortEntity {
    @Id
    private String id;
    private int hash;
    private MergeSortInput input;
    private MergeSortOutput output;

    public MergeSortEntity(int hash, MergeSortInput input, MergeSortOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

