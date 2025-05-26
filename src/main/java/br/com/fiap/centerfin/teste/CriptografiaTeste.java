package br.com.fiap.centerfin.teste;

import br.com.fiap.centerfin.util.CriptografiaUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class CriptografiaTeste {

    public static void main(String[] args)  {
        try {

            System.out.println(CriptografiaUtils.criptografar("12345"));
            System.out.println(CriptografiaUtils.criptografar("12345"));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
