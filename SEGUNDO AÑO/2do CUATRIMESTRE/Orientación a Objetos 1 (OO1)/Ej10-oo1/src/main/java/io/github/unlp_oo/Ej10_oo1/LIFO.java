package io.github.unlp_oo.Ej10_oo1;
import java.util.*;

public class LIFO implements Strategy{
	
	public JobDescription next(List<JobDescription> jobs) {
		JobDescription nextJob = null;
		
		if (jobs != null) 
				nextJob = jobs.get(jobs.size()-1);
		
		return nextJob;
	}

}
