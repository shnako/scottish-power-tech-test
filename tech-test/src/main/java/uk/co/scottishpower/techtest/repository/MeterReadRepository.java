package uk.co.scottishpower.techtest.repository;

import org.springframework.data.repository.CrudRepository;
import uk.co.scottishpower.techtest.model.MeterRead;

public interface MeterReadRepository extends CrudRepository<MeterRead, Long> {
    MeterRead getByAccountNumber(Long accountNumber);
}
