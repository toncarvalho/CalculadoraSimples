package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // instanciando o container principal da janela
        VBox painel =  new VBox();
        // definindo espaçamento entre as bordas da janela e os componentes
        painel.setPadding( new Insets(10));

        // componentes de entrada de dados
        Label lblV1 = new Label("Valor 1:");
        final TextField edtV1 = new TextField();
        Label lblv2 = new Label("Valor 2:");
        final TextField edtV2 = new TextField();
        Label lblResultado = new Label("Resultado:");
        final TextField edtResultado = new TextField();


        // caixa horizontal para poder alinhas os botões um ao lado do outro
        HBox botoes = new HBox();
        //espaçamento entre as bordas da janela e os componentes
        botoes.setPadding( new Insets(10));
        // espaçamento entre os componentes dentro do container
        botoes.setSpacing(12);

        // instanciando componente de botão e atribuindo automaticamente um rotulo
        Button btnCalcular = new Button("Calcular");

        /* atribuindo uma ação a um botão, no caso executando uma operação matemática
        simples e atribuindo o resultado a um campo de texto*/

        btnCalcular.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Double v1 = new Double(edtV1.getText());
                Double v2 = new Double(edtV1.getText());

                Double x =  v1 + v2 ;

                edtResultado.setText(x.toString());

            }
        });

        Button btnLimpar = new Button("Limpar") ;
        btnLimpar.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                edtV1.setText(null);
                edtV2.setText(null);
                edtResultado.setText(null);
            }
        });

        // adicionando os botões ao container de botoes ( HBOX)
        botoes.getChildren().addAll(btnCalcular,btnLimpar);

        // adicionando os componentes de rótulo(texto) e entrada de dados no container principal
        painel.getChildren().add(lblV1);
        painel.getChildren().add(edtV1);
        painel.getChildren().add(lblv2);
        painel.getChildren().add(edtV2);

        // adicionando o container de botões e seu conteúdo, ao container principal
        painel.getChildren().add(botoes);
        //adicionando o rotulo e componente de texto do resultado ao container principal
        painel.getChildren().add(lblResultado);
        painel.getChildren().add(edtResultado);

        // definindo um título para a janela
        primaryStage.setTitle("Exemplo 1");

        /* instanciando uma Scena do javafx, passando o container principal e o
        tamanho da janela no construtor da classe Scene.*/
        Scene scene = new Scene(painel, 300, 275);

        // atribuindo a Scena ao palco do JavaFx
        primaryStage.setScene(scene);
        // exibindo a interface gráfica
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
