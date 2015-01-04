package parking.business;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonathan on 04/01/2015.
 */
public class ParkingIHM extends JFrame {

    public ParkingIHM() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Parking");
        setLayout(new BorderLayout());

        setJMenuBar(barreMenus());

        pack();
        setVisible(true);
    } //  ParkingIHM()



    private JMenuBar barreMenus() {
        JMenuBar barre = new JMenuBar();
        barre.add(creerMenuFichier());
        return barre;
    } // barreMenus()

    private JMenu creerMenuFichier() {
        JMenu menuFichier = new JMenu("Fichier");
        menuFichier.add(creerMenuFichierQuitter());
        return menuFichier;
    } // creerMenuFichier()

    private JMenuItem creerMenuFichierQuitter() {
        JMenuItem menu = new JMenuItem("Quitter");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuFichierQuitter();
            }

        });
        return menu;
    } // creerMenuFichierQuitter()

    private void actionMenuFichierQuitter() {
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter ?"))
            System.exit(0);
    } // actionMenuFichierQuitter()


    public static void main(String[] args) {
        new ParkingIHM();
    } // main()


} // ParkingIHM
