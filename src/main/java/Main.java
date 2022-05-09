import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    static int kilepes = 10;
    static ArrayList<patient> betegek = readPatientsFromXml("src/main/resources/patients.xml");
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] a) {
        lehetosegek();
    }
    public static void lehetosegek(){
        out.println("\nLehetőségek: \n1: Betegek listázása.\n2: Beteg felvétele.\n3: Beteg törlése.\n4: Módosítás.\n5: Keresés.\n6: Mentés.\n7: Mentés és Kilépés.\n");
        out.print("A Döntés: ");
        String a = sc.nextLine();
        if(a.equals("1")){
            listazas();
        }
        else if(a.equals("2")){
            hozzaad();
        }
        else if(a.equals("3")){
            torles();
        }
        else if(a.equals("4")){
            frissites();
        }
        else if(a.equals("5")){
            kereses();
        }
        else if(a.equals("6")){
            savePatientsToXml(betegek, "src/main/resources/patients.xml");
        }
        else if(a.equals("7")){
            kilepes = 65; savePatientsToXml(betegek, "src/main/resources/patients.xml");
        }
        else {
            out.println("\nA LEHETŐSÉGEK KÖZÜL KELL VÁLASZTANI!\n");enter();lehetosegek();
        }
    }
    public static void enter(){
        System.out.println("Nyomja le az ENTER-t a folytatáshoz...");
        try{System.in.read();}
        catch(Exception e){}
    }
    public static void listazas(){
        int i = 0;
        while(i != betegek.size()){
            patient beteg = betegek.get(i);
            out.printf("\n%d. beteg: \n", i+1);
            out.println("Azonosítója: " + beteg.getTaj() + "\nNeve: " + beteg.getName()+ "\nSzületésnapja: " + beteg.getBirthYear() + "\nKezelés kezdete: " + beteg.getKezeleskezdete() +"\nBetegségének neve: " + beteg.getBetegsegneve() + "\n");
            i++;
        }
        enter();
        lehetosegek();
    }
    public static void hozzaad(){
        out.print("Beteg azonosítója: ");
        String taj = sc.nextLine();
        out.print("Beteg neve: ");
        String nev = sc.nextLine();
        out.print("Beteg születési dátum: ");
        String by = sc.nextLine();
        out.print("Beteg kezelésének kezdete: ");
        String kezd = sc.nextLine();
        out.print("Beteg betegsége: ");
        String betegseg = sc.nextLine();
        patient beteg = new patient(taj, nev, by, kezd, betegseg);
        betegek.add(beteg);
        out.println("\nBETEG SIKERESEN FELVÉVE!\n");
        enter();
        lehetosegek();
    }
    public static void torles(){
        out.println("Eltávolítandó beteg azonosítója: ");
        String i = sc.nextLine();
        int k = 0;
        for(int j = 0; j < betegek.size(); j++){
            if(betegek.get(j).getTaj().equals(i)){
                betegek.remove(j);
                k = 1;
                out.println("\nBETEG SIKERESEN ELTÁVOLÍTVA!\n");
                enter();
                lehetosegek();
            }
            else if(j == (betegek.size()-1) && k != 1){
                out.println("\nBETEG SIKERTELENÜL ELTÁVOLÍTVA!\n");
                enter();
                lehetosegek();
            }
        }
    }
    public static void frissites(){
        out.print("\nFrissítendő beteg azonosítója: ");
        String i = sc.nextLine();
        int k = 0;
        for(int j = 0; j < betegek.size(); j++){
            if(betegek.get(j).getTaj().equals(i)) {
                patient beteg = betegek.get(j);
                out.print("\nA beteg frissíthető adatai: \n 1: Azonosítója\n 2: Neve\n 3: Születési dátum\n 4: Kezelés kezdete\n 5: Betegségének neve\nVálasztás: ");
                String b = sc.nextLine();
                if(b.equals("1")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    beteg.setTaj(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("2")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    beteg.setName(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("3")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    beteg.setBirthYear(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("4")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    beteg.setKezeleskezdete(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("5")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    beteg.setBetegsegneve(x);
                    enter();
                    lehetosegek();
                }
                else{
                    out.println("\nA LEHETŐSÉGEK KÖZÜL KELL VÁLASZTANI!\n");enter();lehetosegek();
                }
            }
            else if(j == (betegek.size()-1) && k != 1){
                out.println("\nBETEG SIKERTELENÜL MÓDOSÍTVA!\nNINCS TALÁLAT A BETEGRE\n");
                enter();
                lehetosegek();
            }
        }

    }
    public static void kereses(){
        out.println("Keresett beteg azonosítója: ");
        String i = sc.nextLine();
        int k = 0;
        for(int j = 0; j < betegek.size(); j++){
            if(betegek.get(j).getTaj().equals(i)){
                k = 1;
                patient beteg = betegek.get(j);
                out.print("\nBETEG MEGTALÁLVA!\n");
                out.println("\nAzonosítója: " + beteg.getTaj() + "\nNeve: " + beteg.getName()+ "\nSzületési dátum: " + beteg.getBirthYear() + "\nKezelés kezdete: " + beteg.getKezeleskezdete() +"\nBetegségének neve: " + beteg.getBetegsegneve() + "\n");
            }
            else if(j == (betegek.size()-1) && k != 1){
                out.printf("\nA KERESETT BETEG NINCS A LISTÁN!\n");
            }
        }
        enter();
        lehetosegek();
    }

    public static ArrayList<patient> readPatientsFromXml(String filepath) {
        ArrayList<patient> betegek = new ArrayList<>();
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filepath);
            Element rootElement = document.getDocumentElement();
            NodeList childNodesList = rootElement.getChildNodes();
            Node node;
            for (int i = 0; i < childNodesList.getLength(); i++) {
                node = childNodesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childNodesOfUserTag = node.getChildNodes();
                    String taj = "", name = "", birthYear = "", kezeleskezdete = "", betegsegneve = "";
                    for (int j = 0; j < childNodesOfUserTag.getLength(); j++) {
                        if (childNodesOfUserTag.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            switch (childNodesOfUserTag.item(j).getNodeName()) {
                                case "taj" : taj = childNodesOfUserTag.item(j).getTextContent();
                                case "name" : name = childNodesOfUserTag.item(j).getTextContent();
                                case "birthYear" : birthYear = childNodesOfUserTag.item(j).getTextContent();
                                case "kezeleskezdete" : kezeleskezdete = childNodesOfUserTag.item(j).getTextContent();
                                case "betegsegneve" : betegsegneve = childNodesOfUserTag.item(j).getTextContent();
                            }
                        }
                    }
                    betegek.add(new patient(taj, name, birthYear, kezeleskezdete, betegsegneve));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return betegek;
    }

    public static void savePatientsToXml(ArrayList<patient> betegek, String filepath) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("betegek");
            document.appendChild(rootElement);
            for (patient beteg : betegek) {
                Element beteg1 = document.createElement("beteg");
                rootElement.appendChild(beteg1);
                createChildElement(document, beteg1, "taj", beteg.getTaj());
                createChildElement(document, beteg1, "name", beteg.getName());
                createChildElement(document, beteg1, "birthYear",beteg.getBirthYear());
                createChildElement(document, beteg1, "kezeleskezdete",beteg.getKezeleskezdete());
                createChildElement(document, beteg1, "betegsegneve", beteg.getBetegsegneve());
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(filepath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("\nSIKERES MENTÉS!\n");
        if(kilepes == 65){
            System.exit(68);
        }
        else {
            enter();
            lehetosegek();
        }
    }

    private static void createChildElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setTextContent(value);
        parent.appendChild(element);
    }
}
