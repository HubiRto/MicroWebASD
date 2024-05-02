package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.input.InsertionSortInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;
import pl.pomoku.algorithmservice.dto.output.InsertionSortOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class InsertionSortEntity {
    @Id
    private String id;
    private int hash;
    private InsertionSortInput input;
    private InsertionSortOutput output;

    public InsertionSortEntity(int hash, InsertionSortInput input, InsertionSortOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

