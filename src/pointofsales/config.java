package pointofsales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class config {
    public static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            // URL yang mengarah ke database 'irsyad'
            String url = "jdbc:mysql://localhost:3306/irsyad";
            String user = "root";
            String pass = ""; // Jika ada password, tambahkan di sini

            // Coba register driver MySQL jika perlu (biasanya otomatis jika JDBC di path)
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // Mencoba membuat koneksi ke database
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil!");

        } catch (SQLException e) {
            // Menampilkan pesan kesalahan yang lebih lengkap
            System.err.println("Koneksi gagal: " + e.getMessage());
            // Melempar kembali SQLException
            throw e;
        }

        return mysqlconfig;
    }

    public static void main(String[] args) {
        try {
            // Memanggil method configDB untuk koneksi ke database
            configDB();
        } catch (SQLException e) {
            // Menangani error koneksi
            System.err.println("Error di main: " + e.getMessage());
        }
    }
}



