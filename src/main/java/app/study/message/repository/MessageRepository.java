package app.study.message.repository;


import app.study.message.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MessageRepository {

    private final static Log log = LogFactory.getLog(MessageRepository.class);
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Message saveMessage(Message message) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("text", message.getText());
        params.addValue("createdDate", message.getCreatedDate());

        String insertSQL = "insert into messages ('id', 'text', 'created_date') value(null, :text, :createdDate)";
        try {
            jdbcTemplate.update(insertSQL, params, holder);
        } catch (DataAccessException e) {
            log.error("Failed to save message", e);
            return null;
        }
        return new Message(holder.getKey().longValue(), message.getText(), message.getCreatedDate());
    }
}
