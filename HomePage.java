/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientudp;

import static clientudp.ClientUDP.port;
import static clientudp.LoginPageGui.jTextField1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import javax.swing.*;

/**
 *
 * @author traynau2
 */

public class HomePage extends javax.swing.JFrame {
    DefaultListModel<String> listedesamis=new DefaultListModel<String>();
    DefaultListModel<String> listedesinvitationsenvoyees=new DefaultListModel<String>();
    DefaultListModel<String> listedesinvitationsrecues=new DefaultListModel<String>();
    DefaultListModel<String> listebloques=new DefaultListModel<String>();
    DefaultListModel<String> listedesmessages=new DefaultListModel<String>();
    static final int port = 6010 ;
    DatagramSocket socket;
    DatagramPacket envoye, recu;
    InetAddress address;
    
    //faire fonctionner la liste des amis => ajouter selon les informations que l'on reçoit du serveur
    
    public static String toSend2() {
        return listeamisinvitants.getSelectedValue();
    }
    
    
    public static String toSend() {
      return listeamis.getSelectedValue();
    }
    
    
    public static String removefirstChar(String str)
    {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(1);
    }
 
  //fonction envoie paquet (fonctionne)
    public void envoi(String msg) throws UnknownHostException, SocketException, IOException {
        int msglen = msg.length() ;
        byte [] message = new byte [1024] ; //1024 evite des pb selon la version
        message = msg.getBytes() ;
        envoye = new DatagramPacket(message, msglen, address, port) ;
        socket.send(envoye) ;
        System.out.println("\nLe message envoye => "+msg);
    }
    //fonction recoit paquet  (fonctionne)
    public String recu() throws UnknownHostException, SocketException, IOException {
        byte[] buf = new byte[1024];
        recu = new DatagramPacket(buf, buf.length);
        socket.receive(recu);
        String rcvd = "Message recu du serveur : " + recu.getAddress() + ", au port : " + recu.getPort();
        System.out.println(rcvd);
        return new String(recu.getData(), 0, recu.getLength());
    }
    
    /**
     * Creates new form HomePage
     */
    //constructeur
    public HomePage() throws UnknownHostException, SocketException {
        initComponents();
        address = InetAddress.getByName("127.0.0.1") ;
        socket = new DatagramSocket() ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listeamisinvitants = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeamis = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeamisinvites = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listedesbloques = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        deconnexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Invitations d'amis reçues :");

        jScrollPane3.setViewportView(listeamisinvitants);

        jButton5.setText("Accepter");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Refuser");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listeamis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listeamis);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Liste des amis :");

        jButton2.setText("Bloquer");

        jButton3.setText("Contacter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Ajouter un(e) ami :");

        jButton1.setText("+");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Invitations envoyées :");

