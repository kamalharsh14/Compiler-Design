package Task8.ApplyCFG;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private Grammar parsedGrammar;

    public Grammar parseGrammar(String input) {

        parsedGrammar = new Grammar();

        boolean initialSetup = true;

        String[] currentLine = input.split("\n");

        for(String s:currentLine) {
            if (initialSetup) {

                if (s.startsWith("V:")) {
                    parseStates((s.split(":")[1]).trim());
                }
                else if (s.startsWith("T:")) {
                    parseTerminals(s.split(":")[1].trim());
                }
                else if (s.startsWith("S:")) {
                    parseStartState(s.split(":")[1].trim());
                }
                else if (s.startsWith("P:")) {
                    initialSetup = false;
                }
            }
            else {
                parseRules(s.trim());
            }
        }

        return parsedGrammar;
    }

    public void parseStates(String newStates) {

        String[] splitStates = newStates.split(",");
        List<State> statesToAdd = new ArrayList<State>();

        for (String state: splitStates) {
            state = state.trim();
            State newState = new State(state.charAt(0));
            statesToAdd.add(newState);
        }

        parsedGrammar.setStates(statesToAdd);
    }

    public void parseTerminals(String terminals) {

        String[] splitTerminals = terminals.split(",");
        List<Character> terminalsToAdd = new ArrayList<Character>();

        for (String terminal: splitTerminals) {
            terminal = terminal.trim();
            terminalsToAdd.add(terminal.charAt(0));
        }

        parsedGrammar.setTerminals(terminalsToAdd);
    }

    public void parseStartState(String startState) {
        parsedGrammar.setStartState(parsedGrammar.getStateWithName(startState.trim().charAt(0)));
    }

    public void parseRules(String rulesToParse) {

        State stateToEdit = parsedGrammar.getStateWithName(rulesToParse.charAt(0));
        List<String> derivationsToAdd = new ArrayList<String>();
        String[] unparsedDerivations = rulesToParse.split("->")[1].trim().split("\\|");

        for (String derivation: unparsedDerivations) {
            derivation = derivation.trim();
            derivationsToAdd.add(derivation);
        }

        stateToEdit.setDerivations(derivationsToAdd);
    }

}
