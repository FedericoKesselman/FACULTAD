package io.github.unlp_oo.Ej10_oo1;
import java.util.List;

public interface Strategy {
	public JobDescription next (List<JobDescription> jobs);
}
