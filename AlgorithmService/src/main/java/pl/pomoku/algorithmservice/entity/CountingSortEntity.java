package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.CountingSortInput;
import pl.pomoku.algorithmservice.dto.output.CountingSortOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class CountingSortEntity {
    @Id
    private String id;
    private int hash;
    private CountingSortInput input;
    private CountingSortOutput output;

    public CountingSortEntity(int hash, CountingSortInput input, CountingSortOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

