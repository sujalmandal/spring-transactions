package s.m.tx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import s.m.tx.entity.Transaction;

import java.util.Map;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TransactionResponseDTO {

    private Long id;
    private Transaction.Status status;
    private Map<String, String> transactionData;

}