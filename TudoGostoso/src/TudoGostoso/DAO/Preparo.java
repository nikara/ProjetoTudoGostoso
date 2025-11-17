package TudoGostoso.DAO;

import TudoGostoso.model.Preparo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import java.sql.SQLException;

public class Preparo {
    Connection connection = DAO.createConnection();

    try{
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO preparo ")
    }
}
