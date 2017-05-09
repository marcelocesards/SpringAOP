package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAOPessoas {
	public void persistir(Pessoa[] pessoas, File arquivo) throws IOException {
		if (pessoas == null || pessoas.length == 0) {
			throw new IllegalArgumentException("Lista de pessoas nula ou vazia");
		}
		if (arquivo == null) {
			throw new IllegalArgumentException("Arquivo nulo como parametro");
		}
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
		oos.writeObject(pessoas);
		oos.close();
	}

	public Pessoa[] ler(File arquivo) throws IOException {		
		Pessoa[] resultado = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
			resultado = (Pessoa[]) ois.readObject();
		} catch (Exception ex) {
			throw new IllegalArgumentException("Erro ao ler arquivo. ClassNotFoundException", ex);
		}
		return resultado;
	}
}
