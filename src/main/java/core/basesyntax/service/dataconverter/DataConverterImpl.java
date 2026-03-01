package core.basesyntax.service.dataconverter;

import core.basesyntax.service.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransactions(List<String> list) {
        list.remove(0);

        List<FruitTransaction> result = new ArrayList<>();

        for (String transaction : list) {
            String[] transactionBefore = transaction.split(",");
            result.add(new FruitTransaction(
                    transactionBefore[0],
                    transactionBefore[1],
                    Integer.parseInt(transactionBefore[2])));
        }

        return result;
    }
}
