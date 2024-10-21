package pointofsales;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class TambahUserForm extends JFrame {

    private final JTextField txtNama;
    private JTextField txtUsername, txtPassword;
    private JComboBox<String> cmbLevel;
    private final JButton btnSimpan;
    private JButton btnBatal;
    private tampilandatauser parentFrame;

    public TambahUserForm(tampilandatauser parent) {
        this.parentFrame = parent;
        setTitle("Tambah User Baru");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nama:"));
        txtNama = new JTextField();
        add(txtNama);

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JTextField();
        add(txtPassword);

        add(new JLabel("Level:"));
        cmbLevel = new JComboBox<>(new String[]{"admin", "kasir", "owner"});
        add(cmbLevel);

        btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(e -> simpanUser());
        add(btnSimpan);

        btnBatal = new JButton("Batal");
        btnBatal.addActionListener(e -> dispose());
        add(btnBatal);
    }

    private void simpanUser() {
        String nama = txtNama.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String level = (String) cmbLevel.getSelectedItem();

        if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        try (Connection conn = config.configDB()) {
            String sql = "INSERT INTO akun (nama, username, password, level) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, nama);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, level);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "User baru berhasil ditambahkan.");
                    parentFrame.viewDataUser(); // Refresh tabel di tampilan utama
                    dispose(); // Tutup form tambah user
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menambahkan user baru.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}