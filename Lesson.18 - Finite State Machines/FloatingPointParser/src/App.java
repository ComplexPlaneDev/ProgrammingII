class FSM {
    private enum States {
        Start,
        FirstIntegerDigit,
        IntegerDigit,
        InitialSign,
        InitialZero,
        Dot,
        FractDigit,
        ExponentMark,
        ExponentSign,
        ExponentFirstDigit,
        ExponentDigit
    }

    private States currentState = States.Start;

    public boolean isValid(String number) {
        if (number.isEmpty()) {
            return false;
        }

        currentState = States.Start;

        for (int i = 0; i < number.length(); ++i) {
            Character c = number.charAt(i);

            switch (currentState) {
                case States.Start:
                    if (c.equals('+') || c.equals('-')) {
                        currentState = States.InitialSign;
                    } else if (c.equals('0')) {
                        currentState = States.InitialZero;
                    } else if (c.equals('.')) {
                        currentState = States.Dot;
                    } else if (Character.isDigit(c)) {
                        currentState = States.FirstIntegerDigit;
                    } else {
                        return false;
                    }
                    break;

                case States.InitialSign:
                    if (c.equals('0')) {
                        currentState = States.InitialZero;
                    } else if (c.equals('.')) {
                        currentState = States.Dot;
                    } else if (Character.isDigit(c)) {
                        currentState = States.FirstIntegerDigit;
                    } else {
                        return false;
                    }
                    break;

                case States.InitialZero:
                    if (c.equals('.')) {
                        currentState = States.Dot;
                    } else {
                        return false;
                    }
                    break;

                case States.FirstIntegerDigit:
                    if (c.equals('.')) {
                        currentState = States.Dot;
                    } else if (Character.isDigit(c)) {
                        currentState = States.IntegerDigit;
                    } else if (c.equals('E')) {
                        currentState = States.ExponentMark;
                    } else {
                        return false;
                    }
                    break;

                case States.IntegerDigit:
                    if (c.equals('.')) {
                        currentState = States.Dot;
                    } else if (Character.isDigit(c)) {
                        currentState = States.IntegerDigit;
                    } else if (c.equals('E')) {
                        currentState = States.ExponentMark;
                    } else {
                        return false;
                    }
                    break;

                case States.Dot:
                    if (Character.isDigit(c)) {
                        currentState = States.FractDigit;
                    } else {
                        return false;
                    }
                    break;

                case States.FractDigit:
                    if (c.equals('E')) {
                        currentState = States.ExponentMark;
                    } else if (!Character.isDigit(c)) {
                        return false;
                    }
                    break;

                case States.ExponentMark:
                    if (c.equals('+') || c.equals('-')) {
                        currentState = States.ExponentSign;
                    } else {
                        return false;
                    }
                    break;

                case States.ExponentSign:
                    if (c.equals('0')) {
                        return false;
                    } else if (Character.isDigit(c)) {
                        currentState = States.ExponentFirstDigit;
                    } else {
                        return false;
                    }
                    break;

                case States.ExponentFirstDigit:
                    if (Character.isDigit(c)) {
                        currentState = States.ExponentDigit;
                    } else {
                        return false;
                    }
                    break;

                case States.ExponentDigit:
                    if (!Character.isDigit(c)) {
                        return false;
                    }
                    break;

                default:
                    return false;
            }
        }

        switch (currentState) {
            case States.InitialSign:
            case States.Dot:
            case States.ExponentMark:
            case States.ExponentSign:
                return false;

            default:
                return true;
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        final String[] numbers = {
            "1E10",
            "1E+10",
            "00.0",
            "-123.45",
            "-123.45E-10",
            "-.5",
            "-0.5",
            "-00.5",
            "-0.50",
            "-123.45E-10E",
            "."
        };

        final FSM fsm = new FSM();

        for (final String n : numbers) {
            System.out.printf("%s => %b\n", n, fsm.isValid(n));
        }
    }
}
