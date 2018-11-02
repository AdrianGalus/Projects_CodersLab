package workshop2.utils;

import workshop2.models.Solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Query {

    public static void main(String[] args) {

        Solution sol = new Solution(1, 1);
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/programming_school?useTimezone=true&serverTimezone=GMT" +
                "&useSSL=false&characterEncoding=utf8",
                "root",
                "coderslab")) {

            System.out.println(sol.getCreated());
            System.out.println(sol.getUpdated());
            sol.saveToDB(conn);
            Solution.loadById(conn, 1);
            Solution[] test = Solution.loadAllSolutions(conn);
            System.out.println(sol.getCreated());
            sol.delete(conn);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
/*
CREATE DATABASE programming_school
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
 */
/*
CREATE TABLE user_group (
    id INT(11) AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
 */
/*
CREATE TABLE users (
    id BIGINT(20) AUTO_INCREMENT,
    username VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(245),
    user_group_id INT(11),
    PRIMARY KEY (id),
    FOREIGN KEY (user_group_id)
        REFERENCES user_group (id)
        ON DELETE CASCADE
);
 */
/*
CREATE TABLE exercise (
    id INT(11) AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT,
    PRIMARY KEY (id)
);
 */
/*
CREATE TABLE solution (
    id INT(11) AUTO_INCREMENT,
    created DATETIME,
    updated DATETIME,
    description TEXT,
    exercise_id INT(11),
    users_id BIGINT(20),
    PRIMARY KEY (id),
    FOREIGN KEY (exercise_id)
        REFERENCES exercise (id)
        ON DELETE CASCADE,
    FOREIGN KEY (users_id)
        REFERENCES users (id)
        ON DELETE CASCADE
);
 */