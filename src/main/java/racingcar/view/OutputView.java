package racingcar.view;

public class OutputView {
    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    private static OutputView instance;

    private OutputView() {
    }

    public static synchronized OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void println(String string){
        System.out.println(string);
    }

    public void printException(Exception e){
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
    }
}
