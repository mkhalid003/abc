package com.abc.abccustomerbatchservice.batch;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	@Autowired
	CustomerReader customerReader;
	@Autowired
	CustomerWriter customerWriter;
	@Autowired
	CustomerProcessor customerProcessor;

	@Bean
	public Job processJob() throws Exception {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.flow(csvReadingStep())
				.end()
				.build();
	}

	@Bean
	public Step csvReadingStep() throws Exception {
		return stepBuilderFactory.get("orderStep1").<Object, Object> chunk(10)
				//.reader(customerReader.readEPEFile())
				.reader(customerReader.readCustomerXML())
				.processor(customerProcessor)
				.writer(customerWriter)
				.build();
	}
	

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}