package fr.eni.gui;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML
    private Button chooseFileButton;
    @FXML
    private Button loadCSVButton;
    @FXML
    private TextArea contentTextArea;
    @FXML
    private TableView<StatEntry> statisticsTable;
    @FXML
    private Label linesHavingMissingValuesLB;
    @FXML
    private Label totalLinesLB;
    @FXML
    private TableView<ObservableList<String>> contentTable;
    @FXML
    private TableColumn<StatEntry, String> statTable_columnName;
    @FXML
    private TableColumn<StatEntry, String> statTable_missingValues;
    @FXML
    private TableColumn<StatEntry, String> statTable_missingValuesPercent;

    @FXML
    private void loadCSV() {

        final String content = contentTextArea.getText();

        List<String> lines = new ArrayList<>(Arrays.asList(content.split("\\r?\\n")));
        final String headersAsString = lines.remove(0);

        MatrixValues matrix = new MatrixValues();
        matrix.setHeaders(Arrays.asList(headersAsString.split(",")));

        for (String line : lines) {
            final List<String> lineElements = Arrays.asList(line.split(","))
                    .stream()
                    .map(s -> s.replaceAll("\"", "").strip())
                    .collect(Collectors.toList());
            matrix.addRow(lineElements);
        }

        final double widthPerColumn = (this.contentTable.getWidth() - 20) / matrix.getHeaders().size();
        final ObservableList<ObservableList<String>> items = this.contentTable.getItems();
        items.clear();
        ObservableList<TableColumn<ObservableList<String>, ?>> columns = this.contentTable.getColumns();
        columns.clear();
        final List<String> headers = matrix.getHeaders();
        for (int i = 0; i < headers.size(); i++) {
            final int index = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(headers.get(index));

            column.setPrefWidth(widthPerColumn);
            column.setCellFactory(c -> new TextFieldTableCell<>() {
                @Override
                public void updateItem(String t, boolean empty) {
                    super.updateItem(t, empty);

                    final int currentIndex = getIndex();
                    System.out.println("index : " + currentIndex);
                    if (currentIndex < 0 || currentIndex > items.size() - 1) {
                        return;
                    }
                    final ObservableList<String> row = items.get(getIndex());
                    System.out.println(".updateItem() : " + t + ";" + row);

                    Background bg = Background.EMPTY;
                    if (t == null || t.isEmpty()) {
                        System.out.println(".updateItem() : empty");
                        bg = new Background(new BackgroundFill(Color.rgb(255, 205, 205, 0.8), CornerRadii.EMPTY, Insets.EMPTY));

                    } else if (row.contains("")) {
                        System.out.println(".updateItem() : row contains empty");
                        bg = new Background(new BackgroundFill(Color.rgb(255, 240, 205, 0.5), CornerRadii.EMPTY, Insets.EMPTY));

                    }
                    setBackground(bg);

                }
            });

            column.setCellValueFactory(param
                    -> new ReadOnlyObjectWrapper<>(param.getValue().get(index))
            );
            columns.add(column);
        }

        this.statisticsTable.getItems().clear();
        this.statTable_columnName.setCellValueFactory(new PropertyValueFactory<>("columnName"));
        this.statTable_missingValues.setCellValueFactory(new PropertyValueFactory<>("missingValues"));
        this.statTable_missingValuesPercent.setCellValueFactory(new PropertyValueFactory<>("missingValuesPercent"));

        final Map<String, Integer> countMissingValuesByHeader = matrix.countMissingValuesByHeader();
        List<StatEntry> missingValuesStat = new ArrayList<>();
        final int total = matrix.getValues().size();
        countMissingValuesByHeader.forEach(
                (col, count) -> missingValuesStat.add(new StatEntry(col, count, percentage(count, total)))
        );

        this.totalLinesLB.setText(String.valueOf(total));
        this.linesHavingMissingValuesLB.setText(String.valueOf(matrix.countLinesHavingMissingValues()));
        this.statisticsTable.getItems().addAll(missingValuesStat);
        matrix.getValues().forEach(line -> items.add(FXCollections
                .observableArrayList(line)));

    }

    private static double percentage(Integer m, Integer total) {
        return Double.valueOf(Math.round(Double.valueOf(m) / total * 10000)) / 100;
    }

    @FXML
    private void loadFromFile() {
        final Scene scene = this.contentTextArea.getScene();
        FileChooser chooser = new FileChooser();
        final File file = chooser.showOpenDialog(scene.getWindow());
        try {
            String content = Files.readString(file.toPath());
            this.contentTextArea.setText(content);
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Une erreur est survenue pendant le chargement du fichier, détail :" + ex.getMessage());
            alert.setTitle("Erreur de chargement du fichier");
            ex.printStackTrace();
        }

    }
}
