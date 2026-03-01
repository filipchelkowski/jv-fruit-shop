package core.basesyntax.service;

import core.basesyntax.service.operationhandlers.OperationHandler;
import core.basesyntax.service.operationstrategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler =
                    strategy.getHandler(transaction.getOperation());
            handler.performOperation(transaction);
        }
    }
}
