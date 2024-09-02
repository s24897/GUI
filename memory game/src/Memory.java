import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Memory extends  JFrame implements ActionListener {


    JButton start;
    JButton highscore;
    JButton exit;
    JButton startGame;

    JPanel startPanel;
    JPanel highscorePanel;
    JPanel gamePanel;
    JPanel timerPanel;

    JLabel selectNumber;
    JLabel timerLabel;

    JSpinner numberOfCards;

    JTextField name;


    public Memory() {

        SpinnerModel value = new SpinnerNumberModel(2, 2, 6, 2);
        numberOfCards = new JSpinner(value);
        numberOfCards.setBounds(370, 250, 50, 30);


        start = new JButton("Start Game");
        start.addActionListener(this);


        highscore = new JButton("Highscore");
        highscore.addActionListener(this);


        exit = new JButton("Exit");
        exit.addActionListener(this);

        startGame = new JButton("Start");
        startGame.addActionListener(this);
        startGame.setBounds(344, 300, 100, 30);

        JLabel welcome = new JLabel("Welcome to the Memory Game!");
        welcome.setVerticalAlignment(JLabel.NORTH);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        welcome.setFont(new Font("Verdana", Font.PLAIN, 20));

        selectNumber = new JLabel("Wybierz wymiar planszy");
        selectNumber.setBounds(290, 180, 400, 100);
        selectNumber.setFont(new Font("Verdana", Font.PLAIN, 18));

        startPanel = new JPanel();
        startPanel.setLayout(new GridLayout(4, 1, 10, 10));
        startPanel.setBounds(190, 120, 400, 300);
        startPanel.add(welcome);
        startPanel.add(start);
        startPanel.add(highscore);
        startPanel.add(exit);

        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 800, 400);
        timerPanel = new JPanel();
        timerPanel.setBounds(0, 400, 800, 200);
        timerPanel.setLayout(new GridLayout(1, 1, 10, 10));

        timerLabel = new JLabel();
        timerLabel.setVerticalAlignment(JLabel.CENTER);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setFont(new Font("Verdana", Font.PLAIN, 32));
        timerPanel.add(timerLabel);

        name = new JTextField("Nazwa gracza");
        name.setBounds(250, 350, 300, 30);


        highscorePanel = new JPanel();
        highscorePanel.setLayout(new BoxLayout(highscorePanel, BoxLayout.PAGE_AXIS));
        highscorePanel.setBounds(140, 10, 500, 530);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800, 600);
        this.setTitle("Memory");
        this.setVisible(true);
        this.add(startPanel);

    }

    public static void main(String[] args) {
        new Memory();
    }


    boolean ifGame = true;
    @Override
    public void actionPerformed(ActionEvent e) {
        //start
        if (e.getSource() == start) {
            this.remove(startPanel);
            this.repaint();
            this.add(selectNumber);
            this.add(numberOfCards);
            this.add(startGame);
            this.add(name);
        }
        //highscore
        if (e.getSource() == highscore) {
            this.remove(startPanel);
            this.repaint();
            File file = new File(".\\Highscore.txt");
            try {
                Scanner scan = new Scanner(file);

                while (scan.hasNextLine()) {

                    highscorePanel.add(new JLabel(scan.nextLine())).setFont(new Font("Verdana", Font.PLAIN, 12));
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            this.add(highscorePanel);
        }
        //exit
        if (e.getSource() == exit) {
            System.exit(0);
        }
        //start game
        if (e.getSource() == startGame) {
            this.remove(selectNumber);
            this.remove(numberOfCards);
            this.remove(startGame);
            this.remove(name);
            this.repaint();
            this.add(gamePanel);
            this.add(timerPanel);

            Thread timerThread = new Thread(() -> {
                int seconds = 0;
                String seconds_string;
                while (ifGame) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    seconds_string = String.format("%03d", seconds);
                    timerLabel.setText(seconds_string);
                    seconds += 1;
                }
            });
            timerThread.start();

            int cards = (int) numberOfCards.getValue();
            final int[] allCards = {cards * cards};
            final boolean[] isSecond = {false};
            final Card[] first = {null};
            final String[] firstRealValue ={null};
            int[] names1 = new int[allCards[0] / 2];
            int[] names2 = new int[allCards[0] / 2];
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < (allCards[0] / 2); i++) {
                names1[i] = i + 1;
                names2[i] = i + 1;
            }
            //Tworzenie kart
            for (int i = 0; i < allCards[0]; i++) {
                Card card;
                if ((int) (Math.random() + 1.5) == 1) {
                    if (index1 >= (allCards[0] / 2)) {
                        card = new Card(String.valueOf(names2[index2]),firstRealValue, isSecond, first,allCards, timerLabel.getText(), name.getText(), String.valueOf(numberOfCards.getValue()));
                        index2 += 1;
                    } else {
                        card = new Card(String.valueOf(names1[index1]),firstRealValue, isSecond, first,allCards, timerLabel.getText(), name.getText(), String.valueOf(numberOfCards.getValue()));
                        index1 += 1;
                    }
                } else {
                    if (index2 >= (allCards[0] / 2)) {
                        card = new Card(String.valueOf(names1[index1]),firstRealValue, isSecond, first,allCards, timerLabel.getText(), name.getText(), String.valueOf(numberOfCards.getValue()));
                        index1 += 1;
                    } else {
                        card = new Card(String.valueOf(names2[index2]),firstRealValue, isSecond, first,allCards, timerLabel.getText(), name.getText(), String.valueOf(numberOfCards.getValue()));
                        index2 += 1;
                    }
                }
                gamePanel.add(card);
            }
            gamePanel.setLayout(new GridLayout(cards, cards, 10, 10));
                }
            }
        }


