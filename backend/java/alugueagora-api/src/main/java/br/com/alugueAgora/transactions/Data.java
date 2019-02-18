package br.com.alugueAgora.transactions;

import java.util.List;

@lombok.Data
public class Data<T> {
	private String transactionId;
	private String version;
	private List<T> data;
}
