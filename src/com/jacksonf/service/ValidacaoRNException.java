package com.jacksonf.service;

/**
 * Classe responsável pela comunicação
 * de ocorrência de violação de regras
 * de negócio.
 * 
 * @author lossurdo
 */
public class ValidacaoRNException extends RuntimeException {

    public ValidacaoRNException() {
    }

    public ValidacaoRNException(String message) {
        super(message);
    }

    public ValidacaoRNException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacaoRNException(Throwable cause) {
        super(cause);
    }
    
}
