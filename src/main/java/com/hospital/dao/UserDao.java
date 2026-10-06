package com.hospital.dao;
import com.hospital.teleexpertise.model.User;
import com.hospital.teleexpertise.model.Role;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    public void save(){
        String sql = "Insert into user (name , etc ) Values (?,? etc)";

        try(Connection con = Data)
    }
}