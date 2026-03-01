package core.basesyntax.service.operationstrategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitTransaction.Operation operation);
}
