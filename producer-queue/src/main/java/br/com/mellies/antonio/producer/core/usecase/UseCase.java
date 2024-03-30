package br.com.mellies.antonio.producer.core.usecase;

import br.com.mellies.antonio.producer.core.exception.UseCaseException;

public interface UseCase<I, O> {
    O execute(I input) throws UseCaseException;
}
