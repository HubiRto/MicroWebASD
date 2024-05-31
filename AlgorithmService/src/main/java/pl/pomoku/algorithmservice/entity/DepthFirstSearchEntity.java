package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.FirstSearchInput;
import pl.pomoku.algorithmservice.dto.output.FirstSearchOutput;

@AllArgsConstructor
@NoArgsConstructor
@Document
public class DepthFirstSearchEntity extends FirstSearchEntity {
    @Id
    private String id;

    public DepthFirstSearchEntity(int hash, FirstSearchInput input, FirstSearchOutput output) {
        super(hash, input, output);
    }
}

