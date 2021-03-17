package br.com.torrentzfilmes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author roger
 */
public class Conexao {

    private static Connection conexao = null;

    private Conexao() {
    }

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://192.168.0.13:5432/torrentz_n2";
                String usuario = "postgres";
                String password = "1357";

                Class.forName(driver);
                conexao = DriverManager.getConnection(url, usuario, password);
//                JOptionPane.showMessageDialog(null, "Conectado com Sucesso !");

            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();

            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
        return conexao;
    }
}
