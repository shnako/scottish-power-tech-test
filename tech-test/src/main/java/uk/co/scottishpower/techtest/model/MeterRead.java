package uk.co.scottishpower.techtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "The account number must be specified")
    @Positive(message = "The account number must be positive")
    private Long accountNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "The gas id must be specified")
    @Min(value = 100000L, message = "The gas id must contain at least 6 digits")
    @Max(value = 9999999999L, message = "The gas id must contain at most 10 digits")
    private Long gasId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "The electricity id must be specified")
    @Min(value = 1000000000000L, message = "The electricity id must contain 13 digits")
    @Max(value = 9999999999999L, message = "The electricity id must contain 13 digits")
    private Long elecId;

    @NotNull(message = "The electricity reading must be specified")
    @Positive(message = "The electricity reading must be positive")
    private Long elecSmartRead;

    @NotNull(message = "The gas reading must be specified")
    @Positive(message = "The gas reading must be positive")
    private Long gasSmartRead;
}
