package d.ls.core.utl.fsa.aset;

import org.apache.lucene.util.automaton.Automaton;
import org.apache.lucene.util.automaton.BasicAutomata;
import org.apache.lucene.util.automaton.BasicOperations;

public class AutomatonSet1 {

	private Automaton mergedAutomaton;
	
	public void add(String newTerm) {
		newTerm = newTerm.toUpperCase();
		if (mergedAutomaton == null) {
			mergedAutomaton = BasicAutomata.makeString(newTerm);
		} else {
			mergedAutomaton = BasicOperations.union(mergedAutomaton,BasicAutomata.makeString(newTerm));
		}
		mergedAutomaton = Automaton.minimize(mergedAutomaton);
	}
	
	public int numNodes() {
		return mergedAutomaton.getNumberOfStates();
	}
	
	public int numTransitions() {
		return mergedAutomaton.getNumberOfTransitions();
	}
	
	public AutomatonSet1() {
		
	}
	
}
