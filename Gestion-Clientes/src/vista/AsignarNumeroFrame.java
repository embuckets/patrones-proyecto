
package vista;

import controlador.AsignarNumeroMainController;
import controlador.ClienteDTO;
import controlador.NumeroDTO;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author emilio
 */
public class AsignarNumeroFrame extends javax.swing.JFrame {
	private DatosClienteDisplayer datosClienteDisplayer;
	private NumerosClienteDisplayer numerosClienteDisplayer;
	/**
	 * Creates new form AsignarNumeroFrame
	 */
	public AsignarNumeroFrame() {
		initComponents();
		initObservers();
	}

	private void initObservers() {
		AsignarNumeroMainController mainController = AsignarNumeroMainController.getInstance();
		this.datosClienteDisplayer = new DatosClienteDisplayer(datosNombreLabel, datosPaternoLabel,
				datosMaternoLabel);
		mainController.addObserver(datosClienteDisplayer);
		this.numerosClienteDisplayer = new NumerosClienteDisplayer(numerosTable);
		mainController.addObserver(numerosClienteDisplayer);

	}

	private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarButtonActionPerformed
		String nombre = nombreTextField.getText();
		String paterno = paternoTextField.getText();
		String materno = maternoTextField.getText();

		AsignarNumeroMainController mainController = AsignarNumeroMainController.getInstance();
		boolean success = mainController.buscarCliente(nombre, paterno, materno);
		if (!success) {
			JOptionPane.showMessageDialog(rootPane, "No existe el cliente", "No se encontro al cliente", ERROR);
			this.numerosClienteDisplayer.reset();
			this.datosClienteDisplayer.reset();
		}

	}// GEN-LAST:event_buscarButtonActionPerformed

	private void agregarNumeroButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarButtonActionPerformed
		AsignarNumeroMainController mainController = AsignarNumeroMainController.getInstance();
		mainController.buscarNumeroDisponible();

	}// GEN-LAST:event_buscarButtonActionPerformed

	private void borrarNumeroButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarButtonActionPerformed
		int row = numerosTable.getSelectedRow();
		int column = numerosTable.getSelectedColumn();
		String numero = (String) numerosTable.getValueAt(row, column);

		AsignarNumeroMainController mainController = AsignarNumeroMainController.getInstance();
		mainController.darDeBajaNumero(numero);

	}// GEN-LAST:event_buscarButtonActionPerformed

	private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarButtonActionPerformed
		// regresar pagina anterior
	}// GEN-LAST:event_buscarButtonActionPerformed

	private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarButtonActionPerformed
		AsignarNumeroMainController mainController = AsignarNumeroMainController.getInstance();
		mainController.guardarCambios();

	}// GEN-LAST:event_buscarButtonActionPerformed

	private class DatosClienteDisplayer implements Observer {

		private JLabel nombre;
		private JLabel paterno;
		private JLabel materno;

		public DatosClienteDisplayer(JLabel nombre, JLabel paterno, JLabel materno) {
			this.nombre = nombre;
			this.paterno = paterno;
			this.materno = materno;
		}

		@Override
		public void update(Observable o, Object arg) {
			AsignarNumeroMainController controller = (AsignarNumeroMainController) o;
			ClienteDTO clienteDTO = controller.getCliente();
			nombre.setText(clienteDTO.getNombre());
			paterno.setText(clienteDTO.getPaterno());
			materno.setText(clienteDTO.getMaterno());
		}
		
		public void reset() {
			nombre.setText("");
			paterno.setText("");
			materno.setText("");
		}

	}

	private class NumerosClienteDisplayer implements Observer {

		private JTable numerosTable;

		public NumerosClienteDisplayer(JTable table) {
			numerosTable = table;
		}

		@Override
		public void update(Observable o, Object arg) {
			AsignarNumeroMainController controller = (AsignarNumeroMainController) o;
			ClienteDTO clienteDTO = controller.getCliente();
			String registrado = "registrado";
			String porRegistrar = "por registrar";
			String porCancelar = "por cancelar";

			Vector<Vector> datos = new Vector<Vector>();

			ArrayList<NumeroDTO> numerosRegistrados = clienteDTO.getNumerosRegistrados();
			for (NumeroDTO numero : numerosRegistrados) {
				Vector<String> row = new Vector<String>();
				row.add(registrado);
				row.add(numero.getNumeroFormatted());
				datos.add(row);
			}

			ArrayList<NumeroDTO> numerosPorRegistrar = clienteDTO.getNumerosPorAsignar();
			for (NumeroDTO numero : numerosPorRegistrar) {
				Vector<String> row = new Vector<String>();
				row.add(porRegistrar);
				row.add(numero.getNumeroFormatted());
				datos.add(row);
			}

			ArrayList<NumeroDTO> numerosPorCancelar = clienteDTO.getNumerosPorCancelar();
			for (NumeroDTO numero : numerosPorCancelar) {
				Vector<String> row = new Vector<String>();
				row.add(porRegistrar);
				row.add(numero.getNumeroFormatted());
				datos.add(row);
			}

			Vector<String> headers = new Vector<String>();
			headers.add("Estatus");
			headers.add("Numero");
			TableModel tableModel = new DefaultTableModel(datos, headers);
			this.numerosTable.setModel(tableModel);
		}
		
		public void reset() {
			Object[][] data = {{null}};
			Object[] headers = {"Estatus, Numero"};
			TableModel tableModel = new DefaultTableModel(data, headers);
			this.numerosTable.setModel(tableModel);
		}

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buscarPanel = new javax.swing.JPanel();
		buscarNombreLabel = new javax.swing.JLabel();
		buscarPaternoLabel = new javax.swing.JLabel();
		buscarMaternoLabel = new javax.swing.JLabel();
		maternoTextField = new javax.swing.JTextField();
		nombreTextField = new javax.swing.JTextField();
		paternoTextField = new javax.swing.JTextField();
		buscarButton = new javax.swing.JButton();
		resultadosPanel = new javax.swing.JPanel();
		datosPanel = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		datosNombreLabel = new javax.swing.JLabel();
		datosPaternoLabel = new javax.swing.JLabel();
		datosMaternoLabel = new javax.swing.JLabel();
		numerosPanel = new javax.swing.JPanel();
		botonesPanel = new javax.swing.JPanel();
		agregarNumeroButton = new javax.swing.JButton();
		borrarNumeroButton = new javax.swing.JButton();
		tablaScrollPanel = new javax.swing.JScrollPane();
		numerosTable = new javax.swing.JTable();
		guardarButton = new javax.swing.JButton();
		cancelarButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		buscarPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Cliente",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Dialog", 1, 18))); // NOI18N

		buscarNombreLabel.setText("Nombre");

		buscarPaternoLabel.setText("Apellido Paterno");

		buscarMaternoLabel.setText("Apellido Materno");

		maternoTextField.setText("jTextField1");

		nombreTextField.setText("jTextField1");

		paternoTextField.setText("jTextField1");

		buscarButton.setText("Buscar");
		buscarButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buscarButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout buscarPanelLayout = new javax.swing.GroupLayout(buscarPanel);
		buscarPanel.setLayout(buscarPanelLayout);
		buscarPanelLayout.setHorizontalGroup(buscarPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buscarPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(buscarMaternoLabel).addComponent(buscarPaternoLabel)
								.addComponent(buscarNombreLabel))
						.addGap(18, 18, 18)
						.addGroup(buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(buscarPanelLayout.createSequentialGroup()
										.addComponent(paternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(165, 165, 165).addComponent(buscarButton))
								.addComponent(maternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		buscarPanelLayout.setVerticalGroup(buscarPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(buscarPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buscarNombreLabel).addComponent(nombreTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buscarPaternoLabel)
								.addComponent(paternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(buscarButton))
						.addGap(18, 18, 18)
						.addGroup(buscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(buscarMaternoLabel).addComponent(maternoTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		datosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Dialog", 1, 18))); // NOI18N

		jLabel4.setText("Nombre:");

		jLabel5.setText("Apellido Paterno");

		jLabel6.setText("Apellido Materno");

		datosNombreLabel.setText("");

		datosPaternoLabel.setText("");

		datosMaternoLabel.setText("");

		javax.swing.GroupLayout datosPanelLayout = new javax.swing.GroupLayout(datosPanel);
		datosPanel.setLayout(datosPanelLayout);
		datosPanelLayout.setHorizontalGroup(datosPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(datosPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(datosPanelLayout.createSequentialGroup().addComponent(jLabel6)
										.addGap(18, 18, 18).addComponent(datosNombreLabel))
								.addGroup(datosPanelLayout.createSequentialGroup()
										.addGroup(datosPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5).addComponent(jLabel4))
										.addGap(22, 22, 22)
										.addGroup(datosPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(datosPaternoLabel).addComponent(datosMaternoLabel))))
						.addContainerGap()));
		datosPanelLayout.setVerticalGroup(datosPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(datosPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(datosMaternoLabel))
						.addGap(18, 18, 18)
						.addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(datosPaternoLabel))
						.addGap(18, 18, 18)
						.addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(datosNombreLabel))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		numerosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numeros del Cliente",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Dialog", 1, 18))); // NOI18N

		agregarNumeroButton.setText("Agregar");
		agregarNumeroButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				agregarNumeroButtonActionPerformed(evt);
			}
		});

		borrarNumeroButton.setText("Borrar");
		borrarNumeroButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				borrarNumeroButtonActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout botonesPanelLayout = new javax.swing.GroupLayout(botonesPanel);
		botonesPanel.setLayout(botonesPanelLayout);
		botonesPanelLayout
				.setHorizontalGroup(botonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(botonesPanelLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(botonesPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(agregarNumeroButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(borrarNumeroButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));
		botonesPanelLayout
				.setVerticalGroup(botonesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(botonesPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(agregarNumeroButton).addGap(18, 18, 18).addComponent(borrarNumeroButton)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		numerosTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null } },
				new String[] { "Numero", "Estado" }));
//		{
//			Class[] types = new Class[] { java.lang.String.class };
//			boolean[] canEdit = new boolean[] { false };
//
//			public Class getColumnClass(int columnIndex) {
//				return types[columnIndex];
//			}
//
//			public boolean isCellEditable(int rowIndex, int columnIndex) {
//				return canEdit[columnIndex];
//			}
//		});
		tablaScrollPanel.setViewportView(numerosTable);

		javax.swing.GroupLayout numerosPanelLayout = new javax.swing.GroupLayout(numerosPanel);
		numerosPanel.setLayout(numerosPanelLayout);
		numerosPanelLayout.setHorizontalGroup(
				numerosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						numerosPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(tablaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 297,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(botonesPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		numerosPanelLayout.setVerticalGroup(numerosPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(numerosPanelLayout.createSequentialGroup()
						.addComponent(botonesPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(numerosPanelLayout
						.createSequentialGroup().addContainerGap().addComponent(tablaScrollPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout resultadosPanelLayout = new javax.swing.GroupLayout(resultadosPanel);
		resultadosPanel.setLayout(resultadosPanelLayout);
		resultadosPanelLayout
				.setHorizontalGroup(resultadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(resultadosPanelLayout.createSequentialGroup()
								.addComponent(datosPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(numerosPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		resultadosPanelLayout.setVerticalGroup(resultadosPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(datosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(numerosPanel, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		guardarButton.setText("Guardar");
		guardarButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				guardarButtonActionPerformed(evt);
			}
		});

		cancelarButton.setText("Cancelar");
		cancelarButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelarButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(resultadosPanel, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(buscarPanel, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(cancelarButton).addGap(18, 18, 18).addComponent(guardarButton)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(buscarPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(resultadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(guardarButton).addComponent(cancelarButton))
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AsignarNumeroFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AsignarNumeroFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AsignarNumeroFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AsignarNumeroFrame.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AsignarNumeroFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton agregarNumeroButton;
	private JButton borrarNumeroButton;
	private JPanel botonesPanel;
	private JButton buscarButton;
	private JLabel buscarMaternoLabel;
	private JLabel buscarNombreLabel;
	private JPanel buscarPanel;
	private JLabel buscarPaternoLabel;
	private JButton cancelarButton;
	private JPanel datosPanel;
	private JButton guardarButton;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel datosNombreLabel;
	private JLabel datosPaternoLabel;
	private JLabel datosMaternoLabel;
	private JTextField maternoTextField;
	private JTextField nombreTextField;
	private JPanel numerosPanel;
	private JTable numerosTable;
	private JTextField paternoTextField;
	private JPanel resultadosPanel;
	private JScrollPane tablaScrollPanel;
	// End of variables declaration//GEN-END:variables
}