package guru.springframework.msscbrewery.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;


public class JdbcDao {

    public JdbcTemplate getJdbcTemplate;
    public NamedParameterJdbcTemplate getJdbcTemplateNameParams;

    @Autowired
    private void setDataSource(final DataSource dataSource) {
        getJdbcTemplate = new JdbcTemplate(dataSource);
        getJdbcTemplateNameParams = new NamedParameterJdbcTemplate(dataSource);

    }




}