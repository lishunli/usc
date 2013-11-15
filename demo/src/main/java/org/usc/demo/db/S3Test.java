package org.usc.demo.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Shunli
 */
public class S3Test {
    public static void main(String[] args) {
        DriverManagerDataSource local = new DriverManagerDataSource();
        local.setUrl("jdbc:mysql://10.11.9.27:3306/xlgame_xiumo");
        local.setDriverClassName("com.mysql.jdbc.Driver");
        local.setUsername("root");
        local.setPassword("sd-9898w");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(local);

        final List<Vote> votes = new ArrayList<Vote>();
        votes.add(new Vote("b1", 1));
        votes.add(new Vote("b2", 1));
        votes.add(new Vote("b3", 1));
        votes.add(new Vote("b4", 1));

        BatchPreparedStatementSetter pss = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Vote vote = votes.get(i);

                ps.setString(1, vote.getBelleId());
                ps.setInt(2, vote.getNum());
            }

            @Override
            public int getBatchSize() {
                return votes.size();
            }
        };
        jdbcTemplate.batchUpdate("insert into vote(belleid, num) values (?,?)", pss);

    }

}
