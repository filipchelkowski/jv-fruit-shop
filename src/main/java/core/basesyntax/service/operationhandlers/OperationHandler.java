package core.basesyntax.service.operationhandlers;

import core.basesyntax.service.FruitTransaction;

public interface OperationHandler {
    public void performOperation(FruitTransaction transaction);
}
