package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.dto.output.PartitionOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class PartitionEntity {
    @Id
    private String id;
    private int hash;
    private PartitionInput input;
    private PartitionOutput output;

    public PartitionEntity(int hash, PartitionInput input, PartitionOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}
