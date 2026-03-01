package core.basesyntax.service.operationhandlers;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.storage.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void performOperation(FruitTransaction transaction) {
        Storage.getFruitStorage().merge(
                transaction.getFruit(),
                transaction.getQuantity(),
                Integer::sum
        );
    }
}
