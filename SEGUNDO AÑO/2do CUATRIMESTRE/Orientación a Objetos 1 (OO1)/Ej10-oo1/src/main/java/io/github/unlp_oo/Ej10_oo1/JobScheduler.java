package io.github.unlp_oo.Ej10_oo1;
import java.util.*;

public class JobScheduler {
	private Strategy strategy;
	private List<JobDescription> jobs;
	
	public JobScheduler (Strategy strategy) {
		this.strategy = strategy;
		jobs = new LinkedList<JobDescription>();
	}
	
	public void schedule (JobDescription job) {
		this.jobs.add(job);
	}
	
	
	public void unschedule (JobDescription job) {
		if (job != null)
			this.jobs.remove(job);
	}
	
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public void setStratey(Strategy strategy) {
		this.strategy = strategy; 
	}
	
	public List<JobDescription> getJobs() {
		return this.jobs;
	}
	
	public JobDescription next() {
		JobDescription nextJob = this.strategy.next(this.jobs);
		
		this.unschedule(nextJob);
		
		return nextJob;
	}
}
