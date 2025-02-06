package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    /*
    Steps:
    Base Case: If open == 0 && close == 0, add the current string op to the result list.
    Recursive Case:
    If open > 0, append "(" and recurse (open - 1).
    If close > open, append ")" and recurse (close - 1).
    Terminate when all pairs are placed.

     */

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solve(n, n, "", list);
        System.out.println(list);
        return list;
    }

    public void solve(int open, int close, String op, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(op);
            return;
        }

        if (open != 0) {
            String op1 = op;
            op1 += "(";
            solve(open - 1, close, op1, list);
        }

        if (close > open) {
            String op2 = op;
            op2 += ")";
            solve(open, close - 1, op2, list);
        }
    }

    public static void main(String[] args) {
        new GenerateParentheses22().generateParenthesis(3);
    }
}
