//package com.example.demo.dao.tourist;
//
//import com.example.demo.dao.tourist.com.example.demo.dao.interfaces.TouristDAO;
//import com.example.demo.datastorage.DataStorageJDBC;
//import com.example.demo.model.Tourist;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class TouristDAOJDBSImpl implements TouristDAO {
//
//    @Autowired
//    DataStorageJDBC dataStorageFake;
//
//    List<Tourist> tourists = new ArrayList<>();
//
//    @Override
//    public Tourist insert(Tourist tourist) {
//        return null;
//    }
//
//    @Override
//    public Tourist update(int id) {
//        return null;
//    }
//
//    @Override
//    public Tourist delete(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Tourist> getAll() throws SQLException, IOException {
//        tourists.clear();
//        ResultSet rs = null;
//        rs = dataStorageFake.init().executeQuery("SELECT * FROM tourist");
//
//        while (rs.next()) {
//            tourists.add(new Tourist(rs.getInt("id"),
//                            rs.getString("name"),
//                            rs.getInt("age"),
//                            rs.getInt("gender_id"),
//                            rs.getDate("date_of_birth"),
//                            rs.getInt("group_id"),
//                            rs.getInt("type_of_tourist_id"),
//                            rs.getInt("difficulty_level_id"),
//                    )
//            )
//
//        }
//    }
//}
