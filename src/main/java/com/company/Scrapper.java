package main.java.com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scrapper {

    final static String trendingHTML ="https://github.com/trending";
    static ArrayList<Project> projects = new ArrayList<>();
    static int size;

    public static void getTrendingProjects(String html, int number){

        try{
            Document doc = Jsoup.connect(html).timeout(50000).get();
            Elements e = doc.select("article.Box-row");
            size = e.size();
            for (Element ele:e
                 ) {

              String info =ele.select("h1.h3.lh-condensed").text();
              String[] parts = info.split("/");
              String organization = parts[0];
              String name = parts[1];



              String stars = ele.select("a.muted-link.d-inline-block.mr-3").text();
              String[] numbers = stars.split(" ");
              String star = numbers[0];
              String fork = numbers[1];



              Elements span = ele.select("span.d-inline-block.mr-3");
              Elements nested = span.select("a.d-inline-block");
              ArrayList<String> contributors = new ArrayList<>();
              for(Element element : nested){
                    String contributor = element.attr("href");
                    contributors.add(contributor);
              }

              Project p = new Project(organization, name, Integer.parseInt(star.replaceAll(",","")), Integer.parseInt(fork.replaceAll(",", "")), contributors);
              projects.add(p);
            }

            if(projects.size()>=number){
            List<Project> pro = projects.subList(0, number);
            projects = new ArrayList(pro);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }




    public static void writeToCSVFile() throws IOException{

        BufferedWriter csvWriter = new BufferedWriter(new FileWriter("ProjectDetails.csv"));

        for (Project p:projects
             ) {
            csvWriter.append("Organization: "+p.organization);
            csvWriter.append("\n");
            csvWriter.append("Project name: "+p.name);
            csvWriter.append("\n");
            csvWriter.append("Stargazer: "+p.starGazer);
            csvWriter.append("\n");
            csvWriter.append("Forks: "+p.forks);
            csvWriter.append("\n");
            csvWriter.append("Contributors: "+ p.mainContributors);
            csvWriter.append("\n");
            csvWriter.append("\n");

        }
        csvWriter.flush();
        csvWriter.close();

    }

    public static void getProjects (String spokenLanguage, String language, String dateRange, int number) {
        try {
            String html = trendingHTML + "/" + language + "?since=" + dateRange + "&spoken_language_code=" + spokenLanguage;
            getTrendingProjects(html, number);
            writeToCSVFile();
        }catch (IOException e){
            e.printStackTrace();
        }



    }

    public static ArrayList<Project> getList(){
        return projects;
    }





    public static void main(String[] args) {

        getProjects("en", "python", "monthly", 10);

    }



}
