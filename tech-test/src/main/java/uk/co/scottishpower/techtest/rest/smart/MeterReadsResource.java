package uk.co.scottishpower.techtest.rest.smart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.scottishpower.techtest.constant.Params;
import uk.co.scottishpower.techtest.repository.MeterReadRepository;

@RestController
@RequestMapping("/api/smart/reads")
public class MeterReadsResource {
    private final MeterReadRepository meterReadRepository;

    public MeterReadsResource(MeterReadRepository meterReadRepository) {
        this.meterReadRepository = meterReadRepository;
    }

    @GetMapping("/{" + Params.ACCOUNT_NUMBER + "}")
    public ResponseEntity getReads(@PathVariable(Params.ACCOUNT_NUMBER) long accountNumber) {
        return ResponseEntity.ok(meterReadRepository.getByAccountNumber(accountNumber));
    }
}
