package collins.kent.tutor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/***
 * Produces a medium length string with crossed indices demonstrating an exception.
 * 
 * @author kentcollins
 *
 */
public class SubstringIndexErrorProblem
		implements Problem {

	String s;
	int from;
	int to;

	@Override
	public Problem generate(Random rng) {
		List<String> words = StringSource.getInstance().getWords();
		// choose a medium length word
		List<String> collect = words.stream()
				.filter(s -> s.length() >= 3 && s.length() <= 6)
				.collect(Collectors.toList());
		s = collect.get(rng.nextInt(collect.size()));
		from = rng.nextInt(s.length()-1); 
		to = from + rng.nextInt(s.length()-from);
		// swap indices to create an exception
		int temp = to;
		to = from;
		from = temp;
		// avoid both indices the same which would not throw an exception
		if (from == to) from++;
		return this;
	}

	@Override
	public String getStatement() {
		String question ="\""+s+"\".substring("+from+", "+to+")";
		return question;
	}

	@Override
	public String getAnswer() {
		return IFTutor.getExceptionSymbol();
	}
	
	@Override
	public String getFeedback(String response) {
		if (isCorrect(response)) {
			return "Correct";
		}
		return "The first index is higher than the second -- an exception will be thrown when extracting the substring.";
	}

}