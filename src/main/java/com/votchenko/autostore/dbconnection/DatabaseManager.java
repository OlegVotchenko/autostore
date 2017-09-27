package com.votchenko.autostore.dbconnection;

public interface DatabaseManager {
    Object getDatabase();
    void disconnect();

}
