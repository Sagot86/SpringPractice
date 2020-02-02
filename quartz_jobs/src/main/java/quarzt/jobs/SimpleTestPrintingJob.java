package quarzt.jobs;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quarzt.service.PrintingService;

import java.time.LocalDateTime;

@Component
@DisallowConcurrentExecution
@NoArgsConstructor
public class SimpleTestPrintingJob implements Job {

    private PrintingService printingService;

    @Autowired
    public void setPrintingService(PrintingService printingService) {
        this.printingService = printingService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        printingService.printCount("Count at jobStart = ", "");
        printingService.increment();
        printingService.printCount("Job after count is ", "");
        System.out.println(LocalDateTime.now());
        System.out.println("");
    }
}
