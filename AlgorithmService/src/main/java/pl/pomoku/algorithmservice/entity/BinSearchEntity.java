package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class BinSearchEntity {
    @Id
    private String id;
    private int hash;
    private BinSearchInput input;
    private BinSearchOutput output;

    public BinSearchEntity(int hash, BinSearchInput input, BinSearchOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

