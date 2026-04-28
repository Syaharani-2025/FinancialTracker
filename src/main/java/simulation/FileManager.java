/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class FileManager {
     // name of the file where data will be saved
    private static final String FILE_NAME = "transactions.json";
    private static Gson gson = new Gson();
    
    // SAVE transactions to JSON file
    public static void saveTransactions(List<Transactions> transactions) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(transactions, writer);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    
    // LOAD transactions from JSON file
    public static List<Transactions> loadTransactions() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Transactions>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

   
    
}
