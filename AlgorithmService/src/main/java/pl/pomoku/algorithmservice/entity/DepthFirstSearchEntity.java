package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.input.DepthFirstSearchInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;
import pl.pomoku.algorithmservice.dto.output.DepthFirstSearchOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class DepthFirstSearchEntity {
    @Id
    private String id;
    private int hash;
    private DepthFirstSearchInput input;
    private DepthFirstSearchOutput output;

    public DepthFirstSearchEntity(int hash, DepthFirstSearchInput input, DepthFirstSearchOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

