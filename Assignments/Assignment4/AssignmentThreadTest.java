import com.ThreadAssignment.AssignmentThread;
import com.ThreadAssignment.SybaseDBConnection;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.After;



import static org.junit.Assert.*;

public class AssignmentThreadTest {

    Connection connection;

    @Before
    public void before() {
        connection = SybaseDBConnection.getConnection();

    }

    @After
    public void after() {
        SybaseDBConnection.closeConnection();
    }

    @Test
    public void closeStatementShouldCloseStatement() {
        connection = SybaseDBConnection.getConnection();
        SybaseDBConnection.closeConnection();

        try {
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
