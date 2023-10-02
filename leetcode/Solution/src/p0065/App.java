package p0065;

interface NumberState {
    boolean canEnd();

    NumberState toNextState(char c);

    default boolean isDigit(char c) {
        int num = c - '0';
        return num >= 0 && num <= 9;
    }

    default boolean isE(char c) {
        return (c == 'E' || c == 'e');
    }
}

class Start implements NumberState {

    @Override
    public boolean canEnd() {
        return false;
    }

    @Override
    public NumberState toNextState(char c) {
        if (c == '+' || c == '-') {
            return new Sign();
        } else if (isDigit(c)) {
            return new BeforeDotNumber();
        } else if (c == '.') {
            return new StartWithDot();
        }
        throw new IllegalArgumentException();
    }

}

class Sign implements NumberState {
    @Override
    public boolean canEnd() {
        return false;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return new BeforeDotNumber();
        } else if (c == '.') {
            return new StartWithDot();
        }
        throw new IllegalArgumentException();
    }

}

class BeforeDotNumber implements NumberState {

    @Override
    public boolean canEnd() {
        return true;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return this;
        } else if (c == '.') {
            return new Dot();
        } else if (c == 'E' || c == 'e') {
            return new ExponentStart();
        }
        throw new IllegalArgumentException();
    }

}

class StartWithDot implements NumberState {

    @Override
    public boolean canEnd() {
        return false;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return new AfterDotNumber();
        }
        throw new IllegalArgumentException();
    }

}

class Dot implements NumberState {

    @Override
    public boolean canEnd() {
        return true;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return new AfterDotNumber();
        } else if (isE(c)) {
            return new ExponentStart();
        }
        throw new IllegalArgumentException();
    }
}

class AfterDotNumber implements NumberState {
    @Override
    public boolean canEnd() {
        return true;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return this;
        } else if (c == 'e' || c == 'E') {
            return new ExponentStart();
        }
        throw new IllegalArgumentException();
    }

}

class ExponentStart implements NumberState {

    @Override
    public boolean canEnd() {
        return false;
    }

    @Override
    public NumberState toNextState(char c) {
        if (c == '+' || c == '-') {
            return new ExponentSign();
        } else if (isDigit(c)) {
            return new ExponentNumber();
        }
        throw new IllegalArgumentException();
    }

}

class ExponentSign implements NumberState {

    @Override
    public boolean canEnd() {
        return false;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return new ExponentNumber();
        }
        throw new IllegalArgumentException();
    }

}

class ExponentNumber implements NumberState {

    @Override
    public boolean canEnd() {
        return true;
    }

    @Override
    public NumberState toNextState(char c) {
        if (isDigit(c)) {
            return this;
        }
        throw new IllegalArgumentException();
    }

}

class Solution {
    public boolean isNumber(String s) {
        NumberState state = new Start();
        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                state = state.toNextState(c);
            }
            return state.canEnd();
        } catch (Exception e) {
        }
        return false;
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println(new Solution().isNumber(".1"));
    }
}
