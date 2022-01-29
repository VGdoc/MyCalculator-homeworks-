package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.IdRes;

public class Calc {
    long numberToDisplay; // переменная содержит значения для отображения
    final int DIGIT_RATE = 10; // константа для увеличения отображаемого числа

    protected TextView summaries; // поле отображения
    private final Button[] buttons = new Button[ExistButtons.values().length]; // массив всех кнопок калькулятора


    /**
     * Листенер класса. Содержит все действия для кнопок калькулятора
     */
    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                /////////////////////////////////////////////// цифры
                case (R.id.button_0):
                    addDigitsToDisplay(0);
                    break;
                case (R.id.button_1):
                    addDigitsToDisplay(1);
                    break;
                case (R.id.button_2):
                    addDigitsToDisplay(2);
                    break;
                case (R.id.button_3):
                    addDigitsToDisplay(3);
                    break;
                case (R.id.button_4):
                    addDigitsToDisplay(4);
                    break;
                case (R.id.button_5):
                    addDigitsToDisplay(5);
                    break;
                case (R.id.button_6):
                    addDigitsToDisplay(6);
                    break;
                case (R.id.button_7):
                    addDigitsToDisplay(7);
                    break;
                case (R.id.button_8):
                    addDigitsToDisplay(8);
                    break;
                case (R.id.button_9):
                    addDigitsToDisplay(9);
                    break;
                    /////////////////////////////////////////////////// дополнительные кнопки
                case (R.id.button_00):
                    addDigitsToDisplay(0);
                    addDigitsToDisplay(0);
                    break;
                case (R.id.button_coma):
                    //TODO
                    break;
                    /////////////////////////////////////////////////// кнопки управления
                case (R.id.button_clear):
                    numberToDisplay = 0;
                    summaries.setText(Long.toString(numberToDisplay));
                case (R.id.button_backspace):
                    //TODO
                    break;
                    /////////////////////////////////////////////////// кнопки действий
                case (R.id.button_persent): // %
                    //TODO
                    break;
                case (R.id.button_division): // деление
                     //TODO
                    break;
                case (R.id.button_multiplication): // *
                     //TODO
                    break;
                case (R.id.button_substraction): // -
                    //TODO
                    break;
                case (R.id.button_addition): // +
                    //TODO
                    break;
                case (R.id.button_equals): // =
                    //TODO
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        }
    };

    /**
     * Список существующих кнопок, содержащих свои ID
     */
    enum ExistButtons {

        ZERO(R.id.button_0),
        ONE(R.id.button_1),
        TWO(R.id.button_2),
        THREE(R.id.button_3),
        FOUR(R.id.button_4),
        FIVE(R.id.button_5),
        SIX(R.id.button_6),
        SEVEN(R.id.button_7),
        EIGHT(R.id.button_8),
        NINE(R.id.button_9),
        DIVISION(R.id.button_division),
        MULTIPLICATION(R.id.button_multiplication),
        SUBTRACTION(R.id.button_substraction),
        ADDITION(R.id.button_addition),
        EQUALS(R.id.button_equals),
        COMA(R.id.button_coma),
        CLEAR(R.id.button_clear),
        BACKSPACE(R.id.button_backspace),
        DOUBLE_ZERO(R.id.button_00),
        PERSENT(R.id.button_persent);

        private final int layoutID;

        ExistButtons(@IdRes int layoutID) {
            this.layoutID = layoutID;
        }

        public int getLayoutID() {
            return layoutID;
        }
    }

    /**
     * Инициализирует поле TextView для отображения операций пользователя
     * @param summaries ссылка на TextView из main_activity
     */
    public void setSummaries(TextView summaries) {
        this.summaries = summaries;
        summaries.setText(Long.toString(0));
    }

    /**
     * Подключает всем кнопкам в массиве Listener
     */
    public void setListeners() {
        for (Button b : buttons) {
            if (b != null) {
                b.setOnClickListener(listener);
            } else {
                System.out.println("присутствует нулевая ссылка на кнопку");
            }

        }
    }

    /**
     * Инициализирует кнопку из массива
     * @param button ссылка на кнопку из main_activity
     * @param index индекс в массиве
     */
    public void setButton(Button button, int index) {
        buttons[index] = button;
    }

    /**
     * Метод добавляет цифры на дисплей при нажатии на цифровые кнопки
     * @param digit какую цифу добавить
     */
    private void addDigitsToDisplay(int digit){
        numberToDisplay = numberToDisplay * DIGIT_RATE + digit;
        summaries.setText(Long.toString(numberToDisplay));
    }

}