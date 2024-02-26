package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcercaDeDialog extends JDialog {

    public AcercaDeDialog(JFrame parent) {
        super(parent, "Acerca de", true);

        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setUndecorated(true);

        getRootPane().setBorder(new LineBorder(Color.GRAY));

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Practica 5 JAVA");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel versionLabel = new JLabel("Versión: 1.0");

        JLabel authorLabel = new JLabel("Autor: ");
        JLabel authorLine1 = new JLabel("Jesús Martínez Montalvo");

        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aceptarButton);

        contentPanel.add(titleLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(versionLabel);
        contentPanel.add(authorLabel);
        contentPanel.add(authorLine1);
        contentPanel.add(Box.createVerticalStrut(20));

        contentPanel.add(buttonPanel);

        add(contentPanel);

        pack();

        setVisible(true);
    }
}
