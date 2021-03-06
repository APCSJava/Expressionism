package collins.kent.tutor.literals;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill="Recognize literals of type String")
public class RecognizeStringLiteralProblem implements Problem {
	
	private static String[] strings = { "cat", "dog", "fox", "ant",
			"Bob" };
	private String displayString;

	@Override
	public Problem generate(Random rng) {
		displayString = "\"" + strings[rng.nextInt(strings.length)]
				+ "\"";
		return this;
	}


	@Override
	public String getStatement() {
		return "What is the type of the following literal value?\n  "
				+ displayString;
	}

	@Override
	public String getAnswer() {
		return "String";
	}
}
