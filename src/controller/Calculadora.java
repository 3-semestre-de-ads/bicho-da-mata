package controller;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculadora {

	public static void calcular(JTextField concentracaoFarmaco, JTextField doseFarmaco, JTextField pesoAnimal, JComboBox<String> unidadeDose, JComboBox<String> unidadeConcentracao, JLabel resultado) {
		try {
			double n1 = Double.parseDouble(concentracaoFarmaco.getText());
			double n2 = Double.parseDouble(doseFarmaco.getText());
			double n3 = Double.parseDouble(pesoAnimal.getText());
			double peso = 0, dose = 0, concentracao = 0;
			double Medicacao = 0;

			if (n1 == 0 || n2 == 0 || n3 == 0)
			{
				JOptionPane.showMessageDialog(null, "Campos Inválidos");
			}
			else
			{
				peso = Double.parseDouble(pesoAnimal.getText());
				dose = Double.parseDouble(doseFarmaco.getText());
				concentracao = Double.parseDouble(concentracaoFarmaco.getText());

				if (peso <= 0 || dose <= 0 || concentracao <= 0)
					JOptionPane.showMessageDialog(null, "Impossível realizar calculos com números negativos");
				else
				{
					if (unidadeDose.getSelectedItem() == "Mg" && unidadeConcentracao.getSelectedItem() == "G")
					{
						Medicacao = (peso * dose) / (1000 / concentracao);
					}
					else if (unidadeDose.getSelectedItem() == "Mg" && unidadeConcentracao.getSelectedItem() == "Mg")
					{
						Medicacao = (peso * dose) / concentracao;
					}
					else if (unidadeDose.getSelectedItem() == "Mg" && unidadeConcentracao.getSelectedItem() == "Mcg")
					{
						Medicacao = (peso * dose) / (concentracao * 0.001);
					}
					else if (unidadeDose.getSelectedItem() == "Mg" && unidadeConcentracao.getSelectedItem() == "%")
					{
						Medicacao = (peso * dose) / (concentracao * 10);
					}
					else if (unidadeDose.getSelectedItem() == "Mcg" && unidadeConcentracao.getSelectedItem() == "G")
					{
						Medicacao = (peso * (dose * 0.001)) / (1000 / concentracao);
					}
					else if (unidadeDose.getSelectedItem() == "Mcg" && unidadeConcentracao.getSelectedItem() == "Mg")
					{
						Medicacao = (peso * (dose * 0.001)) / concentracao;
					}
					else if (unidadeDose.getSelectedItem() == "Mcg" && unidadeConcentracao.getSelectedItem() == "Mcg")
					{
						Medicacao = (peso * (dose * 0.001)) / (concentracao * 0.001);
					}
					else if (unidadeDose.getSelectedItem() == "Mcg" && unidadeConcentracao.getSelectedItem() == "%")
					{
						Medicacao = (peso * (dose * 0.001)) / (concentracao * 10);
					}
					if (unidadeConcentracao.getSelectedItem() == "" || unidadeDose.getSelectedItem() == "")
					{
						JOptionPane.showMessageDialog(null, "Unidades Inválidas!");
					}
					else
						resultado.setText(Medicacao + "ML");
				}
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro de conversão!");
		}
	}
}
