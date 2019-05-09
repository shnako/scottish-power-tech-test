package uk.co.scottishpower.techtest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Entity
public class MeterRead {
    @Id
    @NotNull()
    @Positive()
    private Long accountNumber;

    @NotNull()
    @Min(100000L)
    @Max(9999999999L)
    private Long gasId;

    @NotNull()
    @Min(1000000000000L)
    @Max(9999999999999L)
    private Long elecId;

    @NotNull()
    @Positive()
    private Long elecSmartRead;

    @NotNull()
    @Positive()
    private Long gasSmartRead;
}
