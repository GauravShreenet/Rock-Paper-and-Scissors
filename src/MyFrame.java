import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener{

    JButton rockButton, paperButton, scissorsButton;
    JTextField textField, textField1, textField2;
    String winner;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rock Paper Scissors");
        this.setSize(550,150);
        this.setResizable(false);

        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        JLabel topLabel = new JLabel("Player Choice");
        window.add(topLabel);

        rockButton = new JButton("Rock");
        window.add(rockButton);
        rockButton.addActionListener( this);

        paperButton = new JButton("Paper");
        window.add(paperButton);
        paperButton.addActionListener((ActionListener) this);

        scissorsButton = new JButton("Scissors");
        window.add(scissorsButton);
        scissorsButton.addActionListener((ActionListener) this);

        textField = new JTextField(15);
        window.add(textField);

        JLabel compLabel = new JLabel("Computer Choice");
        window.add(compLabel);
        textField1 = new JTextField(15);
        window.add(textField1);

        JLabel resultLabel = new JLabel("Result");
        window.add(resultLabel);
        textField2 = new JTextField(15);
        window.add(textField2);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        int playerMove;
        int compMove;

        Random rand = new Random();
        if (source == rockButton) {
            playerMove = 0;
            textField.setText("Player choice is Rock");
        } else if (source == paperButton) {
            playerMove = 1;
            textField.setText("Player choice is Paper");
        } else {
            playerMove = 2;
            textField.setText("Player choice is Scissors");
        }

        compMove = rand.nextInt(3);
        winner = findWinner(playerMove, compMove);
        textField2.setText("Winner is " + winner + "!");

        if (compMove == 0) {
            textField1.setText("Computer choose Rock");
        } else if (compMove == 1) {
            textField1.setText("Computer choose Paper");
        } else {
            textField1.setText("Computer choose Scissors");
        }
    }
    
    private String findWinner(int playerMove, int compMove){
        if (playerMove == compMove) {
            winner = "No One. Its a tie";
        } else if (playerMove == 0 && compMove == 1) {
            winner = "Computer";
        } else if (playerMove == 1 && compMove == 2) {
            winner = "Computer";
        } else if (playerMove == 2 && compMove == 0) {
            winner = "Computer";
        }else {
            winner = "Player";
        }

        return winner;
    }


}