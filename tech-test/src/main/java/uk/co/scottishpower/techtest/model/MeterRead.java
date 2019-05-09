package uk.co.scottishpower.techtest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class MeterRead {
    @Id
    private Long accountNumber;
    private Long gasId;
    private Long elecId;
    private Long elecSmartRead;
    private Long gasSmartRead;
}
