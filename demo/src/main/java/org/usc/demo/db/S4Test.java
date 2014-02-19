package org.usc.demo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Shunli
 */
public class S4Test {
    public static void main(String[] args) throws Exception {
        DriverManagerDataSource local = new DriverManagerDataSource();
        local.setUrl("jdbc:mysql://10.11.9.27:3306/xlgame_xiumo");
        local.setDriverClassName("com.mysql.jdbc.Driver");
        local.setUsername("root");
        local.setPassword("sd-9898w");

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
        String sql = "insert into vote(belleid, num) values (?,?)";
        // jdbcTemplate.batchUpdate(sql, pss);

        batchUpdate(local, sql, votes, pss);
    }

    public static <T> int[] batchUpdate(DataSource dataSource, String sql, List<T> objs, final BatchPreparedStatementSetter pss) throws Exception {
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        for (int i = 0; i < objs.size(); i++) {
            pss.setValues(ps, i);

            ps.addBatch();
        }

        int[] executeBatch = ps.executeBatch();
        ps.close();
        connection.close();

        return executeBatch;
    }
}
