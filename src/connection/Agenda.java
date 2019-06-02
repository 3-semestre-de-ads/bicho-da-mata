package connection;

import java.sql.Connection;

public class Agenda {

	public static void main(String[] args) {
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
		}else {
			System.out.println("nao foi possivel conectar");
		}

	}

}
