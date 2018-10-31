package br.ifsp.poo.farmacia.modelo.entidade;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	private static MessageDigest algorithm;

	public static void inicializa() throws Exception {
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex1) {
			throw new Exception("Erro ao criptografar.");
		}
	}

	public static String criptografarSenha(String senha) throws Exception {
		
		byte messageDigest[] = null;
		try {
			messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Exception("Padrão UTF-8 é desconhecido.");
		}
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
	}

}
