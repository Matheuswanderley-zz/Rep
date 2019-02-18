package br.com.alugueAgora.transactions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
	
	private String transactionId;
	private JsonError error;
}
