package uk.co.scottishpower.techtest.rest.smart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.scottishpower.techtest.constant.Params;
import uk.co.scottishpower.techtest.repository.MeterReadRepository;

@RestController
@RequestMapping("/api/smart/reads")
@Slf4j
public class MeterReadsResource {
    private final MeterReadRepository meterReadRepository;

    public MeterReadsResource(MeterReadRepository meterReadRepository) {
        this.meterReadRepository = meterReadRepository;
    }

    @GetMapping("/{" + Params.ACCOUNT_NUMBER + "}")
    public ResponseEntity getReads(@PathVariable(Params.ACCOUNT_NUMBER) long accountNumber) {
        if (accountNumber <= 0) {
            log.warn("Query rejected for invalid account number {}", accountNumber);
            return ResponseEntity.badRequest().body("Account number must be positive");
        }

        try {
            log.info("Loading smart meter details for account number {}", accountNumber);
            return ResponseEntity.ok(meterReadRepository.getByAccountNumber(accountNumber));
        } catch (Exception ex) {
            log.error("Unexpected error while loading meter reading", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
