

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Test extends Application {
    private Game game1 = new Game();
    private Highscore board = new Highscore();
    private int count = 100;
    private int countBandit1 = 5;
    private int countBandit2 = 5;
    private int countBandit3 = 5;
    private int countBandit4 = 5;
    private int countBandit5 = 5;
    private int countBandit6 = 5;
    
    @Override
     public void start(Stage primaryStage) {
        
        Group menu = new Group();
        Scene scene1 = new Scene(menu, 1000, 500);
        
        Group game = new Group();
        Scene scene2 = new Scene(game, 1000, 500);
        
        Group con = new Group();
        Scene scene3 = new Scene(con, 1000, 500);
        
        Group high = new Group();
        Scene scene4 = new Scene(high, 1000, 500);
        
        Group how = new Group();
        Scene scene5 = new Scene(how, 1000, 500);
         
        Text title= new Text();
        title.setText("Save the Princess!");
        title.setLayoutX(375);
        title.setLayoutY(100);
        title.setStyle("-fx-font: 30 arial;");
        
        double score = game1.getScore();
        Text scoreDisplay = new Text();
        scoreDisplay.setText("Your score: " + score);
        scoreDisplay.setLayoutX(800);
        scoreDisplay.setLayoutY(25);
        scoreDisplay.setStyle("-fx-font: 20 arial;");
        
        Text highscoreDisplay = new Text();
        highscoreDisplay.setText("HIGHSCORE");
        highscoreDisplay.setStyle("-fx-font: 25 arial;");
        highscoreDisplay.setLayoutX(450);
        highscoreDisplay.setLayoutY(50);
        TextArea ta = new TextArea();
        ta.setLayoutX(300);
        ta.setLayoutY(100);
        
        Text howToDisplay = new Text();
        howToDisplay.setText("How To Play");
        howToDisplay.setStyle("-fx-font: 25 arial;");
        howToDisplay.setLayoutX(450);
        howToDisplay.setLayoutY(50);
        Text howToText = new Text();
        howToText.setText("You have to save the princess by shoot the bandit and don't shoot the princess."
                + "\n If you shoot the princess you will get minus 100 points."
                + "\n If you shoot the bandit you will get plus 10 points multiply by time that you manage to shoot before the Bandit disappear."
                + "\n You can shoot them by clicking on them.");
        howToText.setLayoutX(100);
        howToText.setLayoutY(150);
        Text banditText = new Text();
        banditText.setText("<- Bandit");
        banditText.setLayoutX(250);
        banditText.setLayoutY(350);
        Image banditImageHow = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageViewHow = new ImageView(banditImageHow);
        banditImageViewHow.setFitHeight(100);
        banditImageViewHow.setFitWidth(100);
        banditImageViewHow.setLayoutX(100);
        banditImageViewHow.setLayoutY(300);
        Text princessText = new Text();
        princessText.setText("<- Princess");
        princessText.setLayoutX(500);
        princessText.setLayoutY(350);
        Image princessImageHow = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageViewHow = new ImageView(princessImageHow);
        princessImageViewHow.setFitHeight(100);
        princessImageViewHow.setFitWidth(100);
        princessImageViewHow.setLayoutX(350);
        princessImageViewHow.setLayoutY(300);

        
        Button back = new Button("Back");
        back.setLayoutX(500);
        back.setLayoutY(400);
        back.setOnAction(e -> {primaryStage.setScene(scene1);});
        
        Button backHowTo = new Button("Back");
        backHowTo.setLayoutX(500);
        backHowTo.setLayoutY(400);
        backHowTo.setOnAction(e -> {primaryStage.setScene(scene1);});
        
        Text timerDisplay = new Text();
        timerDisplay.setLayoutX(600);
        timerDisplay.setLayoutY(25);
        timerDisplay.setStyle("-fx-font: 20 arial;");
        Text conDisplay = new Text();
        conDisplay.setLayoutX(400);
        conDisplay.setLayoutY(100);
        conDisplay.setStyle("-fx-font: 20 arial;");
        Text con2Display = new Text();
        con2Display.setText("Please submit your name to see if you can make it on the Highscore board!");
        con2Display.setLayoutX(200);
        con2Display.setLayoutY(200);
        con2Display.setStyle("-fx-font: 20 arial;");
        Label nameLabel = new Label("Name: ");
        TextField nameTextField = new TextField ();
        nameLabel.setLayoutX(400);
        nameLabel.setLayoutY(300);
        nameTextField.setLayoutX(500);
        nameTextField.setLayoutY(300);
        Label IDLabel = new Label("ID: ");
        TextField IDTextField = new TextField ();
        IDLabel.setLayoutX(400);
        IDLabel.setLayoutY(275);
        IDTextField.setLayoutX(500);
        IDTextField.setLayoutY(275);
        
        Button submit = new Button("Submit");
        submit.setLayoutX(500);
        submit.setLayoutY(400);
        submit.setOnAction(e -> {primaryStage.setScene(scene1); board.add(IDTextField.getText(),nameTextField.getText(), 
                game1.getScore());game1.setScore(0);});
        
        Image desertImage = new Image(getClass().getResource("Picture/desert.png").toString());
        ImageView desertImageView = new ImageView(desertImage);
        desertImageView.setFitHeight(500);
        desertImageView.setFitWidth(1000);
        
        
        Image banditImage1 = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageView1 = new ImageView(banditImage1);
        banditImageView1.setFitHeight(100);
        banditImageView1.setFitWidth(100);
        banditImageView1.setLayoutX(450);
        banditImageView1.setLayoutY(90);
        banditImageView1.setVisible(false);
        
        
        Image banditImage2 = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageView2 = new ImageView(banditImage2);
        banditImageView2.setFitHeight(100);
        banditImageView2.setFitWidth(100);
        banditImageView2.setLayoutX(200);
        banditImageView2.setLayoutY(200);
        banditImageView2.setVisible(false);
        
        
        Image banditImage3 = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageView3 = new ImageView(banditImage3);
        banditImageView3.setFitHeight(100);
        banditImageView3.setFitWidth(100);
        banditImageView3.setLayoutX(300);
        banditImageView3.setLayoutY(400);
        banditImageView3.setVisible(false);
        
        Image banditImage4 = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageView4 = new ImageView(banditImage4);
        banditImageView4.setFitHeight(100);
        banditImageView4.setFitWidth(100);
        banditImageView4.setLayoutX(900);
        banditImageView4.setLayoutY(350);
        banditImageView4.setVisible(false);
        
        
        Image banditImage5 = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageView5 = new ImageView(banditImage5);
        banditImageView5.setFitHeight(100);
        banditImageView5.setFitWidth(100);
        banditImageView5.setLayoutX(500);
        banditImageView5.setLayoutY(350);
        banditImageView5.setVisible(false);
        
        Image banditImage6 = new Image(getClass().getResource("Picture/bandit.png").toString());
        ImageView banditImageView6 = new ImageView(banditImage6);
        banditImageView6.setFitHeight(100);
        banditImageView6.setFitWidth(100);
        banditImageView6.setLayoutX(790);
        banditImageView6.setLayoutY(130);
        banditImageView6.setVisible(false);
        
        Image princessImage1 = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageView1 = new ImageView(princessImage1);
        princessImageView1.setFitHeight(100);
        princessImageView1.setFitWidth(100);
        princessImageView1.setLayoutX(450);
        princessImageView1.setLayoutY(90);
        princessImageView1.setVisible(false);
        
        Image princessImage2 = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageView2 = new ImageView(princessImage2);
        princessImageView2.setFitHeight(100);
        princessImageView2.setFitWidth(100);
        princessImageView2.setLayoutX(200);
        princessImageView2.setLayoutY(200);
        princessImageView2.setVisible(false);
        
        Image princessImage3 = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageView3 = new ImageView(princessImage3);
        princessImageView3.setFitHeight(100);
        princessImageView3.setFitWidth(100);
        princessImageView3.setLayoutX(300);
        princessImageView3.setLayoutY(400);
        princessImageView3.setVisible(false);
        
        Image princessImage4 = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageView4 = new ImageView(princessImage4);
        princessImageView4.setFitHeight(100);
        princessImageView4.setFitWidth(100);
        princessImageView4.setLayoutX(900);
        princessImageView4.setLayoutY(350);
        princessImageView4.setVisible(false);
        
        Image princessImage5 = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageView5 = new ImageView(princessImage5);
        princessImageView5.setFitHeight(100);
        princessImageView5.setFitWidth(100);
        princessImageView5.setLayoutX(500);
        princessImageView5.setLayoutY(350);
        princessImageView5.setVisible(false);

        
        Image princessImage6 = new Image(getClass().getResource("Picture/princess.png").toString());
        ImageView princessImageView6 = new ImageView(princessImage6);
        princessImageView6.setFitHeight(100);
        princessImageView6.setFitWidth(100);
        princessImageView6.setLayoutX(790);
        princessImageView6.setLayoutY(130);
       princessImageView6.setVisible(false);
        
        Button play = new Button("Start Game");
        play.setLayoutX(450);
        play.setLayoutY(200);
        play.setOnAction(e -> {
            primaryStage.setScene(scene2);   
            timerDisplay.setText("Timer: " + count);
            Timer timer = new Timer();
            TimerTask task1 = new TimerTask(){
                @Override
                public void run(){
                    count = count - 1;
                    timerDisplay.setText("Timer: " + count);
                }
            };
            TimerTask task3 = new TimerTask(){
                @Override
                public void run(){
                    game1.random1();
                    int rand = game1.getPic1();
                    countBandit1 = 5;
                    switch(rand){
                        case 1: banditImageView1.setVisible(true);
                                princessImageView1.setVisible(false);
                                Timer timerBandit1 = new Timer();
                                TimerTask taskBandit1 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        banditImageView1.setVisible(false);
                                        countBandit1 = 5;
                                    }
                                }; 
                                TimerTask taskBandit11 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        if(countBandit1>1){
                                        countBandit1 = countBandit1 - 1;
                                        }
                                    }
                                }; 
                                timerBandit1.schedule(taskBandit1, 4000l);
                                timerBandit1.scheduleAtFixedRate(taskBandit11, 1000l, 1000l);
                                banditImageView1.setOnMouseClicked((MouseEvent me) -> 
                                {actionBandit(banditImageView1, scoreDisplay, countBandit1);countBandit1 = 5;});
                                break;
                        case 2: banditImageView1.setVisible(false);
                                countBandit1 = 5;
                                princessImageView1.setVisible(true);
                                timePrincess(princessImageView1);
                                princessImageView1.setOnMouseClicked((MouseEvent me) -> 
                                {actionPrincess(princessImageView1,scoreDisplay);});
                                break;
                        case 3: banditImageView1.setVisible(false); 
                                countBandit1 = 5;
                                princessImageView1.setVisible(false);
                                break;
                    }
                    countBandit1 = 5;
                }
            };
            TimerTask task4 = new TimerTask(){
                @Override
                public void run(){
                    game1.random2();
                    int rand = game1.getPic2();
                    countBandit2 = 5;
                    switch(rand){
                        case 1: banditImageView2.setVisible(true);
                                princessImageView2.setVisible(false);
                                Timer timerBandit2 = new Timer();
                                TimerTask taskBandit2 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        banditImageView2.setVisible(false);
                                        countBandit1 = 5;
                                    }
                                }; 
                                TimerTask taskBandit22 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        if(countBandit2>1){
                                        countBandit2 = countBandit2 - 1;
                                        }
                                    }
                                }; 
                                timerBandit2.schedule(taskBandit2, 4000l);
                                timerBandit2.scheduleAtFixedRate(taskBandit22, 1000l, 1000l);
                                banditImageView2.setOnMouseClicked((MouseEvent me) -> 
                                {actionBandit(banditImageView2, scoreDisplay, countBandit2);countBandit2 = 5;});
                                break;
                        case 2: banditImageView2.setVisible(false);
                                countBandit2 = 5;
                                princessImageView2.setVisible(true);
                                timePrincess(princessImageView2);
                                princessImageView2.setOnMouseClicked((MouseEvent me) -> 
                                {actionPrincess(princessImageView2,scoreDisplay);});
                                break;
                        case 3: banditImageView2.setVisible(false); 
                                countBandit2 = 5;
                                princessImageView2.setVisible(false);
                                break;
                    }
                    countBandit2 = 5;
                }
            };
            TimerTask task5 = new TimerTask(){
                @Override
                public void run(){
                    game1.random3();
                    int rand = game1.getPic3();
                    countBandit3 = 5;
                    switch(rand){
                        case 1: banditImageView3.setVisible(true);
                                princessImageView3.setVisible(false);
                                Timer timerBandit3 = new Timer();
                                TimerTask taskBandit3 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        banditImageView3.setVisible(false);
                                        countBandit3 = 5;
                                    }
                                }; 
                                TimerTask taskBandit33 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        if(countBandit3>1){
                                        countBandit3 = countBandit3 - 1;
                                        }
                                    }
                                }; 
                                timerBandit3.schedule(taskBandit3, 4000l);
                                timerBandit3.scheduleAtFixedRate(taskBandit33, 1000l, 1000l);
                                banditImageView3.setOnMouseClicked((MouseEvent me) -> 
                                {actionBandit(banditImageView3, scoreDisplay, countBandit3);countBandit3 = 5;});
                                break;
                        case 2: banditImageView3.setVisible(false);
                                countBandit3 = 5;
                                princessImageView3.setVisible(true);
                                timePrincess(princessImageView3);
                                princessImageView3.setOnMouseClicked((MouseEvent me) -> 
                                {actionPrincess(princessImageView3,scoreDisplay);});
                                break;
                        case 3: banditImageView3.setVisible(false); 
                                countBandit3 = 5;
                                princessImageView3.setVisible(false);
                                break;
                    }
                    countBandit3 = 5;
                }
            };
            TimerTask task6 = new TimerTask(){
                @Override
                public void run(){
                    game1.random4();
                    int rand = game1.getPic4();
                    countBandit4 = 5;
                    switch(rand){
                        case 1: banditImageView4.setVisible(true);
                                princessImageView4.setVisible(false);
                                Timer timerBandit4 = new Timer();
                                TimerTask taskBandit4 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        banditImageView4.setVisible(false);
                                        countBandit4 = 5;
                                    }
                                }; 
                                TimerTask taskBandit44 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        if(countBandit4>1){
                                        countBandit4 = countBandit4 - 1;
                                        }
                                    }
                                }; 
                                timerBandit4.schedule(taskBandit4, 4000l);
                                timerBandit4.scheduleAtFixedRate(taskBandit44, 1000l, 1000l);
                                banditImageView4.setOnMouseClicked((MouseEvent me) -> 
                                {actionBandit(banditImageView4, scoreDisplay, countBandit4);countBandit4 = 5;});
                                break;
                        case 2: banditImageView4.setVisible(false);
                                countBandit4 = 5;
                                princessImageView4.setVisible(true);
                                timePrincess(princessImageView4);
                                princessImageView4.setOnMouseClicked((MouseEvent me) -> 
                                {actionPrincess(princessImageView4,scoreDisplay);});
                                break;
                        case 3: banditImageView4.setVisible(false);
                                countBandit4 = 5;
                                princessImageView4.setVisible(false);
                                break;
                    }
                    countBandit4 = 5;
                }
            };
            TimerTask task7 = new TimerTask(){
                @Override
                public void run(){
                    game1.random5();
                    int rand = game1.getPic5();
                    countBandit5 = 5;
                    switch(rand){
                        case 1: banditImageView5.setVisible(true);
                                princessImageView5.setVisible(false);
                                Timer timerBandit5 = new Timer();
                                TimerTask taskBandit5 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        banditImageView5.setVisible(false);
                                        countBandit5 = 5;
                                    }
                                }; 
                                TimerTask taskBandit55 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        if(countBandit5>1){
                                        countBandit5 = countBandit5 - 1;
                                        }
                                    }
                                }; 
                                timerBandit5.schedule(taskBandit5, 4000l);
                                timerBandit5.scheduleAtFixedRate(taskBandit55, 1000l, 1000l);
                                banditImageView5.setOnMouseClicked((MouseEvent me) -> 
                                {actionBandit(banditImageView5, scoreDisplay, countBandit5);countBandit5 = 5;});
                                break;
                        case 2: banditImageView5.setVisible(false);
                                countBandit5 = 5;
                                princessImageView5.setVisible(true);
                                timePrincess(princessImageView5);
                                princessImageView5.setOnMouseClicked((MouseEvent me) -> 
                                {actionPrincess(princessImageView5,scoreDisplay);});
                                break;
                        case 3: banditImageView5.setVisible(false); 
                                countBandit5 = 5;
                                princessImageView5.setVisible(false);
                                break;
                    }
                    countBandit5 = 5;
                }
            };
            TimerTask task8 = new TimerTask(){
                @Override
                public void run(){
                    game1.random6();
                    int rand = game1.getPic6();
                    countBandit6 = 5;
                    switch(rand){
                        case 1: banditImageView6.setVisible(true);
                                princessImageView6.setVisible(false);
                                Timer timerBandit6 = new Timer();
                                TimerTask taskBandit6 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        banditImageView6.setVisible(false);
                                        countBandit6 = 5;
                                    }
                                }; 
                                TimerTask taskBandit66 = new TimerTask(){
                                    @Override
                                    public void run(){
                                        if(countBandit6>1){
                                        countBandit6 = countBandit6 - 1;
                                        }
                                    }
                                }; 
                                timerBandit6.schedule(taskBandit6, 4000l);
                                timerBandit6.scheduleAtFixedRate(taskBandit66, 1000l, 1000l);
                                banditImageView6.setOnMouseClicked((MouseEvent me) -> 
                                {actionBandit(banditImageView6, scoreDisplay, countBandit6);countBandit6 = 5;});
                                break;
                        case 2: banditImageView6.setVisible(false);
                                countBandit6 = 5;
                                princessImageView6.setVisible(true);
                                timePrincess(princessImageView6);
                                princessImageView6.setOnMouseClicked((MouseEvent me) -> 
                                {actionPrincess(princessImageView6,scoreDisplay);});
                                break;
                        case 3: banditImageView6.setVisible(false); 
                                countBandit6 = 5;
                                princessImageView6.setVisible(false);
                                break;
                    }
                    countBandit6 = 5;
                }
            };
            timer.scheduleAtFixedRate(task1, 1000l, 1000l);
            timer.scheduleAtFixedRate(task3, 5000l, 5000l);
            timer.scheduleAtFixedRate(task4, 5000l, 5000l);
            timer.scheduleAtFixedRate(task5, 5000l, 5000l);
            timer.scheduleAtFixedRate(task6, 5000l, 5000l);
            timer.scheduleAtFixedRate(task7, 5000l, 5000l);
            timer.scheduleAtFixedRate(task8, 5000l, 5000l);
            new Timeline(new KeyFrame(Duration.millis(100000l),ae -> {primaryStage.setScene(scene3);timer.cancel();
            count = 100; countBandit1 = 5;countBandit2 = 5;countBandit3 = 5;countBandit4 = 5;countBandit5 = 5;
            countBandit6 = 5;task1.cancel();task3.cancel();task4.cancel();task5.cancel();
            task6.cancel();task7.cancel();task8.cancel();
            double score1 = game1.getScore();
            conDisplay.setText("Congratulation You got " + score1 + " point.");})).play();
            
        });
        
            
        Button howTo = new Button("How to play");
        howTo.setLayoutX(450);
        howTo.setLayoutY(250);
        howTo.setOnAction(e -> {
            primaryStage.setScene(scene5); 
        });
        
        
        Button highscore = new Button("High score");
        highscore.setLayoutX(450);
        highscore.setLayoutY(300);
         highscore.setOnAction(e -> {
            primaryStage.setScene(scene4); 
            ta.clear();
            board.ini();
            ArrayList list = board.getScore();
            Iterator itr = list.iterator();   
            int i =1;
            int j =1;
            while(itr.hasNext()){      
                i = i+1;
                if (i%2 == 0){
                    ta.appendText("\n" + j + ". " + itr.next());
                    j = j+1;
                }
                else
                    ta.appendText("         " + itr.next());
            }
        });
        
        
        
        
        
        
        
        
        
        menu.getChildren().addAll(play, howTo, highscore,title);
        game.getChildren().addAll(desertImageView, banditImageView1, banditImageView2, banditImageView3
                , banditImageView4, banditImageView5, banditImageView6
                , princessImageView1, princessImageView2, princessImageView3
                , princessImageView4, princessImageView5, princessImageView6
                , scoreDisplay, timerDisplay);
        con.getChildren().addAll(conDisplay,con2Display,IDLabel ,IDTextField, nameLabel, nameTextField, submit);
        high.getChildren().addAll(ta,highscoreDisplay,back);
        how.getChildren().addAll(howToDisplay,howToText,backHowTo,banditImageViewHow,princessImageViewHow,princessText,banditText);
        
        
        
        primaryStage.setTitle("Save the Princess!");
        primaryStage.setScene(scene1);
        primaryStage.show();
        
		
    }

     public void actionBandit(ImageView banditImageView , Text scoreDisplay, int countBandit){
            
            game1.bandit(countBandit);
            double score1 = game1.getScore();
            scoreDisplay.setText("Your score: " + score1);
            banditImageView.setVisible(false);
            
   
     }
     
     public void timePrincess(ImageView princessImageView){
        Timer timerPrincess = new Timer();
        TimerTask taskPrincess = new TimerTask(){
            @Override
            public void run(){
                princessImageView.setVisible(false);
            }
        }; 
        timerPrincess.schedule(taskPrincess, 4000l);
     }
     
     public void actionPrincess(ImageView princessImageView , Text scoreDisplay){

            game1.princess();
            double score1 = game1.getScore();
            scoreDisplay.setText("Your score: " + score1);
            princessImageView.setVisible(false);

     }
     
    public static void main(String[] args) {
        launch(args);
    }
}
