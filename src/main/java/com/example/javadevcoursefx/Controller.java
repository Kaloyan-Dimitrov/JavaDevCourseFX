package com.example.javadevcoursefx;

import com.example.javadevcoursefx.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private ListView todoListView;

    @FXML
    private TextArea itemDetailsTextArea;
    private List<TodoItem> todoItems;

    @FXML
    private Label deadlineLabel;


    @FXML
    protected void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2022, Month.OCTOBER, 7));
        TodoItem item2 = new TodoItem("Doctor's Appointment", "See doctor Smith",
                LocalDate.of(2022, Month.NOVEMBER, 7));
        TodoItem item3 = new TodoItem("Finish design proposal online", "Send John an email",
                LocalDate.of(2022, Month.OCTOBER, 22));
        TodoItem item4 = new TodoItem("Pickup Doug at train station", "Buy a 30th birthday card for John",
                LocalDate.of(2022, Month.OCTOBER, 10));
        TodoItem item5 = new TodoItem("Pickup dry cleaning", "Clothes should be ready soon",
                LocalDate.of(2022, Month.OCTOBER, 15));

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if(newValue != null) {
                    TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy"); // "d M yy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

}








