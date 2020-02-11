package app.study.message.repository;


import app.study.message.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MessageRepository {
    private DataSource dataSource;

    public MessageRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public Message saveMessage(Message message) {
        try(Connection c = DataSourceUtils.getConnection(dataSource)) {
            String insertSql = "INSERT INTO messages ('id', 'text', 'created_date') values (null, ?, ?)";
            PreparedStatement ps = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getText());
            ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0) {
                ResultSet result = ps.getGeneratedKeys();
                if(result.next()) {
                    Long id = (long) result.getInt(1);

                    return new Message(id, message.getText(), message.getCreatedDate());
                } else {
                    log.error("Failed to retrieve id.");

                    return null;
                }
            } else {
                return  null;
            }
        } catch (SQLException ex) {
            log.error("Failed to save message", ex);
        }

        return null;
    }
}
