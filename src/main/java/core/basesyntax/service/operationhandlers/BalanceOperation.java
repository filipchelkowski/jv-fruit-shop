package core.basesyntax.service.operationhandlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        Storage.getFruitStorage().put(
                transaction.getFruit(),
                transaction.getQuantity()
        );
    }
}
