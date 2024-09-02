import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Card extends JButton {
    int count=0;
    int bonusPoints=0;
    boolean ifGame = true;
    String seconds_string;
    Thread timerThread = new Thread(() -> {
        int seconds = 0;
        while (ifGame) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            seconds_string = String.format("%03d", seconds);
            seconds += 1;
        }
    });



    Icon icon = new ImageIcon("img\\jajmen.png");
    String realValue;

    public String getRealValue() {
        return realValue;
    }

    public Card(String realValue, String[] firstRealValue, boolean[] isSecond, Card[] first,int[] amountOFCards, String time, String playeName, String dim ){
        timerThread.start();
        setIcon(icon);
        setRolloverIcon(icon);
        Card thisCard=this;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIcon(null);
                setText(realValue);
                if(isSecond[0]){
                    if(realValue.equals(firstRealValue[0])){
                        setVisible(false);
                        first[0].setVisible(false);
                        if(count==0){
                            bonusPoints+=1;
                        }
                        else if(count>0){
                            count=0;
                        }
                        amountOFCards[0]-=2;
                        if(amountOFCards[0]==0){
                            try {
                                FileWriter writer = new FileWriter(".//Highscore.txt",true);

                                writer.write("Gracz " + playeName + " -- czas: " + seconds_string + "s" + " -- wymiar planszy: " + dim + " Dodatkowe punkty: " + bonusPoints + '\n');
                                writer.close();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            System.exit(0);
                        }
                    }
                    else{
                       setIcon(icon);
                       setText("");
                       first[0].setIcon(icon);
                       first[0].setText("");
                        count+=1;
                    }
                    isSecond[0]=false;
                }
                else{
                    isSecond[0]=true;
                    firstRealValue[0]=realValue;
                    first[0]=thisCard;
                }
            }
        });
    }
}
