/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import dao.DocenteDAO;
import dao.EstudianteDAO;
import dao.ProfesionDAO;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Profesion;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.math.BigDecimal;
import java.time.LocalDate;
/**
 *
 * @author ibane
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    private final ProfesionDAO profesionDAO = new ProfesionDAO();
    private final DocenteDAO docenteDAO = new DocenteDAO();
    private final EstudianteDAO estudianteDAO = new EstudianteDAO();
    /**
     * Creates new form VentanaPrincipal
     */
public VentanaPrincipal() {
    initComponents();

    // centrar la ventana y título
    setLocationRelativeTo(null);
    setTitle("Personas / Docentes / Estudiantes");

    // Configurar el JList con un modelo editable
    jList1.setModel(new DefaultListModel<>());

    // Cargar profesiones desde BD
    cargarProfesiones();

    // Conectar botones con la lógica
    btnAdd.addActionListener(evt -> agregarProfesion());
    btnDoc.addActionListener(evt -> guardarDocente());
    btnEst.addActionListener(evt -> guardarEstudiante());
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        lstProf = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProf = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Alta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCarnet = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        btnDoc = new javax.swing.JButton();
        btnEst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personas / Docentes / Estudiantes");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nueva profesión:");

        txtProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout lstProfLayout = new javax.swing.GroupLayout(lstProf);
        lstProf.setLayout(lstProfLayout);
        lstProfLayout.setHorizontalGroup(
            lstProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lstProfLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(lstProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lstProfLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lstProfLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnAdd)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        lstProfLayout.setVerticalGroup(
            lstProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lstProfLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(lstProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(35, 35, 35)
                .addGroup(lstProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profesión", lstProf);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Código Docente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Apellidos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Salario Docente:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Carnet Estudiante:");

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        txtCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarnetActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        btnDoc.setText("Guardar como Docente");
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });

        btnEst.setText("Guardar como Estudiante");
        btnEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AltaLayout = new javax.swing.GroupLayout(Alta);
        Alta.setLayout(AltaLayout);
        AltaLayout.setHorizontalGroup(
            AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(btnDoc))
                .addGap(44, 44, 44)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCarnet)
                    .addComponent(txtApellidos)
                    .addComponent(txtNombres)
                    .addComponent(txtCodigo)
                    .addComponent(txtSalario)
                    .addComponent(btnEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(671, Short.MAX_VALUE))
        );
        AltaLayout.setVerticalGroup(
            AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AltaLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(AltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alta", Alta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// ==== Llena el JList con las profesiones desde la BD ====
private void cargarProfesiones(){
    try {
        DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
        model.clear();
        for (Profesion pr : profesionDAO.listar()) {
            model.addElement(pr.getIdProfesion() + ": " + pr.getProfesion());
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        logger.log(java.util.logging.Level.SEVERE, "Error cargando profesiones", ex);
    }
}

// ==== Agrega una profesión nueva ====
private void agregarProfesion(){
    String nombre = txtProf.getText().trim();
    if (nombre.isEmpty()){
        JOptionPane.showMessageDialog(this, "Ingresa una profesión");
        return;
    }
    try {
        profesionDAO.crear(new Profesion(null, nombre));
        txtProf.setText("");
        cargarProfesiones();
    } catch (Exception ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        logger.log(java.util.logging.Level.SEVERE, "Error guardando profesión", ex);
    }
}

// ==== Guarda un Docente ====
private void guardarDocente(){
    try {
        Docente d = new Docente(
                null,
                "CF",  // nit de ejemplo
                txtNombres.getText(),
                txtApellidos.getText(),
                null, null, LocalDate.now(), true,
                txtCodigo.getText(),
                new BigDecimal(txtSalario.getText()),
                1 // id_profesion ejemplo
        );
        docenteDAO.crear(d);
        JOptionPane.showMessageDialog(this, "Docente guardado");
    } catch (Exception ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        logger.log(java.util.logging.Level.SEVERE, "Error guardando docente", ex);
    }
}

// ==== Guarda un Estudiante ====
private void guardarEstudiante(){
    try {
        Estudiante es = new Estudiante(
                null,
                "CF",  // nit de ejemplo
                txtNombres.getText(),
                txtApellidos.getText(),
                null, null, LocalDate.now(), true,
                txtCarnet.getText()
        );
        estudianteDAO.crear(es);
        JOptionPane.showMessageDialog(this, "Estudiante guardado");
    } catch (Exception ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        logger.log(java.util.logging.Level.SEVERE, "Error guardandobtnEstActionPerformed estudiante", ex);
    }
}
    private void txtProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfActionPerformed
        // TODO add your handling code here:btnAddActionPerformed
    }//GEN-LAST:event_txtProfActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        agregarProfesion();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarnetActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        guardarDocente();
    }//GEN-LAST:event_btnDocActionPerformed

    private void btnEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstActionPerformed
        guardarEstudiante();
    }//GEN-LAST:event_btnEstActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Alta;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnEst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel lstProf;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCarnet;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtProf;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
