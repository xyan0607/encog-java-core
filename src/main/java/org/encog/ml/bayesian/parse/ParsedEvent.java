package org.encog.ml.bayesian.parse;

import org.encog.ml.bayesian.BayesianError;
import org.encog.ml.bayesian.BayesianEvent;

public class ParsedEvent {
	private final String label;
	private String value;
	
	public ParsedEvent(String theLabel) {
		this.label = theLabel;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public int resolveValue(BayesianEvent actualEvent) {
		int result = 0;
		
		if( this.value==null ) {
			throw new BayesianError("Value is undefined for " + this.label + " should express a value with +, - or =.");
		}
		
		for(String choice: actualEvent.getChoices()) {
			if( this.value.equals(choice)) {
				return result;
			}
			result++;
		}
		
		throw new BayesianError("Can'f find choice " + this.value + " in the event " + this.label );
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[ParsedEvent:label=");
		result.append(this.label);
		result.append(",value=");
		result.append(this.value);
		result.append("]");
		return result.toString();
	}
	
}