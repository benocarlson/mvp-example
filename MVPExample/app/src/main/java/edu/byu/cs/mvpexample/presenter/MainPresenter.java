package edu.byu.cs.mvpexample.presenter;

public class MainPresenter {

    private MainView view;

    public interface MainView {
        String getStringInput();
        void invalidInput();
        void validInput();
    }

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void validateInput() {
        String input = view.getStringInput();
        if (input != null && input.length() > 0) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'e') {
                    view.invalidInput();
                    return;
                }
            }
            view.validInput();
        } else {
            view.invalidInput();
        }
    }
}
