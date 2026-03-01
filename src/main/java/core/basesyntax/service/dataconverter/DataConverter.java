package core.basesyntax.service.dataconverter;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransactions(List<String> list);
}
