package com.example.user.dao;
import com.example.user.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public abstract class UserDAO implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3308/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456789";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    private static final String SEARCH_USERS_BY_COUNTRY = "select * from users where country = ?";
    private static final String SORT_USERS_BY_NAME = "select * from users  order by name DESC;";

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATE_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE" + "(" + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15,2) NOT NULL,"
            + " CREATE_DATE timestamp,"
            + " PRIMARY KEY (ID)" + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<User> sortByName() {
        //Bước 1: Thiết lập kết nối
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_BY_NAME);) {
            System.out.println(preparedStatement);
            // Step 3:Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public List<User> selectAllUsers() {
        //Sử dụng Try-With-Resources để tránh đóng tài nguyên (Mã tấm nồi hơi)
        List<User> users = new ArrayList<>();
        //Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3:Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchUserByCountry(String inputCountry) {
        List<User> result = new ArrayList<>();
        //Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
//        Bước 2: Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_COUNTRY);) {
            preparedStatement.setString(1, inputCountry);
            System.out.println(preparedStatement);
//        Bước 3: Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();
//        Bước 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                System.err.println(rs.getInt("id"));
                System.err.println(rs.getString(rs.getInt("id")));
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                User user = new User(id, name, email, country);
                result.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println("test: " + result.size());
        return result;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setInt(1, id);

// Thực hiện truy vấn hoặc cập nhật truy vấn
            ResultSet rs = callableStatement.executeQuery();
//             Bước 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
//        Tuyên bố thử-với tài nguyên sẽ tự động đóng kết nối

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permission) {
        Connection connection = null;
//        Để chèn người dùng mới
        PreparedStatement pstmt = null;
//        Để được chỉ định cho người dùng [Để được chỉ định cho người dùng]
        PreparedStatement pstmtAssignment = null;
//        Để nhận ID người dùng
        ResultSet rs = null;
        try {
            connection = getConnection();
// Đặt tự động cam kết sai
            connection.setAutoCommit(false);
            // Chèn người dùng
            pstmt = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();
            //get user id
            rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next())
                userId = rs.getInt(1);
            // Trong trường hợp hoạt động chèn thành công, hãy gán cho người dùng
            if (rowAffected == 1) {
                // gán phép cho người dùng
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
                        + "VALUES(?,?)";
                pstmtAssignment = connection.prepareStatement(sqlPivot);
                for (int permisionId : permission) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            // Quay lại giao dịch
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (pstmtAssignment != null) pstmtAssignment.close();
                    if (connection != null) connection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            // Run list of update commands
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection conn = getConnection();
             Statement statement = conn.createStatement();
             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);
            // start transactions block
            conn.setAutoCommit(false); // default true
            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            // Run list of update commands
            // below line caused error, test transactions
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
            // end transactions block, commit changes
            conn.commit();
            // good practice to set it back to default true
            conn.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<User> viewAllUsersStore() {
        String query = "{call view_all_users()}";
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try (Connection conn = getConnection(); CallableStatement callableStatement = conn.prepareCall(query)) {
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }

        return userList;
    }

    @Override
    public boolean UpdateUserSP(User user) throws SQLException {
        String query = "call update_user_store_procedure(?,?,?,?)";
        boolean rowUpdated =false;
//        Để nhận ID người dùng
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {

            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
            rowUpdated = (callableStatement.executeUpdate() >0 );
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteSP(int id) throws SQLException {
        boolean rowDeleted;
        String query =  "call delete_user_store_procedure(?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


    @Override
    public User selectUser(int id) {
        User user = null;
//        Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
//        Bước 2: Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
//        Bước 3: Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();
//        Bước 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
}
