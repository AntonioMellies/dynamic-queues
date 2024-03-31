package br.com.mellies.antonio.core.usecase;

import br.com.mellies.antonio.core.exception.UseCaseException;

public interface UseCaseInput<I> {
    void execute(I input) throws UseCaseException;
}
