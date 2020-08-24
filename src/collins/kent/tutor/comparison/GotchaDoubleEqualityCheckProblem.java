package collins.kent.tutor.comparison;

import java.util.Random;

import collins.kent.tutor.Problem;
import collins.kent.tutor.Meta;

@Meta(skill = "Identify that comparisons between doubles may produce inconsistent results")
public class GotchaDoubleEqualityCheckProblem implements Problem {

	String s1 = "0.1 + 0.2 == 0.3"; // false
	String s2 = "0.3 == 0.1 + 0.2"; // false
	String s3 = "0.1 + 0.2 <= 0.3"; // false
	String s4 = "0.1 + 0.2 != 0.3"; // true
	String s5 = "0.3 < 0.1 + 0.2"; // true
	String[] options = { s1, s2, s3, s4, s5 };
	int choice;
	String f1 = "An explanation is appropriate. This expression evaluates false.  Unlike integers, doubles are inexact values. Use comparison operators carefully.";
	String f2 = "An explanation is appropriate. This expression evaluates true.  Unlike integers, doubles are inexact values. Use comparison operators carefully.";
	String[] feedback = { f1, f1, f1, f2, f2 };

	@Override
	public Problem generate(Random rng) {
		choice = rng.nextInt(options.length);
		return this;
	}

	@Override
	public String getStatement() {
		return options[choice];
	}

	@Override
	public String getAnswer() {
		return "e";
	}

	@Override
	public String getFeedback(String s) {
		return feedback[choice];
	}

}
