package io.github.unlp_oo.Ej10_oo1;
import java.util.*;

public class FIFO implements Strategy{
	
	public JobDescription next(List<JobDescription> jobs) {
		JobDescription nextJob = null;
		
		if (jobs != null)
				nextJob = jobs.get(0);
		
		return nextJob;
	}

}
