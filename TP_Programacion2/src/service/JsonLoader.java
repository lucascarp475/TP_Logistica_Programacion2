package service;

import com.google.gson.Gson;

import modelo.Paquete;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonLoader {

    public static List<Paquete<String>> cargar() {
        try {
            Gson gson = new Gson();
            Paquete<String>[] arr = gson.fromJson(
                new FileReader("src/service/inventario.json"),
                Paquete[].class
            );
            return Arrays.asList(arr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}