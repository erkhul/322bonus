import java.util.*;

public class search {

    ArrayList<Integer> assignment = new ArrayList<>();
    int failurecount;
    int solutioncount;
    ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
    String[] ordering = {"F", "H", "C", "D", "E", "G", "A", "B"};
    int index = 0;
    ArrayList<constraint> constraints = new ArrayList<>();

    class constraint {

        String var1;
        String var2;
        String operator;
        int cons;

        constraint(String v1, String v2, String op, int c){
            var1 = v1;
            var2 = v2;
            operator = op;
            cons = c;
        }

        public boolean checkConsistency(int v1, int v2){

            if (operator == "||=")
                return (Math.abs(v1-v2) == (this.cons));
            else if (operator == "||!=")
                return (Math.abs(v1-v2) != (this.cons));
            else if (operator == "||odd")
                return (Math.abs(v1 - v2)%2 == 1);
            else if (operator == "||even")
                return (Math.abs(v1 - v2)%2 == 0);
            else if (operator == "<")
                return v1<(v2 + this.cons);
            else if (operator == ">")
                return v1 > (v2 + this.cons);
            else if (operator == "<=")
                return v1 <= (v2 + this.cons);
            else if (operator == ">=")
                return v1>=(v2 + this.cons);
            else if (operator == "!=")
                return v1!=(v2 + this.cons);
            else if (operator == "=")
                return v1 == (v2 + this.cons);
            return true;
       }

    }

    public boolean checkAllConstraints() {

        for (int i=0; i<constraints.size(); i++){
            for (int j=0; j<assignment.size(); j++){
                if (ordering[j] == constraints.get(i).var1){
                    int val1 = assignment.get(j);
                    for (int k=0; k<assignment.size(); k++){
                        if (ordering[k] == constraints.get(i).var2){
                            int val2 = assignment.get(k);
                            if (!constraints.get(i).checkConsistency(val1, val2)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void BacktrackingSearch(ArrayList<Integer> a) {


        if (a.size() == 8) {
            System.out.println("solution");
            solutions.add((ArrayList<Integer>) assignment.clone());
            solutioncount++;
            return;
        }

        String s = ordering[index];
        for (int i = 1; i < 5; i++) {
            a.add(i);
            System.out.print(s + "=" + i + " ");
            if (checkAllConstraints()) {
                index++;
                BacktrackingSearch(a);
                index--;
            }
            else {
                System.out.println("failure");
                failurecount++;
            }
            a.remove(a.size() - 1);
        }
    }

    public void start(){

        constraints.add(new constraint("A", "G", ">=", 0 ));
        constraints.add(new constraint("G", "C", "||=", 1));
        constraints.add(new constraint("D", "C", "!=", 0));
        constraints.add(new constraint("G", "F", "!=", 0));
        constraints.add(new constraint("E", "F", "||odd", 0));
        constraints.add(new constraint("A", "H", "<", 0));
        constraints.add(new constraint("H", "C", "||even", 0));
        constraints.add(new constraint("E", "C", "!=", 0));
        constraints.add(new constraint("H", "F", "!=", 0));
        constraints.add(new constraint("F", "B", "||=", 1));
        constraints.add(new constraint("H", "D", "!=", 0));
        constraints.add(new constraint("E", "D", "<", -1));
        constraints.add(new constraint("C", "F", "!=", 0));
        constraints.add(new constraint("G", "H", "<", 0));
        constraints.add(new constraint("D", "G", ">=", 0));
        constraints.add(new constraint("E", "H", "!=", -2));
        constraints.add(new constraint("D", "F", "!=", 0));

        BacktrackingSearch(assignment);

        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("solution: ");
            for (int j = 0; j < 8; j++) {
                System.out.println(ordering[j] + ": " + solutions.get(i).get(j));  }
        }

       System.out.println("failedpaths: " + failurecount);
        System.out.println("solutionpaths: " + solutioncount);
    }

    public static void main(String args[]) {
        search CSP = new search();
        CSP.start();
    }

}

