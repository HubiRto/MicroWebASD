package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.RadixSortInput;
import pl.pomoku.algorithmservice.dto.output.RadixSortOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class RadixSortEntity {
    @Id
    private String id;
    private int hash;
    private RadixSortInput input;
    private RadixSortOutput output;

    public RadixSortEntity(int hash, RadixSortInput input, RadixSortOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