        listeamisinvites.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listeamisinvites);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setForeground(new java.awt.Color(0, 102, 51));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Liste bloqués :");

        jScrollPane4.setViewportView(listedesbloques);

        jButton4.setText("Débloquer");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(20, 20, 20))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deconnexion.setText("déconnexion");
        deconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deconnexion)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        listeamis.setModel(listedesamis);
        //listeamisinvites.setModel(listedesinvitationsenvoyees);
        listeamisinvitants.setModel(listedesinvitationsrecues);
        listedesbloques.setModel(listebloques);
        
        final Runnable task = () -> { //permet de lancer cette partie à intervalle de temps
        try {
            //quand on est connecté des demande de mise a jour de l'interface ont lieu (message etc ... voir serv et phrase recue)
            envoi("update@"+LoginPageGui.myName()); //mise a jour de l'utilisateur en ligne
            String s = "";
            s = recu();
            String t[]=s.split("@"); //découpage
            System.out.println(s);
            for (int i =1 ; i<t.length ; i+=2){ //premier cas si 1:voici ami 3:voici bloque 5:voici les demandes pour toi
                if(i==1){
                if(!(t[i].equals("[]"))){
                        String texte=t[i].substring(1,t[i].length()-1);
                        //System.out.println(texte);
                        String w[]=texte.split(",");//on redécoupe à virgule pour voir les amis
                        for (int j =0 ; j<w.length ; j++){
                            if (j>0){
                                String g=removefirstChar(w[j]);//enever premier caractère car c'est un espace dans tt sauf premiere requete (0)
                                if(!(listedesamis.contains(g))){//pevite d'avoir 2 fois même amis dans liste
                                    listedesamis.addElement(removefirstChar(w[j]));
                                }
                                //System.out.println(removefirstChar(w[j]));
                            }else{
                                if(!(listedesamis.contains(w[j]))){
                                    listedesamis.addElement(w[j]);
                                }

                            }
                        }
                }else{
                    System.out.println(i);
                }
                }else if(i==3){//même fonctionnement sauf pour la liste des bloqués
                    if(!(t[i].equals("[]"))){
                        String texte=t[i].substring(1,t[i].length()-1);
                        String w[]=texte.split(",");
                        for (int j =0 ; j<w.length ; j++){
                            if (j>0){
                                String g=removefirstChar(w[j]);
                                if(!(listebloques.contains(g))){
                                    listebloques.addElement(removefirstChar(w[j]));
                                }
                                //System.out.println(removefirstChar(w[j]));
                                //listebloques.addElement(removefirstChar(w[j]));
                            }else{
                                if(!(listebloques.contains(w[j]))){
                                    listebloques.addElement(w[j]);
                                }
                                //System.out.println(w[j]);
                                //listebloques.addElement(w[j]);
                            }
                        }
                } else {
                    System.out.println(i);
                }
                }else if(i==5){//idem
                    if(!(t[i].equals("[]"))){
                        String texte=t[i].substring(1,t[i].length()-1);
                        String w[]=texte.split(",");
                        for (int j =0 ; j<w.length ; j++){
                            if (j>0){
                                String g=removefirstChar(w[j]);
                                if(!(listedesinvitationsrecues.contains(g))){
                                    listedesinvitationsrecues.addElement(removefirstChar(w[j]));
                                }
                                //System.out.println(removefirstChar(w[j]));
                                //listedesinvitationsrecues.addElement(removefirstChar(w[j]));
                            }else{
                                if(!(listedesinvitationsrecues.contains(w[j]))){
                                    listedesinvitationsrecues.addElement(w[j]);
                                }
                                //System.out.println(w[j]);
                                //listedesinvitationsrecues.addElement(w[j]);
                            }
                        }
                } else {
                    System.out.println(i);
                }
                }
            }  
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        };//; > obligatoire
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(task,0,10,TimeUnit.SECONDS);//déclaration des 1à secondes d'intervalle
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//ajout d'amis et vérification si cet ami est deja dans la liste de l'utilisateur qd appuie sur bouton
        try {
            boolean bo =false;
            listeamisinvites.setModel(listedesinvitationsenvoyees);
            envoi("ami@demande@"+LoginPageGui.myName()+"@"+jTextField1.getText().trim());
            String recu=recu();
            System.out.println(recu);
            
            if(listedesinvitationsenvoyees.contains(jTextField1.getText().trim()) || listedesinvitationsenvoyees.size()>9 ||listedesamis.contains(jTextField1.getText().trim()) ){
                System.out.println("test");
                bo =true;
            }
            
            if(recu.equals("Demande envoyee") && bo==false){
                listedesinvitationsenvoyees.addElement(jTextField1.getText().trim());
            } else {
                    JOptionPane.showMessageDialog(null, "Cet ami ne peut etre ajoute");
            }
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);//affiche erreur qd erreur, si requete echoue
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //afficher les message d'un utilisateur
        
        try {

            MessagePage mp = new MessagePage();
            mp.setVisible(true);
            mp.pack();
            mp.setLocationRelativeTo(null);//center page
            mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();//delete l'ancienne page
            //add if car peut rien sélectionner et bug (si requete contient rien pas d'affichage
            MessagePage.Liste.setModel(listedesmessages);
            String data=new String(MessagePage.Data.getText());
            try {
                envoi("lecture@"+LoginPageGui.myName()+"@"+toSend());
                String s = "";
                s = recu();
                String t[]=s.split("@");
                for(int j=1;j<t.length;j++){
                    String k=t[j];
                    String split[]=k.split("/");
                    if(split[0].equals(LoginPageGui.myName())){ //selon la premiere partie de la chaine on déduit l'expéditeur si == user connecté
                        listedesmessages.addElement("J'ai envoyé : "+split[1]);
                        listedesmessages.addElement("_____________________________________________________________________________________________________");
                    }else{
                        listedesmessages.addElement("envoie de : "+split[0]+" => message : "+split[1]);
                        listedesmessages.addElement("_____________________________________________________________________________________________________");
                    //séparer messages
                    }
                    
                }

        } catch (SocketException ex) {
            Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessagePage.class.getName()).log(Level.SEVERE, null, ex);
        }    
        } catch (UnknownHostException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void deconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionActionPerformed
        // TODO add your handling code here:
        String txt="deconnexion@"+LoginPageGui.myName();//mettre la déconnexion, forme de requete
        
        try {
            envoi(txt);
            if (recu().equals("stop user")){
                LoginPageGui lp = new LoginPageGui();
                lp.setVisible(true);//on affiche la page de déconnexion, côté serveur le traitement se fait
                lp.pack();
                lp.setLocationRelativeTo(null);//center page
                lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();//delete l'ancienne page
            }
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_deconnexionActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:        accept ami selectionne
            envoi("ami@accept@"+LoginPageGui.myName()+"@"+toSend2());
            String recu=recu();
            if(recu.equals("Demande acceptee")){//selon le message de retour du serveur sait le traitement
                for(int i=0;i<listedesinvitationsrecues.size();i++){
                    if(toSend2()==listedesinvitationsrecues.get(i)){
                        listedesinvitationsrecues.removeElementAt(i);
                    }
                }
            }
            System.out.println(recu);
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            envoi("ami@refus@"+LoginPageGui.myName()+"@"+toSend2());
            String recu=recu();
            //permet de refuser demande d'amis,  refus de la liste des amis (cote client et serveur après la comprehesion du serv)
            if(recu.equals("Demande refusee")){
                for(int i=0;i<listedesinvitationsrecues.size();i++){
                    if(toSend2().equals(listedesinvitationsrecues.get(i))){
                        listedesinvitationsrecues.removeElementAt(i);
                    }
                }
            }
            //System.out.println(recu);
        } catch (SocketException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        ///////////
        //envoyer requête pour récupérer les amis
        //recevoir la requête et la traiter
        //afficher dans les boites
        //refresh à intervalle régulier => quand clique sur user voir les messages qui lui sont associés
        //
        //ajout ami : requete vers serv et recevoir puis ajout dans la liste d'attente
        //qd recoit les amis au début et refresh, voir aussi les amis qui m'ont add
        //
        //////////
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomePage().setVisible(true);//affiche la page
                } catch (UnknownHostException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SocketException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deconnexion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private static javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JList<String> listeamis;
    private static javax.swing.JList<String> listeamisinvitants;
    private javax.swing.JList<String> listeamisinvites;
    private javax.swing.JList<String> listedesbloques;
    // End of variables declaration//GEN-END:variables
}
