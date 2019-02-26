package com.example.kryptonote;

public class CipherModel
{
    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CipherModel (String k)
    {
        this.key = k;
    }

    private String makePad(String note)
    {
        String pad = this.key;
        for (; pad.length() < note.length(); )
        {
            pad += this.key;
        }
        return pad;
    }

    public String encrypt(String note)
    {
        String pad = makePad(note);
        String result = "";
        for (int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1));
            int newPosition = (position + shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }

    public String decrypt(String note)
    {
        String pad = makePad(note);
        String result = "";
        for (int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1));
            int newPosition = position - shift;
            if (newPosition < 0)
            {
                newPosition = ALPHABET.length() - newPosition;
            }
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }

   /* public static void main(String[] args)
    {
        String testKey = "1234";
        CipherModel testModel = new CipherModel(testKey);

        String testNote = "THIS IS A TEST";

        String encryptedNote = testModel.encrypt(testNote);

        String decryptedNote = testModel.decrypt(encryptedNote);

        System.out.println(encryptedNote);

        System.out.println(decryptedNote);
    }*/
}
