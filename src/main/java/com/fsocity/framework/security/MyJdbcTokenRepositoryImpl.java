package com.fsocity.framework.security;

import org.springframework.core.log.LogMessage;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author zail
 * @date 2022/1/30
 */
public class MyJdbcTokenRepositoryImpl extends JdbcDaoSupport implements PersistentTokenRepository {
    
    /* 表前缀 */
    private String tablePrefix;
    
    private String createTableSql;
    
    private String tokensBySeriesSql;
    
    private String insertTokenSql;
    
    private String updateTokenSql;
    
    private String removeUserTokensSql;
    
    private boolean createTableOnStartup;
    
    @Override
    protected void initDao() {
        if (this.createTableOnStartup) {
            getJdbcTemplate().execute(this.getCreateTableSql());
        }
    }
    
    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        getJdbcTemplate()
                .update(this.getInsertTokenSql(), token.getUsername(), token.getSeries(), token.getTokenValue(), token.getDate());
    }
    
    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        getJdbcTemplate()
                .update(this.getUpdateTokenSql(), tokenValue, lastUsed, series);
    }
    
    /**
     * Loads the token data for the supplied series identifier.
     * <p>
     * If an error occurs, it will be reported and null will be returned (since the result
     * should just be a failed persistent login).
     *
     * @param seriesId
     * @return the token matching the series, or null if no match found or an exception
     * occurred.
     */
    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            return getJdbcTemplate().queryForObject(this.getTokensBySeriesSql(), this::createRememberMeToken, seriesId);
        }
        catch (EmptyResultDataAccessException ex) {
            this.logger.debug(LogMessage.format("Querying token for series '%s' returned no results.", seriesId), ex);
        }
        catch (IncorrectResultSizeDataAccessException ex) {
            this.logger.error(LogMessage.format(
                    "Querying token for series '%s' returned more than one value. Series" + " should be unique",
                    seriesId));
        }
        catch (DataAccessException ex) {
            this.logger.error("Failed to load token for series " + seriesId, ex);
        }
        return null;
    }
    
    private PersistentRememberMeToken createRememberMeToken(ResultSet rs, int rowNum) throws SQLException {
        return new PersistentRememberMeToken(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
    }
    
    @Override
    public void removeUserTokens(String username) {
        getJdbcTemplate().update(this.getRemoveUserTokensSql(), username);
    }
    
    public String getTablePrefix() {
        if (tablePrefix == null) {
            return "";
        }
        return tablePrefix;
    }
    
    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
    
    private String getCreateTableSql() {
        return "create table " + this.getTablePrefix() + "persistent_logins (" +
                "username varchar(64) not null, series varchar(64) primary key, token varchar(64) not null, last_used timestamp not null)";
    }
    
    private String getTokensBySeriesSql() {
        return "select username,series,token,last_used from " + this.getTablePrefix() + "persistent_logins where series = ?";
    }
    
    private String getInsertTokenSql() {
        return "insert into " + this.getTablePrefix() + "persistent_logins (username, series, token, last_used) values(?,?,?,?)";
    }
    
    private String getUpdateTokenSql() {
        return "update " + this.getTablePrefix() + "persistent_logins set token = ?, last_used = ? where series = ?";
    }
    
    private String getRemoveUserTokensSql() {
        return "delete from " + this.getTablePrefix() + "persistent_logins where username = ?";
    }
    
    /**
     * Intended for convenience in debugging. Will create the persistent_tokens database
     * table when the class is initialized during the initDao method.
     *
     * @param createTableOnStartup set to true to execute the
     */
    public void setCreateTableOnStartup(boolean createTableOnStartup) {
        this.createTableOnStartup = createTableOnStartup;
    }
    
}
