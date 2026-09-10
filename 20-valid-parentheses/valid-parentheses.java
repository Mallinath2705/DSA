class Solution {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            // Opening bracket
            if (current == '(' || current == '[' || current == '{') {
                stack[++top] = current;
            }

            // Closing bracket
            else {

                // Stack empty → matching opening bracket नाही
                if (top == -1) {
                    return false;
                }

                char peek = stack[top];

                if ((current == ')' && peek == '(') ||
                    (current == ']' && peek == '[') ||
                    (current == '}' && peek == '{')) {

                    top--;       // pop
                }
                else {
                    return false;
                }
            }
        }

        return top == -1;
    }
}