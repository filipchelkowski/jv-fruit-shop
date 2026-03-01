package core.basesyntax.service.report;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry
                : Storage.getFruitStorage().entrySet()) {

            sb.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
