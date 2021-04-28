package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
   /* public List<Pais>infoPais;
    public LectorCSV() {
        this.infoPais = new ArrayList<>();
    }

    public void ImportarCSV(){

        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\jcfun\\IdeaProjects\\ProyectoFinal\\world-happiness-report-2021.csv"));
            String line = null;

            while ((line = reader.readLine()) != null){
                String [] parts = line.split(",");
                String Country_name = parts[0];
                String Regional_indicator = parts[1];
                String Social_support = parts[7];
                String Healthy_life_expectancy = parts[8];
                String Freedom_to_make_life_choices = parts[9];
                String Generosity = parts[10];
                String Perceptions_of_corruption = parts[11];
                //this.infoPais.add(new Pais(Country_name,Regional_indicator,Social_support,Healthy_life_expectancy,Freedom_to_make_life_choices,Generosity,Perceptions_of_corruption)); // Añade la informacion a la lista

            }
        }catch (IOException e){
            e.printStackTrace();
        }

        for (Pais p: infoPais) {
            if(p.getCountry_name()=="Ghana"){
                System.out.println(p.getCountry_name() + " " + p.getRegional_indicator());
            }
            System.out.println(p.getCountry_name() + " " + p.getRegional_indicator());
        }

    }

    */


}
