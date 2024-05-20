import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Assignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("String Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Enter String:");
        inputLabel.setBounds(10, 20, 80, 25);
        panel.add(inputLabel);

        JTextField userInput = new JTextField(20);
        userInput.setBounds(100, 20, 165, 25);
        panel.add(userInput);

        JButton encodeButton = new JButton("Encode");
        encodeButton.setBounds(10, 80, 80, 25);
        panel.add(encodeButton);

        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = userInput.getText();
                Encoded encoder = new Encoded();
                if (encoder.checkStringValidity(input)) {
                    encoder = new Encoded(input);
                    String message = String.format("inString: %s\nlength: %d\nreversedString: %s\noutString: %s",
                            input, encoder.getStringLen(input), encoder.reversedString(input), encoder.getOutString());
                    JOptionPane.showMessageDialog(panel, message, "Encoded Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid input! Please use only uppercase letters, numbers, or whitespace.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
