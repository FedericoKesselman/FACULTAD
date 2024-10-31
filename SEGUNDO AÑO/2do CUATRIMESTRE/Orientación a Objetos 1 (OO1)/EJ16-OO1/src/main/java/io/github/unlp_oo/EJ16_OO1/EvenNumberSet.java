package io.github.unlp_oo.EJ16_OO1;
import java.util.*;

public class EvenNumberSet<Integer> extends HashSet<Integer>{
	
	@Override
	public boolean add (Integer num) {
		if ((int)num % 2 == 0)
			return super.add(num);
		return false;
	}

}
