package exercici1;

import java.sql.*;
import java.util.Scanner;

public class exercici1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("""
                Que vols fer?
                1) Inserir cotxe nou
                2) Seleccionar un cotxe
                3) Actualitzar un cotxe""");
        System.out.print("--> Opcio: ");
        int opcio = scanner.nextInt();
        scanner.nextLine();
        try {
            if (opcio == 1) {
                System.out.println("Quina matrícula?");
                String matricula = scanner.nextLine();
                System.out.println("Data de matriculació? (Format: AAAA/MM/DD)");
                String data = scanner.nextLine();
                insert(matricula, data);
            }
            if (opcio == 2) {
                select();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection connexio() {
        String DB_USERNAME = "xavi";
        String DB_PASSWORD = "1234";
        String DB_HOST = "localhost:3306";
        String DB_DBNAME = "exercicisPrimeraPart";
        Connection con;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://" + DB_HOST + "/" + DB_DBNAME,
                    DB_USERNAME, DB_PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void insert(String matricula, String data) throws SQLException {
        Connection con = connexio();
        String sql = "INSERT INTO cotxe (matricula, any_matriculacio) VALUES ('"
                + matricula + "','" + data + "');";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        ps.close();
        con.close();
    }

    public static void select() throws SQLException {
        Connection con = connexio();
        for (int i = 0; i < 5; i++) {
            String sql = "SELECT * FROM cotxe;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
        }
        con.close();
    }

    public static void update(String atribut) throws SQLException {
        Connection con = connexio();
        String canvi;
        canvi = scanner.nextLine();
        String sql = "UPDATE cotxe SET" + atribut + "=" + canvi + "WHERE" + atribut + "=" + canviat + ";";
        ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.execute();
        ps.close();
        con.close();
    }

}
