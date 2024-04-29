package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.output.HoarePartitionOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class HoarePartitionEntity {
    @Id
    private String id;
    private int hash;
    private HoarePartitionInput input;
    private HoarePartitionOutput output;

    public HoarePartitionEntity(int hash, HoarePartitionInput input, HoarePartitionOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

