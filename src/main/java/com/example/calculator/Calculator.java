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
        final String[] result = {""};
        final boolean[] input = {false};

        Text text = new Text(); {
            text.setFont(Font.font("Arial", FontWeight.BOLD,35));
            text.setFill(Paint.valueOf("White"));
            text.setTextAlignment(TextAlignment.RIGHT);
            text.setLayoutX(300);
            text.setText(values[0]);
        }

        Button addition = new Button("+"); {
            addition.getStyleClass().add("symbols");
            addition.setMinHeight(100);
            addition.setMinWidth(100);
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
                    text.setText(values[0]);
                }
            });
        }
        Button subtraction = new Button("-"); {
            subtraction.getStyleClass().add("symbols");
            subtraction.setMinHeight(100);
            subtraction.setMinWidth(100);
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
                    text.setText(values[0]);
                }
            });
        }
        Button division = new Button("/"); {
            division.getStyleClass().add("symbols");
            division.setMinHeight(100);
            division.setMinWidth(100);
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
                    text.setText(values[0]);
                }
            });
        }
        Button multiplication = new Button("*"); {
            multiplication.getStyleClass().add("symbols");
            multiplication.setMinHeight(100);
            multiplication.setMinWidth(100);
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
                    text.setText(values[0]);
                }
            });}

        Button equals = new Button("="); {
            equals.setId("equals");
            equals.setMinHeight(100);
            equals.setMinWidth(205);
            equals.setFont(Font.font("Arial",FontWeight.BOLD,35));
            equals.setOnAction(actionEvent -> {
                if(input[0]) {
                    result[0] = calculate(values,choice);
                    old[0] = values[0];
                } else {
                    result[0] = calculate(old,choice);
                }
                old[1] = result[0];

                choice[0] = "";
                values[0] = "0";
                values[1] = "0";
                input[0] = false;
                text.setText(result[0]);

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
            one.setMinHeight(100);
            one.setMinWidth(100);
            one.setFont(Font.font("Arial",FontWeight.BOLD,35));
            one.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "1";
                } else {
                    values[0] += "1";
                }
                input[0] = true;
                text.setText(values[0]);
            });
        }
        Button two = new Button("2"); {
            two.getStyleClass().add("numbers");
            two.setMinHeight(100);
            two.setMinWidth(100);
            two.setFont(Font.font("Arial",FontWeight.BOLD,35));
            two.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "2";
                } else {
                    values[0] += "2";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button three = new Button("3"); {
            three.getStyleClass().add("numbers");
            three.setMinHeight(100);
            three.setMinWidth(100);
            three.setFont(Font.font("Arial",FontWeight.BOLD,35));
            three.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "3";
                } else {
                    values[0] += "3";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button four = new Button("4"); {
            four.getStyleClass().add("numbers");
            four.setMinHeight(100);
            four.setMinWidth(100);
            four.setFont(Font.font("Arial",FontWeight.BOLD,35));
            four.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "4";
                } else {
                    values[0] += "4";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button five = new Button("5"); {
            five.getStyleClass().add("numbers");
            five.setMinHeight(100);
            five.setMinWidth(100);
            five.setFont(Font.font("Arial",FontWeight.BOLD,35));
            five.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "5";
                } else {
                    values[0] += "5";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button six = new Button("6"); {
            six.getStyleClass().add("numbers");
            six.setMinHeight(100);
            six.setMinWidth(100);
            six.setFont(Font.font("Arial",FontWeight.BOLD,35));
            six.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "6";
                } else {
                    values[0] += "6";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button seven = new Button("7"); {
            seven.getStyleClass().add("numbers");
            seven.setMinHeight(100);
            seven.setMinWidth(100);
            seven.setFont(Font.font("Arial",FontWeight.BOLD,35));
            seven.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "7";
                } else {
                    values[0] += "7";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button eight = new Button("8"); {
            eight.getStyleClass().add("numbers");
            eight.setMinHeight(100);
            eight.setMinWidth(100);
            eight.setFont(Font.font("Arial",FontWeight.BOLD,35));
            eight.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "8";
                } else {
                    values[0] += "8";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button nine = new Button("9"); {
            nine.getStyleClass().add("numbers");
            nine.setMinHeight(100);
            nine.setMinWidth(100);
            nine.setFont(Font.font("Arial",FontWeight.BOLD,35));
            nine.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "9";
                } else {
                    values[0] += "9";
                }
                input[0] = true;
                text.setText(values[0]);
            });}
        Button zero = new Button("0"); {
            zero.getStyleClass().add("numbers");
            zero.setMinHeight(100);
            zero.setMinWidth(100);
            zero.setFont(Font.font("Arial",FontWeight.BOLD,35));
            zero.setOnAction(actionEvent -> {
                change.change();
                if(values[0].equals("0")){
                    values[0] = "0";
                } else {
                    values[0] += "0";
                }
                input[0] = true;
                text.setText(values[0]);
            });}

        BorderPane screen = new BorderPane(); {
            screen.setId("screen");
            screen.setRight(text);
            screen.setMinHeight(60);
            screen.setMaxHeight(60);
        }
        GridPane controls = new GridPane(); {
            controls.setId("controls");
            controls.setHgap(5);
            controls.setVgap(5);
            controls.add(equals,0,3,2,1);
            controls.add(addition,3,0);
            controls.add(subtraction,3,1);
            controls.add(multiplication,3,2);
            controls.add(division,3,3);
            controls.add(one,0,0);
            controls.add(two,1,0);
            controls.add(three,2,0);
            controls.add(four,0,1);
            controls.add(five,1,1);
            controls.add(six,2,1);
            controls.add(seven,0,2);
            controls.add(eight,1,2);
            controls.add(nine,2,2);
            controls.add(zero,2,3);
        }
        VBox root = new VBox(); {
            root.setId("root");
            root.getChildren().addAll(screen,controls);
        }

        Scene scene = new Scene(root,435,495);
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