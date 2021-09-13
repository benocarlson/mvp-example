package edu.byu.cs.mvpexample.presenter;

import edu.byu.cs.mvpexample.model.WordStorage;

public class MainPresenter implements WordStorage.Observer {
    public interface MainView {
        void displayError();
        void showLastWord(String lastWord);
        String getInputString();
        void clearInput();
        void enableInput();
        void disableInput();
    }

    private MainView view;
    private WordStorage wordStorage;

    public MainPresenter(MainView view) {
        this.view = view;
        this.wordStorage = WordStorage.getInstance();
        wordStorage.register(this);
    }
    public void verifyText() {
        String input = view.getInputString();
        if (input == null || input.length() < 1) {
            view.disableInput();
        }
        else {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'e') {
                    view.disableInput();
                    return;
                }
            }
            view.enableInput();
        }
    }

    public void enterInput() {
        String input = view.getInputString();
        wordStorage.addWord(input);
        view.clearInput();

    }

    @Override
    public void update() {
        if (wordStorage.isErrorState()) {
            view.displayError();
        } else {
            view.showLastWord("Last Word: " + wordStorage.getLastWord());
        }
    }
}
