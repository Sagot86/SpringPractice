package quarzt.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import quarzt.jobs.SimpleTestPrintingJob;

import java.util.GregorianCalendar;
import java.util.Properties;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class QuartzConfig {

    @Value("${app.jobs.scheduler.cron.simpleTestJob: 30/15 * * * * ?}")
    private String simpleTestJobCron;

    private final ApplicationContext applicationContext;

    @Bean
    public SchedulerFactoryBean quartzScheduler(Trigger[] triggers, JobDetail[] jobs) {
        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();
        quartzScheduler.setQuartzProperties(getProperties());
        quartzScheduler.setJobFactory(springBeanJobFactory());
        quartzScheduler.setTriggers(triggers);
        quartzScheduler.setJobDetails(jobs);
        return quartzScheduler;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public JobDetailFactoryBean simpleTestPrintingDetail() {
        return createJobDetail(SimpleTestPrintingJob.class, "Just a test printing job");
    }

    @Bean
    public CronTriggerFactoryBean simpleTestPrintingTrigger(@Qualifier("simpleTestPrintingDetail") JobDetailFactoryBean jobDetailFactoryBean) {
        return createCronJobTrigger(jobDetailFactoryBean, simpleTestJobCron);
    }

    private JobDetailFactoryBean createJobDetail(Class<? extends Job> jobClass, String jobDescription) {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(jobClass);
        jobDetailFactory.setDescription(jobDescription);
        jobDetailFactory.setDurability(true);
        jobDetailFactory.setRequestsRecovery(true);
        return  jobDetailFactory;
    }

    private CronTriggerFactoryBean createCronJobTrigger(JobDetailFactoryBean jobDetail, String cronString) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail.getObject());
        GregorianCalendar calendar = new GregorianCalendar(2019, 0, 1, 0, 0, 0);
        cronTriggerFactoryBean.setStartTime(calendar.getTime());
        cronTriggerFactoryBean.setCronExpression(cronString);
        return cronTriggerFactoryBean;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("org.quartz.scheduler.instanceName", "MyInstanceName");
        properties.setProperty("org.quartz.scheduler.instanceId", "Instance1");
        properties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
        return properties;
    }
}