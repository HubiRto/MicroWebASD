package pl.pomoku.algorithmservice.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.pomoku.algorithmservice.dto.input.QuickSortPartitionInput;
import pl.pomoku.algorithmservice.dto.output.QuickSortPartitionOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class QuickSortPartitionEntity {
    @Id
    private String id;
    private int hash;
    private QuickSortPartitionInput input;
    private QuickSortPartitionOutput output;

    public QuickSortPartitionEntity(int hash, QuickSortPartitionInput input, QuickSortPartitionOutput output) {
        this.hash = hash;
        this.input = input;
        this.output = output;
    }
}

