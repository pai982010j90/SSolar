
import Modelo.SistemaSolar;
import Modelo.Planeta;
import SistemaSolar.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.Integer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSistemaSolar {

    public static void main(String[] args) {
        //SistemaSolarMapaGen sistemaSolar = inicializa();
        SistemaSolar sistemaSolar = null;

        Integer[] opciones = {0, 1, 2, 3, 4, 5};
        do {
            muestraMenu();
            int opcion = getOpcion(opciones);

            if (opcion == 0) {
                break;
            }

            controlador(opcion, sistemaSolar);
        } while (true);



        /*
        
        //System.out.println(sistemaSolar.getPlanetas());
        Map<String, Planeta> planetas = sistemaSolar.getPlanetas();
        
        
        muestraTodosLosPlanetas(planetas);
        
        System.out.println(planetas.get(1));
        planetas.remove(1);
        System.out.println(planetas.get(1));
        System.out.println(planetas.get("Venus"));
        
        Planeta venus = planetas.get("Venus");
        System.out.println(venus);
         */
    }

    public static SistemaSolar inicializa() {
        SistemaSolar sistemaSolar = new SistemaSolar();

        Planeta mercurio = new Planeta("Mercurio", 3.302E23, 4878, 57909175);
        sistemaSolar.addPlaneta("Mercurio", mercurio);
        sistemaSolar.addPlaneta("Venus", new Planeta("Venus", 4.8690E24, 12102, 108208930));
        Planeta tierra = new Planeta("Tierra", 5.9742E24, 12756, 149597870);
        sistemaSolar.addPlaneta("Tierra", tierra);
        Planeta marte = new Planeta("Marte", 6.4191E23, 6794, 227936640);
        sistemaSolar.addPlaneta("Marte", marte);
        Planeta jupiter = new Planeta("Jupiter", 1.8987E27, 142984, 778412010);
        sistemaSolar.addPlaneta("Jupiter", jupiter);
        Planeta saturno = new Planeta("Saturno", 5.6851E26, 120534, 1426725400);
        sistemaSolar.addPlaneta(marte.getNombre(), marte);
        Planeta urano = new Planeta("Urano", 8.6849E25, 51114, 2.8709E6);
        sistemaSolar.addPlaneta(urano.getNombre(), urano);
        Planeta neptuno = new Planeta("Neptuno", 1.0244E26, 49532, 4.4982E6);
        sistemaSolar.addPlaneta(neptuno.getNombre(), neptuno);

        return sistemaSolar;
    }

    public static void muestraTodosLosPlanetas(Map<String, Planeta> planetas, PrintStream flujo) {
        //Set planetas = sistemaSolar.getPlanetas(); con HashSet
        //System.out.println(planetas);
        //Iterator i = planetas.Keyset().iterator();//obtienes los valores del Key o llaves del Mapa
        Iterator i = planetas.values().iterator();//obtienes los valores de los valores del Mapa
        //itera o muestra todos los elementos uno por uno
        while (i.hasNext()) {//Iterador solo para Set y List 
            //Itera o busca en la clase Planeta Transformalo al objeto planetaAux
            Planeta planetaAux = (Planeta) i.next();
            //cuando planetaAux sea igual a Venus Visualizalo
            if (planetaAux.getNombre().equals("Venus")) {
                flujo.println(planetaAux);//Visualiza
                break;
            } else {
                flujo.println("no es Venus");
            }

        }
    }

    public static void muestraMenu() {
        System.out.println("MENU");
        System.out.println("1. Muestra todos los planetas.");
        System.out.println("2. Busca un planeta");
        System.out.println("3. Salva el sistema Solar a un fichero de texto");
        System.out.println("4. Serializa");
        System.out.println("5. Deserializa");

    }

    public static int getOpcion(Integer[] opciones) {

        //Set setOpciones = new HashSet(opciones);
        //Set<T> mySet = new HashSet<T>(Arrays.asList<T>(someArray));
        Set<Integer> mySet = new HashSet<Integer>(Arrays.asList(opciones));


        System.out.println("Elige opcion (" + opciones + ")");
        String opcion = null;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do {
            try {
                try {
                    opcion = br.readLine();
                } finally {
                    // isr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TestSistemaSolar.class.getName()).log(Level.SEVERE, null, ex);
            }
            if ((mySet.contains(Integer.parseInt(opcion)) == false)) {
                System.out.println("Opcion no valida");
                opcion = null;
            }

        } while (opcion == null);



        return Integer.parseInt(opcion);


    }

    public static void controlador(int opcion, SistemaSolar sSolar) {
        switch (opcion) {
            case 1:
                muestraTodosLosPlanetas(sSolar.getPlanetas(), System.out);
                break;
            case 3:
                FileWriter fw = null;
                try {
                    try {
                        fw = new FileWriter("f.txt");
                        //OutputStreamWriter sow = new OutputStreamWriter(fw);
                        //muestraTodosLosPlanetas(sSolar.getPlanetas(), fw);


                        fw.write(sSolar.toString());
                    } finally {
                        if (fw != null) {
                            fw.close();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TestSistemaSolar.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case 4:
                ObjectOutputStream oos = null;
                try {
                    try {
                        FileOutputStream fos = new FileOutputStream("salida.ser");
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(sSolar);
                    } finally {
                        oos.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TestSistemaSolar.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 5:
                ObjectInputStream ois = null;
                try {
                    try {
                        FileInputStream fos = new FileInputStream("salida.ser");
                        ois = new ObjectInputStream(fos);
                        sSolar = (SistemaSolar) ois.readObject();
                    } finally {
                        ois.close();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(TestSistemaSolar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(TestSistemaSolar.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }
    }
}
