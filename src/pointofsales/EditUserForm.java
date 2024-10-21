package pointofsales;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditUserForm extends JFrame {
    private JTextField txtNama, txtUsername, txtPassword;
    private JComboBox<String> cmbLevel;
    private JButton btnSimpan, btnBatal;
    private tampilandatauser parentFrame;
    private String userId;

    public EditUserForm(tampilandatauser parent, String id, String nama, String username, String password, String level) {
        this.parentFrame = parent;
        this.userId = id;
        setTitle("Edit User");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nama:"));
        txtNama = new JTextField(nama);
        add(txtNama);

        add(new JLabel("Username:"));
        txtUsername = new JTextField(username);
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JTextField(password);
        add(txtPassword);

        add(new JLabel("Level:"));
        cmbLevel = new JComboBox<>(new String[]{"admin", "kasir", "owner"});
        cmbLevel.setSelectedItem(level);
        add(cmbLevel);

        btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(e -> updateUser());
        add(btnSimpan);

        btnBatal = new JButton("Batal");
        btnBatal.addActionListener(e -> dispose());
        add(btnBatal);
    }

    private void updateUser() {
        String nama = txtNama.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String level = (String) cmbLevel.getSelectedItem();

        if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        try (Connection conn = config.configDB()) {
            String sql = "UPDATE akun SET nama = ?, username = ?, password = ?, level = ? WHERE id_akun = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, nama);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, level);
                pst.setString(5, userId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Data user berhasil diupdate.");
                    parentFrame.viewDataUser(); // Refresh tabel di tampilan utama
                    dispose();
                } else {
                    JOptionPane.showConfirmDialog(this, "Gagal mengupdate data user.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}