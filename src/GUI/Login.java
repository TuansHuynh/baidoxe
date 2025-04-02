package GUI;

import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;

public class Login {
    private JFrame frame;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public Login() {
        frame = new JFrame("Đăng nhập");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        userField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Đăng nhập");

        panel.add(new JLabel("Tên đăng nhập:"));
        panel.add(userField);
        panel.add(new JLabel("Mật khẩu:"));
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                if (authenticate(username, password)) {
                    frame.dispose();
                    new MainFrame(); // Mở giao diện chính
                } else {
                    JOptionPane.showMessageDialog(frame, "Sai thông tin đăng nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
