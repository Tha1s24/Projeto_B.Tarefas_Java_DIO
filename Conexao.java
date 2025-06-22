import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Conexao.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo application.properties não encontrado");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.username"),
                props.getProperty("db.password")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
