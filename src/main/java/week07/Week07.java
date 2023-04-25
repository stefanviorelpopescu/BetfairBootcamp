package week07;

import java.sql.*;
import java.util.Objects;

public class Week07
{
    public static void main(String[] args)
    {
        loadJDBCDriver();
        runPreparedStatement();
        runNormalStatement();

    }

    private static void runPreparedStatement()
    {
        try(Connection connection = getConnection())
        {
            Objects.requireNonNull(connection);

            try (PreparedStatement ps = connection.prepareStatement("insert into public.authors (name, phone_no, city) values (?, ?, ?)"))
            {
                ps.setString(1, "Andrei");
                ps.setString(2, "0756342552");
                ps.setInt(3, 3);
                ps.executeUpdate();
            } catch (SQLException e)
            {
                System.err.println("Cannot insert author: " + e.getMessage());
            }
        } catch (SQLException e)
        {
            System.err.println("Cannot insert author: " + e.getMessage());
        }

    }

    private static void runNormalStatement()
    {
        try (Connection connection = getConnection();
             Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = st.executeQuery("select * from public.authors"))
        {

            String city = "%;";
            final String format = "%20s%20s%12s\n";
            boolean hasResults = rs.next(); // position on the first line (initially it’s at -1)
            if (hasResults)
            {
                System.out.format(format, "Name", "Phone", "City ID");
                do
                {
                    System.out.format(format, rs.getString("name"), rs.getString("phone_no"), rs.getInt("city"));
                } while (rs.next());
            }
            else
            {
                System.out.println("No results");
            }
        } catch (SQLException e)
        {
            System.err.println("Cannot execute query: " + e.getMessage());
        }
    }

    private static Connection getConnection()
    {
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be busy, good to set a higher timeout
        try {
            String url = "jdbc:" +
                    "postgresql" + // “mysql” / “db2” / “mssql” / “oracle” / ...
                    "://" +
                    "localhost" +
                    ":" +
                    "5433" +
                    "/" +
                    "postgres" +
                    "?user=" +
                    "postgres" +
                    "&password=" +
                    "admin";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return null;
    }

    private static void loadJDBCDriver()
    {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e){
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }
    }
}
