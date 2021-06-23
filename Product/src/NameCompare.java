import java.util.Comparator;

public class NameCompare implements Comparator<Employee>{
	public int compare(Employee m1,Employee m2) {
		return m1.name.compareTo(m2.name);
	}
}
