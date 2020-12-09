import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Java Streams & Lamda Expressions
		
		
		//Test Scenarios
		//1. Identify names starting with A in a list of Strings
		//2. Convert list of Strings to Uppercase and store it in a list
		//3. Find the unique elements in the list of Integers
		//4. Find the summation of list of integers
		//5. find if a given string extists in list of Strings

		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Chinmay");
		list.add("Chinmay");
		list.add("Jeeva");
		list.add("Vivek");
		list.add("Appaji");
		list.add("Amma");
		list.add("Vivek");
		
		String[] arrays = new String[5];
		arrays[0] = "Roshan";
		arrays[1] = "Vaishak";
		arrays[2] = "Varsha";
		arrays[3] = "Shruthi";
		arrays[4] = "Arjun";
		
		List<String> names=  Arrays.asList(arrays);
		
		//names.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		
		//list.parallelStream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		
		//list.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Set<String>  setLists = list.stream().map(s->s.toUpperCase()).collect(Collectors.toSet());
		setLists.stream().sorted().forEach(s->System.out.println(s));
		
		int[] numbers = {1,5,7,9,11,77,2,1,7,20};
		
		List<Integer> numList = Arrays.asList(1,5,7,9,11,77,2,1,7,20);
		numList.stream().distinct().forEach(i->System.out.println(i));
		
		
	}

}
