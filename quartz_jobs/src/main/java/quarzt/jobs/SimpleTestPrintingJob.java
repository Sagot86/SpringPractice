package quarzt.jobs;

import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import quarzt.service.PrintingService;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SimpleTestPrintingJob implements Job {

    private final PrintingService printingService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        printingService.printCount("Count at jobStart = ", "");
        printingService.increment();
        printingService.printCount("Job after count is ", "");
        System.out.println(LocalDateTime.now());
    }
}
