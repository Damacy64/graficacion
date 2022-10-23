package graficacion;

/**
 *
 * @author pzx64
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.lang.Math;

public class BSpline extends JFrame implements ActionListener{
    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Inicio");

    LienzoS lienzo = new LienzoS();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        BSpline i = new BSpline();//se llama al constructor del frame
    }

    public BSpline() throws IOException//crear el constructor del frame
    {
        super("Entramado");//Asi se llama al constructor de una clase extendida
        maxX = 1000;
        maxY = 500;
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu1);//agrega los menus 1 y 3 a la barra de menu
        menu1.add(it1);// agrega items al menu 1

        icon = new ImageIcon("mia.jpg").getImage();//crear un icono con el archivo de entrada 
        //organiza componentes en paneles
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(lienzo, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        //mueve el frame a la posicion indicada y establece el tamaño
        setBounds(100, 100, maxX + 100, maxY + 100);
        setIconImage(icon);//Agrega icono a la barra de menu
        setVisible(true);//Hace visible al frame
    }

    //manejador de eventos
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        //si se elige el menu 1-1
        if (object == it1) {
            dibuja(lienzo.getGraphics());
        }
    }

    public void dibuja(Graphics g) {
        g.clearRect(0, 0, maxX, maxY);
        g.drawLine(50, 50, 500, 50);
        g.drawLine(500, 50, 500, 500);
        g.drawLine(500, 500, 50, 500);
        g.drawLine(50, 500, 50, 50);
        g.setColor(Color.RED);
        for(int i=50,j=100;i<500;i+=50,j+=50){
            g.drawLine(50, i, j, 500);
        }
        g.setColor(Color.BLUE);
        for(int i=50,j=100;i<500;i+=50,j+=50){
            g.drawLine(i, 50, 500, j);
        }
    }
    public boolean handleEvent(Event e) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(e);
    }
};

class LienzoS extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
