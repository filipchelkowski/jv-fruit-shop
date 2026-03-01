package core.basesyntax;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.dataconverter.DataConverter;
import core.basesyntax.service.dataconverter.DataConverterImpl;
import core.basesyntax.service.filereader.FileReader;
import core.basesyntax.service.filereader.FileReaderImpl;
import core.basesyntax.service.filewriter.FileWriter;
import core.basesyntax.service.filewriter.FileWriterImpl;
import core.basesyntax.service.operationhandlers.BalanceOperation;
import core.basesyntax.service.operationhandlers.OperationHandler;
import core.basesyntax.service.operationhandlers.PurchaseOperation;
import core.basesyntax.service.operationhandlers.ReturnOperation;
import core.basesyntax.service.operationhandlers.SupplyOperation;
import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.operationstrategy.OperationStrategyImpl;
import core.basesyntax.service.report.ReportGenerator;
import core.basesyntax.service.report.ReportGeneratorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions =
                dataConverter.convertToTransactions(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");

    }
}
