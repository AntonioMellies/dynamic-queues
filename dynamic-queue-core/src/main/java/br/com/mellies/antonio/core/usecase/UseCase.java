package br.com.mellies.antonio.core.usecase;

import br.com.mellies.antonio.core.exception.UseCaseException;

public interface UseCase<I, O> {
    O execute(I input) throws UseCaseException;
}
