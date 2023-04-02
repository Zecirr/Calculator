package com.example.calculator;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import java.util.Objects;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) {
        final String[] values = {"0","0"};
        final String[] old = {"",""};
        final String[] choice = {""};
        final String[] oldChoice = {""};
        final String[] result = {""};
        final boolean[] input = {true};

        Text resultText = new Text(); {
            resultText.setFont(Font.font("Arial", FontWeight.BOLD,50));
            resultText.setFill(Paint.valueOf("white"));
            resultText.setTextAlignment(TextAlignment.RIGHT);
            resultText.setLayoutX(300);
            resultText.setText(values[0]);
        }
        Text calculationsText = new Text(); {
            calculationsText.setFont(Font.font("Arial", FontWeight.BOLD,20));
            calculationsText.setFill(Paint.valueOf("#888888"));
            calculationsText.setTextAlignment(TextAlignment.RIGHT);
            calculationsText.setLayoutX(300);
            calculationsText.setText("");
        }

        /*class CalcText {
            interface myInterface{
                void run();
            }
            void calcText() {
                myInterface r = () -> {
                    if(choice[0].equals("")){
                        calculationsText.setText(values[0]);
                    } else if (!values[1].equals("0") && !values[0].equals("0")) {
                        calculationsText.setText(values[1] + " " + choice[0] + " " + values[0]);
                    }else if (values[0].equals("0")) {
                        calculationsText.setText(values[1] + " " + choice[0]);
                    }
                };
                r.run();
            }
        }
        CalcText calcText = new CalcText();*/

        Button clear = new Button("C"); {
            clear.getStyleClass().add("symbols");
            clear.getStyleClass().add("wide");
            clear.setFont(Font.font("Arial",FontWeight.BOLD,35));
            clear.setOnAction(actionEvent -> {
                values[0] = "0";
                values[1] = "0";
                old[0] = "0";
                old[1] = "0";
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button delete = new Button("⌫"); {
            delete.getStyleClass().add("symbols");
            delete.getStyleClass().add("wide");
            delete.setFont(Font.font("Arial",FontWeight.BOLD,35));
            delete.setOnAction(actionEvent -> {
                values[0] = values[0].substring(0,values[0].length()-1);
                if(values[0].equals("")) values[0] = "0";
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }

        Button addition = new Button("+"); {
            addition.getStyleClass().add("symbols");
            addition.setFont(Font.font("Arial",FontWeight.BOLD,35));
            addition.setOnAction(actionEvent -> {
                if(!result[0].equals("Can't divide by 0")) {
                    choice[0] = "+";
                    if (result[0].equals("") || !values[0].equals("0")) {
                        values[1] = values[0];
                    } else {
                        values[1] = result[0];
                    }
                    values[0] = "0";
                    resultText.setText(values[0]);
                    /*calcText.calcText();*/
                }
            });
        }
        Button subtraction = new Button("-"); {
            subtraction.getStyleClass().add("symbols");
            subtraction.setFont(Font.font("Arial",FontWeight.BOLD,35));
            subtraction.setOnAction(actionEvent -> {
                if(!result[0].equals("Can't divide by 0")) {
                    choice[0] = "-";
                    if (result[0].equals("") || !values[0].equals("0")) {
                        values[1] = values[0];
                    } else {
                        values[1] = result[0];
                    }
                    values[0] = "0";
                    resultText.setText(values[0]);
                    /*calcText.calcText();*/
                }
            });
        }
        Button division = new Button("/"); {
            division.getStyleClass().add("symbols");
            division.setFont(Font.font("Arial", FontWeight.BOLD, 35));
            division.setOnAction(actionEvent -> {
                if (!result[0].equals("Can't divide by 0")) {
                    choice[0] = "/";
                    if (result[0].equals("") || !values[0].equals("0")) {
                        values[1] = values[0];
                    } else {
                        values[1] = result[0];
                    }
                    values[0] = "0";
                    resultText.setText(values[0]);
                    /*calcText.calcText();*/
                }
            });
        }
        Button multiplication = new Button("*"); {
            multiplication.getStyleClass().add("symbols");
            multiplication.setFont(Font.font("Arial",FontWeight.BOLD,35));
            multiplication.setOnAction(actionEvent -> {
                if(!result[0].equals("Can't divide by 0")) {
                    choice[0] = "*";
                    if (result[0].equals("") || !values[0].equals("0")) {
                        values[1] = values[0];
                    } else {
                        values[1] = result[0];
                    }
                    values[0] = "0";
                    resultText.setText(values[0]);
                    /*calcText.calcText();*/
                }
            });}

        Button equals = new Button("="); {
            equals.setId("equals");
            equals.getStyleClass().add("symbols");
            equals.setFont(Font.font("Arial",FontWeight.BOLD,35));
            equals.setOnAction(actionEvent -> {
                if(input[0]) {
                    result[0] = calculate(values,choice);
                    old[0] = values[0];
                    oldChoice[0] = choice[0];
                } else {
                    result[0] = calculate(old,oldChoice);
                }
                old[1] = result[0];

                choice[0] = "";
                values[0] = "0";
                values[1] = "0";
                input[0] = false;
                resultText.setText(result[0]);

                if(result[0].equals("Can't divide by 0")){
                    addition.getStyleClass().remove("symbols");
                    addition.getStyleClass().add("err");
                    subtraction.getStyleClass().remove("symbols");
                    subtraction.getStyleClass().add("err");
                    multiplication.getStyleClass().remove("symbols");
                    multiplication.getStyleClass().add("err");
                    division.getStyleClass().remove("symbols");
                    division.getStyleClass().add("err");
                }
            });
        }

        class Change {
            interface myInterface{
                void run();
            }
            void change() {
                myInterface r = () -> {
                    result[0] = values[0];
                    addition.getStyleClass().remove("err");
                    addition.getStyleClass().add("symbols");
                    subtraction.getStyleClass().remove("err");
                    subtraction.getStyleClass().add("symbols");
                    multiplication.getStyleClass().remove("err");
                    multiplication.getStyleClass().add("symbols");
                    division.getStyleClass().remove("err");
                    division.getStyleClass().add("symbols");
                };
                r.run();
            }
        }
        Change change = new Change();

        Button one = new Button("1"); {
            one.getStyleClass().add("numbers");
            one.setFont(Font.font("Arial",FontWeight.BOLD,35));
            one.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "1";
                } else {
                    values[0] += "1";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button two = new Button("2"); {
            two.getStyleClass().add("numbers");
            two.setFont(Font.font("Arial",FontWeight.BOLD,35));
            two.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "2";
                } else {
                    values[0] += "2";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button three = new Button("3"); {
            three.getStyleClass().add("numbers");
            three.setFont(Font.font("Arial",FontWeight.BOLD,35));
            three.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "3";
                } else {
                    values[0] += "3";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button four = new Button("4"); {
            four.getStyleClass().add("numbers");
            four.setFont(Font.font("Arial",FontWeight.BOLD,35));
            four.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "4";
                } else {
                    values[0] += "4";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button five = new Button("5"); {
            five.getStyleClass().add("numbers");
            five.setFont(Font.font("Arial",FontWeight.BOLD,35));
            five.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "5";
                } else {
                    values[0] += "5";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button six = new Button("6"); {
            six.getStyleClass().add("numbers");
            six.setFont(Font.font("Arial",FontWeight.BOLD,35));
            six.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "6";
                } else {
                    values[0] += "6";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button seven = new Button("7"); {
            seven.getStyleClass().add("numbers");
            seven.setFont(Font.font("Arial",FontWeight.BOLD,35));
            seven.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "7";
                } else {
                    values[0] += "7";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button eight = new Button("8"); {
            eight.getStyleClass().add("numbers");
            eight.setFont(Font.font("Arial",FontWeight.BOLD,35));
            eight.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "8";
                } else {
                    values[0] += "8";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button nine = new Button("9"); {
            nine.getStyleClass().add("numbers");
            nine.setFont(Font.font("Arial",FontWeight.BOLD,35));
            nine.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "9";
                } else {
                    values[0] += "9";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button zero = new Button("0"); {
            zero.getStyleClass().add("numbers");
            zero.setFont(Font.font("Arial",FontWeight.BOLD,35));
            zero.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "0";
                } else {
                    values[0] += "0";
                }
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }
        Button dot = new Button("."); {
            dot.getStyleClass().add("numbers");
            dot.setFont(Font.font("Arial",FontWeight.BOLD,35));
            dot.setOnAction(actionEvent -> {
                change.change();
                values[0] += ".";
                input[0] = true;
                resultText.setText(values[0]);
                /*calcText.calcText();*/
            });
        }

        BorderPane resultScreen = new BorderPane(); {
            resultScreen.setId("resultScreen");
            resultScreen.setRight(resultText);
        }
        /*BorderPane calculationsScreen = new BorderPane(); {
            calculationsScreen.setId("calculationsScreen");
            calculationsScreen.setRight(calculationsText);
        }*/
        GridPane controls = new GridPane(); {
            controls.setId("controls");
            controls.setHgap(5);
            controls.setVgap(5);
            controls.add(clear,0,0,2,1);
            controls.add(delete,2,0,2,1);
            controls.add(equals,0,4,2,1);
            controls.add(addition,3,1);
            controls.add(subtraction,3,2);
            controls.add(multiplication,3,3);
            controls.add(division,3,4);
            controls.add(one,0,1);
            controls.add(two,1,1);
            controls.add(three,2,1);
            controls.add(four,0,2);
            controls.add(five,1,2);
            controls.add(six,2,2);
            controls.add(seven,0,3);
            controls.add(eight,1,3);
            controls.add(nine,2,3);
            controls.add(zero,1,4);
            controls.add(dot,2,4);
        }
        VBox root = new VBox(); {
            root.setId("root");
            root.getChildren().addAll(/*calculationsScreen,*/resultScreen,controls);
        }

        Scene scene = new Scene(root,435,510);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("stylesheet.css")).toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    private String calculate(String[] values, String[] choice){
        float value1 = Float.parseFloat(values[1]);
        float value2 = Float.parseFloat(values[0]);
        return switch (choice[0]) {
            case "+" -> String.valueOf(value1 + value2);
            case "-" -> String.valueOf(value1 - value2);
            case "/" -> values[0].equals("0") ? "Can't divide by 0" : String.valueOf(value1 / value2);
            case "*" -> String.valueOf(value1 * value2);
            default -> values[0];
        };

    }

}