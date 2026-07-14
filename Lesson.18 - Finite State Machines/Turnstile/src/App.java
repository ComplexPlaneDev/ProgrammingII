class Turnstile {

    /** The finite, enumerable set of states  Q = { LOCKED, UNLOCKED }. */
    public enum State { LOCKED, UNLOCKED }

    /** The input alphabet  Sigma = { COIN, PUSH }. */
    public enum Input { COIN, PUSH }

    /** The current state. A well-defined FSM always has exactly one. */
    private State state = State.LOCKED;

    public State getState() {
        return state;
    }

    /**
     * The transition function  delta : (State x Input) -> State.
     */
    public void send(Input input) {
        switch (state) {
            case LOCKED -> {
                switch (input) {
                    case COIN -> {
                        System.out.println("coin accepted, turnstile UNLOCKS");
                        state = State.UNLOCKED;
                    }
                    case PUSH -> {
                        System.out.println("you cannot pass, insert a coin first");
                        // state stays LOCKED (self-loop)
                    }
                }
            }
            case UNLOCKED -> {
                switch (input) {
                    case COIN -> {
                        System.out.println("extra coin, but you are already unlocked");
                        // state stays UNLOCKED (self-loop)
                    }
                    case PUSH -> {
                        System.out.println("you go through, turnstile LOCKS again");
                        state = State.LOCKED;
                    }
                }
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Turnstile t = new Turnstile();
        Turnstile.Input[] sequence = {
            Turnstile.Input.PUSH,  // locked
            Turnstile.Input.COIN,  // locked -> unlocked
            Turnstile.Input.PUSH,  // unlocked -> pass -> locked
            Turnstile.Input.COIN,  // locked -> unlocked
            Turnstile.Input.COIN,  // unlocked
            Turnstile.Input.PUSH   // unlocked -> pass -> locked
        };

        System.out.println("=== Turnstile FSM demo ===");
        for (Turnstile.Input i : sequence) {
            System.out.println("State=" + t.getState() + "  input=" + i);
            t.send(i);
        }
        System.out.println("Final state = " + t.getState());
    }
}
