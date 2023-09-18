import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RadioButton extends JFrame {
    static int width = 800;
    static int height = 600;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JRadioButton r4;
    private JLabel label;
    private ButtonGroup bg;
    public RadioButton()
    {
        super("RadioButton");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(RadioButton.width, RadioButton.height);
        this.setLocation(d.width / 2 - RadioButton.width / 2, d.height / 2 - RadioButton.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel panelUp = new JPanel(new GridBagLayout());
        this.add(panelUp, BorderLayout.CENTER);

        JPanel panelDown = new JPanel(new GridLayout());
        panelDown.setPreferredSize(new Dimension(0, 100));
        panelDown.setBackground(Color.white);
        this.add(panelDown, BorderLayout.SOUTH);

        r1 = new JRadioButton("Весна");
        r2 = new JRadioButton("Лето");
        r3 = new JRadioButton("Осень");
        r4 = new JRadioButton("Зима");

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        JButton button = new JButton("Ответить");

        label = new JLabel("Ответ: ");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridy = 0;
        panelUp.add(r1, constraints);
        constraints.gridy = 1;
        panelUp.add(r2, constraints);
        constraints.gridy = 2;
        panelUp.add(r3, constraints);
        constraints.gridy = 3;
        panelUp.add(r4, constraints);
        constraints.gridy = 4;
        panelUp.add(button, constraints);

        panelDown.add(label);

        this.setVisible(true);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bg.getSelection() != null) {
                    if (r1.isSelected()) {
                        label.setText("Ответ: " + r1.getText());
                    } else if (r2.isSelected()) {
                        label.setText("Ответ: " + r2.getText());
                    } else if (r3.isSelected()) {
                        label.setText("Ответ: " + r3.getText());
                    } else {
                        label.setText("Ответ: " + r4.getText());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RadioButton frame = new RadioButton();
            }
        });
    }
}
