package Utils;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String nombre;
    private List<Pais>InfoCSV;
    public List<Pais>PaisesRegion;

    public Region(String nombre) {
        this.nombre = nombre;
        this.InfoCSV = new ArrayList<>();
        this.PaisesRegion = new ArrayList<>();
    }

    public void Calculos (){
        try{
            CsvReader leerPais = new CsvReader("C:\\Users\\jcfun\\IdeaProjects\\ProyectoFinal\\world-happiness-report-2021.csv");
            leerPais.readHeaders();

            while (leerPais.readRecord()){
                String Country_name = leerPais.get(0);

                String Regional_indicator = leerPais.get(1);

                String Social_support = leerPais.get(7);
                double SocialS = Double.parseDouble(Social_support);

                String Healthy_life_expectancy = leerPais.get(8);
                double Healthy = Double.parseDouble(Healthy_life_expectancy);

                String Freedom_to_make_life_choices = leerPais.get(9);
                double Fredom = Double.parseDouble(Freedom_to_make_life_choices);

                String Generosity = leerPais.get(10);
                double Generosi = Double.parseDouble(Generosity);

                String Perceptions_of_corruption = leerPais.get(11);
                double PerceptionC = Double.parseDouble(Perceptions_of_corruption);

                this.getInfoCSV().add(new Pais(Country_name,Regional_indicator,SocialS,Healthy,Fredom,Generosi,PerceptionC));
            }

            leerPais.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


        //AREA DE CALCULOS

        //this.PaisesRegion.add(new Pais("Denmark","Western Europe",7.620,0.135,9.687,7.552,7.833));
        //this.PaisesRegion.add(new Pais("Finlan","Western Europe",5.620,0.735,7.327,1.752,3.933));
        //this.PaisesRegion.add(new Pais("Honduras","Western Europe",8.20,1.035,1.237,11.2,15.933));

        for (Pais p: getInfoCSV()) {
            if(p.getRegional_indicator() == nombre){
                this.PaisesRegion.add(p);
            }
        }

        System.out.println("Calculos de la Region: " + nombre);

        double v=0,w=0,x=0,y=0,z=0,mayorPer=0,mayorGe=0;

        for (Pais s: this.PaisesRegion) {
            v += s.getSocial_support();
            w += s.getHealthy_life_expectancy();
            x += s.getFreedom_to_make_life_choices();
            y += s.getGenerosity();
            z += s.getPerceptions_of_corruption();

            if(s.getPerceptions_of_corruption()>mayorPer){
                mayorPer = s.getPerceptions_of_corruption();
            }

            if(s.getGenerosity()>mayorGe){
                mayorGe = s.getGenerosity();
            }
        }

        for (Pais t: this.PaisesRegion) {
            if (t.getPerceptions_of_corruption()==mayorPer){
                System.out.println("País con la más alta percepción de corrupción: " + t.getCountry_name());
            }

            if (t.getGenerosity() == mayorGe){
                System.out.println("País con la mas alta generosidad: " + t.getCountry_name());
            }
        }

        System.out.println("Promedio de Social support: " + (v/ PaisesRegion.size()) );
        System.out.println("Promedio de Healthy life expectancy: " + (w/ PaisesRegion.size()));
        System.out.println("Promedio de Freedom to make life choices: " + (x/ PaisesRegion.size()));
        System.out.println("Promedio de Generosity: " + (y/ PaisesRegion.size()));
        System.out.println("Promedio de Perceptions of corruption: " + (z/ PaisesRegion.size()));

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pais> getInfoCSV() {
        return InfoCSV;
    }

    public void setInfoCSV(List<Pais> infoCSV) {
        InfoCSV = infoCSV;
    }
}
